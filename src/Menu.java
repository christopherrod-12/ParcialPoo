import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final Zodiac zodiac = new Zodiac();
    private final Validators validators = new Validators();
    private final MorseConverter morse = new MorseConverter();
    private final CaballeroManager manager = new CaballeroManager();
    private final JuegoLibre juego = new JuegoLibre();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Zodiaco por día/mes/año de nacimiento");
            System.out.println("2. Validador de mayoría de edad");
            System.out.println("3. Validador número primo");
            System.out.println("4. Validador número perfecto");
            System.out.println("5. Validador palíndromo (texto)");
            System.out.println("6. Validador capicúa (número)");
            System.out.println("7. Conversor de texto a morse");
            System.out.println("8. Conversor de morse a texto");
            System.out.println("9. Gestor de caballeros del zodiaco");
            System.out.println("10. Juego libre (Adivina número)");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");

            int opt = Integer.parseInt(sc.nextLine().trim());
            switch (opt) {
                case 1 -> zodiacFlow();
                case 2 -> majorityFlow();
                case 3 -> primeFlow();
                case 4 -> perfectFlow();
                case 5 -> palindromeFlow();
                case 6 -> capicuaFlow();
                case 7 -> textToMorseFlow();
                case 8 -> morseToTextFlow();
                case 9 -> caballeroMenu();
                case 10 -> juego.start(sc);
                case 11 -> {
                    running = false;
                    System.out.println("Saliendo... ¡Éxito en tu entrega!");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

    private void zodiacFlow() {
        System.out.print("Año de nacimiento: ");
        int y = Integer.parseInt(sc.nextLine());
        System.out.print("Mes (1-12): ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.print("Día: ");
        int d = Integer.parseInt(sc.nextLine());

        String sign = zodiac.getSign(d, m);
        String cab = zodiac.getCaballeroForSign(sign);
        int edad = zodiac.calculateAge(y, m, d);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Signo: " + sign);
        System.out.println("Caballero dorado asociado: " + cab);
    }

    private void majorityFlow() {
        System.out.print("Año de nacimiento: ");
        int y = Integer.parseInt(sc.nextLine());
        System.out.print("Mes (1-12): ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.print("Día: ");
        int d = Integer.parseInt(sc.nextLine());
        boolean isAdult = validators.isAdult(y, m, d);
        System.out.println(isAdult ? "Es mayor de edad." : "Es menor de edad.");
    }

    private void primeFlow() {
        System.out.print("Ingresa el número a validar: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(validators.isPrime(n) ? "Es primo." : "No es primo.");
    }

    private void perfectFlow() {
        System.out.print("Ingresa el número a validar: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(validators.isPerfect(n) ? "Es perfecto." : "No es perfecto.");
    }

    private void palindromeFlow() {
        System.out.print("Ingresa el texto: ");
        String s = sc.nextLine();
        System.out.println(validators.isPalindrome(s) ? "Es palíndromo." : "No es palíndromo.");
    }

    private void capicuaFlow() {
        System.out.print("Ingresa el número: ");
        String s = sc.nextLine().trim();
        System.out.println(validators.isCapicua(s) ? "Es capicúa." : "No es capicúa.");
    }

    private void textToMorseFlow() {
        System.out.print("Ingresa el texto: ");
        String text = sc.nextLine();
        System.out.println("Morse: " + morse.textToMorse(text));
    }

    private void morseToTextFlow() {
        System.out.print("Ingresa morse (separe con espacios y / para espacios entre palabras): ");
        String code = sc.nextLine();
        System.out.println("Texto: " + morse.morseToText(code));
    }

    // Caballeros menu
    private void caballeroMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GESTOR DE CABALLEROS ---");
            System.out.println("1. Crear caballero");
            System.out.println("2. Mostrar caballeros");
            System.out.println("3. Eliminar caballero");
            System.out.println("4. Batalla entre caballeros");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige: ");
            int opt = Integer.parseInt(sc.nextLine().trim());
            switch (opt) {
                case 1 -> createCaballeroFlow();
                case 2 -> manager.listCaballeros();
                case 3 -> {
                    System.out.print("Nombre del caballero a eliminar: ");
                    String nm = sc.nextLine();
                    manager.removeCaballeroByName(nm);
                }
                case 4 -> {
                    manager.listCaballeros();
                    System.out.print("Nombre caballero 1: ");
                    String a = sc.nextLine();
                    System.out.print("Nombre caballero 2: ");
                    String b = sc.nextLine();
                    manager.batalla(a, b);
                }
                case 5 -> back = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void createCaballeroFlow() {
        System.out.print("Nombre del caballero: ");
        String nombre = sc.nextLine();
        System.out.print("Día de nacimiento: ");
        int d = Integer.parseInt(sc.nextLine());
        System.out.print("Mes de nacimiento: ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.print("Año de nacimiento: ");
        int y = Integer.parseInt(sc.nextLine());
        String sign = zodiac.getSign(d, m);
        int edad = zodiac.calculateAge(y, m, d);
        // Overloaded constructor usage: if no age given, manager will use second constructor
        manager.createCaballero(nombre, sign, edad);
        System.out.println("Caballero creado: " + nombre + " - " + sign);
    }
}
