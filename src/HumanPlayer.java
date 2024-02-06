import java.util.Scanner;
public class HumanPlayer extends Player {
    private Scanner scanner;

    // Definir códigos ANSI para colores
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";

    public HumanPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // Metodo makeGuess para generar el juego
        public int makeGuess() {
        int guess; //variable numerica
        do {
            // Solicita el numero al usuario
            System.out.println(getName() + " 😏 "  + " ingresa un numero entre el 01 y el 100: ");
            guess = scanner.nextInt();

        if(guess < 0 || guess > 100) { // Evalua el numero
            System.out.println(RED + "Por favor, ingresa un número válido entre 0 y 100." + RESET);
            }
        } while (guess < 0 || guess > 100);
            getGuesses().add(guess);
            return guess;
        }
    }

