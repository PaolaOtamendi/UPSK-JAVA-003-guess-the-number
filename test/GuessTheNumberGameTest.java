import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GuessTheNumberGameTest {

    @Test
    public void testPlayMakeGuess() { // Este test asegura que se ejecute correctamente makeGuess
        GuessTheNumberGame game = new GuessTheNumberGame();

        Player humanPlayer = Mockito.mock(HumanPlayer.class);
        Mockito.when(humanPlayer.makeGuess()).thenReturn(5);

        game.playGame(humanPlayer);

        verify(humanPlayer).makeGuess();
    }

    @Test
    public void testHumanWins() { // Test verifica cuando el humano gana
        GuessTheNumberGame.targetNumber = 42;
        HumanPlayer humanPlayer = Mockito.mock(HumanPlayer.class);

        Mockito.when(humanPlayer.makeGuess()).thenReturn(42);
        Mockito.when(humanPlayer.getGuesses()).thenReturn(List.of(42));

        boolean result = GuessTheNumberGame.checkGuess(humanPlayer);

        assertTrue(result);
    }

    @Test
    public void testHumanLost() { // Test verifica cuando el humano pierde
        GuessTheNumberGame.targetNumber = 42;
        HumanPlayer humanPlayer = Mockito.mock(HumanPlayer.class);

        Mockito.when(humanPlayer.makeGuess()).thenReturn(30);
        Mockito.when(humanPlayer.getGuesses()).thenReturn(List.of(30));

        boolean result = GuessTheNumberGame.checkGuess(humanPlayer);

        assertFalse(result);
    }

    @Test
    public void testComputerWins() { // Test verifica cuando la computadora gana
        GuessTheNumberGame.targetNumber = 75;
        ComputerPlayer computerPlayer = Mockito.mock(ComputerPlayer.class);

        Mockito.when(computerPlayer.makeGuess()).thenReturn(75);
        Mockito.when(computerPlayer.getGuesses()).thenReturn(List.of(50, 75));

        boolean result = GuessTheNumberGame.checkGuess(computerPlayer);

        assertTrue(result);
    }

    @Test
    public  void testComputerLost() { // Test verifica cuando la computadora pierde
              GuessTheNumberGame.targetNumber = 75;
              ComputerPlayer computerPlayer = Mockito.mock(ComputerPlayer.class);

        Mockito.when(computerPlayer.makeGuess()).thenReturn(30);
        Mockito.when(computerPlayer.getGuesses()).thenReturn(List.of(50, 30));

        boolean result = GuessTheNumberGame.checkGuess(computerPlayer);

        assertFalse(result);
    }

    @Test
    public void testGameLost() { // Test verifica nadie gana
        GuessTheNumberGame.targetNumber = 30;
        HumanPlayer humanPlayer = Mockito.mock(HumanPlayer.class);

        Mockito.when(humanPlayer.makeGuess()).thenReturn(10, 20, 25, 35, 40);
        Mockito.when(humanPlayer.getGuesses()).thenReturn(List.of(10, 20, 25, 35, 40));

        assertFalse(GuessTheNumberGame.checkGuess(humanPlayer));
    }

    @Test
    public void testTotalGuesses() { // Test verifica la cantidad de juegos sean 5
        GuessTheNumberGame game = new GuessTheNumberGame();
        HumanPlayer humanPlayer = Mockito.mock(HumanPlayer.class);

        Mockito.when(humanPlayer.makeGuess())
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);

        for(int i=0; i<5; i++) {
            game.playGame(humanPlayer);
        }

        verify(humanPlayer, times(5)).makeGuess();
    }
}

