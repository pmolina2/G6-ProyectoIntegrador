package CONTROLADOR;

// Clase entidad para manejar la informacion de pagos, incluyendo su constructor, sus getters y sus setters.

public class Proyecto {
    @SuppressWarnings("unused")
    private String id, nombre, direccion;
    @SuppressWarnings("unused")
    private int numTorres;

    public Proyecto(String id, String nombre, String direccion, int numTorres) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTorres = numTorres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumTorres() {
        return numTorres;
    }

    public void setNumTorres(int numTorres) {
        this.numTorres = numTorres;
    }

}
