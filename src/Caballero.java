public class Caballero {
    protected String nombre;
    protected int edad;

    public Caballero(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrecarga de constructor
    public Caballero(String nombre) {
        this(nombre, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método que puede ser sobrescrito
    public String descripcion() {
        return nombre + " (Edad: " + edad + ")";
    }

    @Override
    public String toString() {
        return descripcion();
    }
}
