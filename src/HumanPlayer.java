import java.util.Scanner;
public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }
        // Metodo makeGuess para generar el juego
        public int makeGuess() {
        int guess; //variable numerica
        do {
            // Solicita el numero al usuario
            System.out.println(getName() + " 😏 "  + " ingresa un numero entre el 01 y el 100: ");
            guess = scanner.nextInt();

        if(guess < 0 || guess > 100) { // Evalua el numero
            System.out.println("Por favor, ingresa un número válido entre 0 y 100.");
            }
        } while (guess < 0 || guess > 100);
            getGuesses().add(guess);
            return guess;
        }
    }

