import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CaballeroManager {
    private final List<CaballeroZodiaco> lista = new ArrayList<>();
    private final Zodiac zodiac = new Zodiac();

    // Crear caballero (sobrecarga: con edad o sin edad)
    public void createCaballero(String nombre, String signo, int edad) {
        int baseStrength = zodiac.getStrength(signo);
        CaballeroZodiaco c = new CaballeroZodiaco(nombre, edad, signo, baseStrength);
        lista.add(c);
    }

    public void createCaballero(String nombre, String signo) {
        int baseStrength = zodiac.getStrength(signo);
        CaballeroZodiaco c = new CaballeroZodiaco(nombre, signo);
        // No se asigna edad ni poder extra; podría asignarse poder = baseStrength si se desea.
        lista.add(c);
    }

    public void listCaballeros() {
        if (lista.isEmpty()) {
            System.out.println("No hay caballeros creados.");
            return;
        }
        System.out.println("\n-- Caballeros creados --");
        for (CaballeroZodiaco c : lista) {
            System.out.println(c);
        }
    }

    public void removeCaballeroByName(String name) {
        Optional<CaballeroZodiaco> opt = lista.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(name))
                .findFirst();
        if (opt.isPresent()) {
            lista.remove(opt.get());
            System.out.println("Caballero eliminado: " + name);
        } else {
            System.out.println("No se encontró caballero con ese nombre.");
        }
    }

    // Batalla por signo más fuerte (ranking Zodiac.getStrength)
    public void batalla(String nameA, String nameB) {
        Optional<CaballeroZodiaco> aOpt = lista.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nameA)).findFirst();
        Optional<CaballeroZodiaco> bOpt = lista.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nameB)).findFirst();
        if (aOpt.isEmpty() || bOpt.isEmpty()) {
            System.out.println("Alguno de los caballeros no existe. Asegúrate de los nombres.");
            return;
        }
        CaballeroZodiaco a = aOpt.get();
        CaballeroZodiaco b = bOpt.get();

        int strengthA = zodiac.getStrength(a.getSigno()) + a.getPoder();
        int strengthB = zodiac.getStrength(b.getSigno()) + b.getPoder();

        System.out.println("Poder de " + a.getNombre() + " (" + a.getSigno() + "): " + strengthA);
        System.out.println("Poder de " + b.getNombre() + " (" + b.getSigno() + "): " + strengthB);

        if (strengthA > strengthB) {
            System.out.println("Ganador: " + a.getNombre());
        } else if (strengthB > strengthA) {
            System.out.println("Ganador: " + b.getNombre());
        } else {
            System.out.println("Empate. Se desempata por edad (mayor gana).");
            if (a.getEdad() > b.getEdad()) System.out.println("Ganador por edad: " + a.getNombre());
            else if (b.getEdad() > a.getEdad()) System.out.println("Ganador por edad: " + b.getNombre());
            else System.out.println("Empate absoluto.");
        }
    }
}
