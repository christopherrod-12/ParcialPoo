import java.util.Random;
import java.util.Scanner;

public class JuegoLibre {
    // Juego: Adivina el número (1-50), 5 intentos
    public void start(Scanner sc) {
        Random r = new Random();
        int secret = r.nextInt(50) + 1;
        System.out.println("Juego: Adivina el número entre 1 y 50. Tienes 5 intentos.");
        int attempts = 5;
        for (int i = 1; i <= attempts; i++) {
            System.out.print("Intento " + i + " - Ingresa número: ");
            int guess;
            try {
                guess = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número no válido.");
                continue;
            }
            if (guess == secret) {
                System.out.println("¡Ganaste! Adivinaste el número: " + secret);
                return;
            } else if (guess < secret) {
                System.out.println("Más alto.");
            } else {
                System.out.println("Más bajo.");
            }
        }
        System.out.println("Perdiste. El número era: " + secret);
    }
}
