import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    public void makeGuess() { // Test verifica que el numero random se genere dentro del los limites
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer Player");
        Random random = new Random();
        int guess = computerPlayer.makeGuess();
        assertTrue(guess >= 1 && guess <= 100);
    }

    @Test
    public void multipleGuess() { // Test para verificar las cantidad de suposiciones
        Random randomMock = Mockito.mock(Random.class);
        Mockito.when(randomMock.nextInt(100)).thenReturn(42, 75, 10);

        ComputerPlayer computerPlayer = new ComputerPlayer("Computer Player");

        computerPlayer.makeGuess();
        computerPlayer.makeGuess();
        computerPlayer.makeGuess();

        assertEquals(3, computerPlayer.getGuesses().size());
    }

}