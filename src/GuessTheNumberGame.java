import java.util.Random;

public class GuessTheNumberGame {
    // Variable privada donde se guarda el numero aleatorio
    private static Random random = new Random();
    private static int targetNumber;

    public static void main(String[] args) {
        // Ejecuta el numero aleatorio y lo imprime en consola
        targetNumber = random.nextInt(100) + 1;
        System.out.println("Numero Aleatorio:" + targetNumber);

        // Inicia el juego
        startGame();
    }

    public static void startGame() {
        Player humanPlayer = new HumanPlayer("Player 1");
        playGame(humanPlayer);
    }


    private static void playGame(Player player) {
        int maxGuesses = 5;
        int guessesMade = 0;


        while (guessesMade < maxGuesses) {
            int guess = player.makeGuess();
            System.out.println("Juego de 🤹‍♂️: "+ player.getName() + " suposición: " + guess);
            guessesMade++;

            if(checkGuess(player, guess)) {
                System.out.println(player.getName() + " ha adivinado el número. ¡Felicidades!");
                break;
            } else {
                String result = (guess < targetNumber) ? "Muy baja 👎" : "Muy alta 🔥";
                System.out.println("Tu resultado fue: " + result + ". Intenta nuevamente.\n");
            }

            /*checkGuess(player, guess);*/
            System.out.println("Historial de suposiciones de " + player.getName() + ":" + player.getGuesses());
        }

        if (guessesMade == maxGuesses) {
            System.out.println("Se han agotado las suposiciones. El número correcto era: " + targetNumber);
        }
    }

    private  static boolean checkGuess(Player player, int guess) {
        return (guess == targetNumber);
    }

}