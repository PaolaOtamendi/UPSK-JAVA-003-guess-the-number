import java.util.Random;

public class GuessTheNumberGame {
    // Variable privada donde se guarda el numero aleatorio
    protected static Random random = new Random();
    protected static int targetNumber;

    // Definir códigos ANSI para colores
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String PURPURA = "\033[0;35m";
    public static final String AZUL = "\033[0;34m";
    public static final String NEGRITA = "\033[1m";

    public static void main(String[] args) {
        startGame();
    }

        public static void startGame() {
            setTargetNumber();

            Player humanPlayer = new HumanPlayer(PURPURA + "Player 1 🤸‍♀️" + RESET);
            Player computerPlayer = new ComputerPlayer(AZUL + "Computer player 👩‍💻" + RESET);

            runGameLoop(humanPlayer, computerPlayer);

            System.out.println(NEGRITA + "Resultado final del juego:" + RESET);
            System.out.println(NEGRITA + "Número objetivo: " + RESET + GREEN + targetNumber + RESET);
            System.out.println(NEGRITA + "Suposiciones del jugador: " + RESET + GREEN + humanPlayer.getGuesses() + RESET);
            System.out.println(NEGRITA + "Suposiciones de la computadora: " + RESET + GREEN + computerPlayer.getGuesses() + RESET);

        }

    // Metodo para generar el numero aleatorio
    private static void setTargetNumber() {
        targetNumber = random.nextInt(100) + 1;
        /*System.out.println("Numero Aleatorio:" + targetNumber);*/
    }

    //Metodo que genera el loop y recorre las suposiciones
    private static void runGameLoop(Player humanPlayer, Player computerPlayer) {
        int maxGuesses = 5;
        boolean gameWon = false;

        for(int i = 0; i<maxGuesses; i++) {
            playGame(humanPlayer);
            if(checkGuess(humanPlayer)) {
                gameWon = true;
                break;
            }

            playGame(computerPlayer);
            if(checkGuess(computerPlayer)) {
                gameWon = true;
                break;
            }
        }

        if (!gameWon) {
            System.out.println(RED + "🛑 Haz agotado tus juegos. El número correcto era: " + targetNumber + "\n" + RESET);
        } else {
            System.out.println(YELLOW + "¡El juego ha sido ganado!" + "\n" + RESET);
        }
    }

    protected static void playGame(Player player) {
        int guess = player.makeGuess();
        System.out.println("Juego 🎯: "+ player.getName() + " suposición: " + GREEN + guess + RESET);

        if(checkGuess(player)) {
            System.out.println(player.getName() + YELLOW + " Haz adivinado el número. ¡Felicidades! 🎉" + "\n" + RESET);
        } else {
            String result = (guess < targetNumber) ? "muy baja 👎" : "muy alta 🔥";
            System.out.println(NEGRITA + "La suposición fue " + result + ". Intenta nuevamente.\n" + RESET);
        }
    }

    protected static boolean checkGuess(Player player) {
        boolean guessCorrect = player.getGuesses().contains(targetNumber);
        return guessCorrect;
    }

}
