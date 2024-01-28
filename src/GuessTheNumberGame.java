import java.util.Random;

public class GuessTheNumberGame {
    // Variable privada donde se guarda el numero aleatorio
    private static Random random = new Random();
    private static int targetNumber;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        targetNumber = random.nextInt(100) + 1;
        System.out.println("Numero Aleatorio:" + targetNumber);

        Player humanPlayer = new HumanPlayer("Player 1 🤸‍♀️");
        Player computerPlayer = new ComputerPlayer("Computer player 👩‍💻");

        int maxGuesses = 5;
        boolean gameFin = false;

        for(int i = 0; i<maxGuesses; i++) {
            playGame(humanPlayer);
            if(checkGuess(humanPlayer)) {
                break;
            }

            playGame(computerPlayer);
            if(checkGuess(humanPlayer)) {
                break;
            }
        }

        if (!gameFin) {
            System.out.println("🛑 Haz agotado tus juegos. El número correcto era: " + targetNumber);
        }
    }


    private static void playGame(Player player) {
        int guess = player.makeGuess();
        System.out.println("Juego 🎯: "+ player.getName() + " suposición: " + guess);

        if(checkGuess(player)) {
            System.out.println(player.getName() + " Haz adivinado el número. ¡Felicidades! 🎉");
        } else {
            String result = (guess < targetNumber) ? "muy baja 👎" : "muy alta 🔥";
            System.out.println("La suposición fue " + result + ". Intenta nuevamente.\n");
        }

        System.out.println("🚥 Historial de suposiciones de " + player.getName() + ": " + player.getGuesses() + "\n");
    }

    private static boolean checkGuess(Player player) {
        return player.getGuesses().contains(targetNumber);
    }
}
