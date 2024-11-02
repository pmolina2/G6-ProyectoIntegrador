package CONTROLADOR;
import java.util.*;
import Dominio.Proyecto;

public class Sesion extends ConexionControladorBd {
    
    static String cedula;
    static String nombre;
    static ArrayList<Proyecto> listaProyectos;

    public Sesion(String cedula, String nombre, ArrayList<Proyecto> listaProyectos){
        Sesion.cedula = cedula;
        Sesion.nombre = nombre;
        Sesion.listaProyectos = listaProyectos;
    }

    public static String getCedula() {
        return cedula;
    }

    public static ArrayList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public static String getNombre() {
        return nombre;
    }
}
