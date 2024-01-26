import java.util.Scanner;
public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }
        // Metodo makeGuess para generar el juego
        public int makeGuess() {
            // Solicita el nombre al usuario
            /* System.out.println("Por favor ingresa tu nombre");
            String nombre = scanner.nextLine(); */

            // Solicita el numero al usuario
            System.out.println(getName() + " 😏 "  + " ingresa un numero entre el 01 y el 100: ");
            int guess = scanner.nextInt();
            getGuesses().add(guess);
            return guess;
        }

    }

