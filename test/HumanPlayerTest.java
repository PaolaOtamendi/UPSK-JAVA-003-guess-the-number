import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    @Test
    public void makeGuess() {
        HumanPlayer humanPlayer = new HumanPlayer("Player 1");
        Scanner scannerMock = Mockito.mock(Scanner.class);

        Mockito.when(scannerMock.nextInt()).thenReturn(30);
        humanPlayer.setScanner(scannerMock);

        int guess = humanPlayer.makeGuess();

        assertEquals(30, guess);
        assertEquals(List.of(30), humanPlayer.getGuesses());
    }

    @Test
    public void multipleGuess() {
        String input = "42\n75\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        HumanPlayer humanPlayer = new HumanPlayer("Player 1");
        humanPlayer.setScanner(scanner);

        humanPlayer.makeGuess();
        humanPlayer.makeGuess();
        humanPlayer.makeGuess();

        List<Integer> guesses = humanPlayer.getGuesses();
        assertEquals(3, guesses.size());
        assertEquals(List.of(42,75,10), guesses);
    }
}