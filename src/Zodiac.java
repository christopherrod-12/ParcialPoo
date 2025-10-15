import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class Zodiac {
    private final Map<String, String> signToCaballero = new HashMap<>();

    // Ranking de fuerza: mayor número = más fuerte
    private final Map<String, Integer> signStrength = new HashMap<>();

    public Zodiac() {
        // Asociaciones caballeros
        signToCaballero.put("Aries", "Mu de Aries");
        signToCaballero.put("Tauro", "Aldebarán de Tauro");
        signToCaballero.put("Géminis", "Saga de Géminis");
        signToCaballero.put("Cáncer", "Máscara de Muerte de Cáncer");
        signToCaballero.put("Leo", "Aioria de Leo");
        signToCaballero.put("Virgo", "Shaka de Virgo");
        signToCaballero.put("Libra", "Dohko de Libra");
        signToCaballero.put("Escorpio", "Milo de Escorpio");
        signToCaballero.put("Sagitario", "Aioros de Sagitario");
        signToCaballero.put("Capricornio", "Shura de Capricornio");
        signToCaballero.put("Acuario", "Camus de Acuario");
        signToCaballero.put("Piscis", "Afrodita de Piscis");

        // Ranking arbitrario de fuerza (puedes ajustar para la lógica de batalla)
        signStrength.put("Aries", 9);
        signStrength.put("Tauro", 6);
        signStrength.put("Géminis", 5);
        signStrength.put("Cáncer", 4);
        signStrength.put("Leo", 8);
        signStrength.put("Virgo", 7);
        signStrength.put("Libra", 6);
        signStrength.put("Escorpio", 10);
        signStrength.put("Sagitario", 8);
        signStrength.put("Capricornio", 7);
        signStrength.put("Acuario", 6);
        signStrength.put("Piscis", 5);
    }

    // Devuelve signo por día y mes
    public String getSign(int day, int month) {
        if (month == 3) {
            return day >= 21 ? "Aries" : "Piscis";
        } else if (month == 4) {
            return day <= 19 ? "Aries" : "Tauro";
        } else if (month == 5) {
            return day <= 20 ? "Tauro" : "Géminis";
        } else if (month == 6) {
            return day <= 20 ? "Géminis" : "Cáncer";
        } else if (month == 7) {
            return day <= 22 ? "Cáncer" : "Leo";
        } else if (month == 8) {
            return day <= 22 ? "Leo" : "Virgo";
        } else if (month == 9) {
            return day <= 22 ? "Virgo" : "Libra";
        } else if (month == 10) {
            return day <= 22 ? "Libra" : "Escorpio";
        } else if (month == 11) {
            return day <= 21 ? "Escorpio" : "Sagitario";
        } else if (month == 12) {
            return day <= 21 ? "Sagitario" : "Capricornio";
        } else if (month == 1) {
            return day <= 19 ? "Capricornio" : "Acuario";
        } else if (month == 2) {
            return day <= 18 ? "Acuario" : "Piscis";
        } else {
            return "Desconocido";
        }
    }

    public String getCaballeroForSign(String sign) {
        return signToCaballero.getOrDefault(sign, "Ninguno");
    }

    public int getStrength(String sign) {
        return signStrength.getOrDefault(sign, 0);
    }

    // Calcula edad precisa teniendo en cuenta si ya pasó el cumpleaños
    public int calculateAge(int year, int month, int day) {
        LocalDate birth = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        if (birth.isAfter(now)) return 0;
        Period p = Period.between(birth, now);
        return p.getYears();
    }
}
