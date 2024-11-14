package Dominio;

//Clase entidad que guarda la informacion de los asesores.
public class Proyecto {

    //atributos necesarios para almacenar la info.
    private String id, nombre, direccion;
    private int numTorres;

//Constructor para darle valores a los atributos.
    public Proyecto(String id, String nombre, String direccion, int numTorres) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTorres = numTorres;
    }

    //getters para obtener los datos de los atributos y setters para modificar sus datos.
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
