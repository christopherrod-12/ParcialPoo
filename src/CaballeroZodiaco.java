
    import java.util.Scanner;
import java.time.LocalDate;

    public class CaballeroZodiaco {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int dia, mes, anio;
            String signo = "";
            String caballero = "";

            System.out.print("Ingresa el año de nacimiento: ");
            anio = sc.nextInt();

            System.out.print("Ingresa el mes de nacimiento (1-12): ");
            mes = sc.nextInt();

            System.out.print("Ingresa el dia de nacimiento: ");
            dia = sc.nextInt();

            int anioActual = LocalDate.now().getYear();
            int edad = anioActual - anio;

            // Determinación de signo SIN usar && ni ||
            if (mes == 3) {
                if (dia >= 21) {
                    signo = "Aries";
                    caballero = "Mu de Aries";
                } else {
                    signo = "Piscis";
                    caballero = "Afrodita de Piscis";
                }
            } else if (mes == 4) {
                if (dia <= 19) {
                    signo = "Aries";
                    caballero = "Mu de Aries";
                } else {
                    signo = "Tauro";
                    caballero = "Aldebarán de Tauro";
                }
            } else if (mes == 5) {
                if (dia <= 20) {
                    signo = "Tauro";
                    caballero = "Aldebarán de Tauro";
                } else {
                    signo = "Géminis";
                    caballero = "Saga de Géminis";
                }
            } else if (mes == 6) {
                if (dia <= 20) {
                    signo = "Géminis";
                    caballero = "Saga de Géminis";
                } else {
                    signo = "Cáncer";
                    caballero = "Máscara de Muerte de Cáncer";
                }
            } else if (mes == 7) {
                if (dia <= 22) {
                    signo = "Cáncer";
                    caballero = "Máscara de Muerte de Cáncer";
                } else {
                    signo = "Leo";
                    caballero = "Aioria de Leo";
                }
            } else if (mes == 8) {
                if (dia <= 22) {
                    signo = "Leo";
                    caballero = "Aioria de Leo";
                } else {
                    signo = "Virgo";
                    caballero = "Shaka de Virgo";
                }
            } else if (mes == 9) {
                if (dia <= 22) {
                    signo = "Virgo";
                    caballero = "Shaka de Virgo";
                } else {
                    signo = "Libra";
                    caballero = "Dohko de Libra";
                }
            } else if (mes == 10) {
                if (dia <= 22) {
                    signo = "Libra";
                    caballero = "Dohko de Libra";
                } else {
                    signo = "Escorpio";
                    caballero = "Milo de Escorpio";
                }
            } else if (mes == 11) {
                if (dia <= 21) {
                    signo = "Escorpio";
                    caballero = "Milo de Escorpio";
                } else {
                    signo = "Sagitario";
                    caballero = "Aioros de Sagitario";
                }
            } else if (mes == 12) {
                if (dia <= 21) {
                    signo = "Sagitario";
                    caballero = "Aioros de Sagitario";
                } else {
                    signo = "Capricornio";
                    caballero = "Shura de Capricornio";
                }
            } else if (mes == 1) {
                if (dia <= 19) {
                    signo = "Capricornio";
                    caballero = "Shura de Capricornio";
                } else {
                    signo = "Acuario";
                    caballero = "Camus de Acuario";
                }
            } else if (mes == 2) {
                if (dia <= 18) {
                    signo = "Acuario";
                    caballero = "Camus de Acuario";
                } else {
                    signo = "Piscis";
                    caballero = "Afrodita de Piscis";
                }
            } else {
                signo = "Desconocido";
                caballero = "No existe un Caballero para esta fecha";
            }

            System.out.println("Tu edad es: " + edad + " años");
            System.out.println("Tu signo es: " + signo);
            System.out.println("Eres el caballero: " + caballero);

            sc.close();
        }
    }

