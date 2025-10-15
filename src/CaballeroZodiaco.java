
public class CaballeroZodiaco extends Caballero {
    private final String signo;
    private final int poder; // atributo que define fuerza adicional

    public CaballeroZodiaco(String nombre, int edad, String signo, int poder) {
        super(nombre, edad);
        this.signo = signo;
        this.poder = poder;
    }

    // Sobrecarga: sin edad
    public CaballeroZodiaco(String nombre, String signo) {
        super(nombre);
        this.signo = signo;
        this.poder = 0;
    }

    public String getSigno() {
        return signo;
    }

    public int getPoder() {
        return poder;
    }

    // Sobrescritura: más información
    @Override
    public String descripcion() {
        return nombre + " - Signo: " + signo + " - Edad: " + edad + " - Poder: " + poder;
    }
}