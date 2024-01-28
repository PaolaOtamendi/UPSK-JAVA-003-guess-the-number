import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(String name) {
        super(name);
        this.random = new Random();
    }

    public int makeGuess() {
        int guess = random.nextInt(100) + 1;
        getGuesses().add(guess);
        return guess;
    }
}
