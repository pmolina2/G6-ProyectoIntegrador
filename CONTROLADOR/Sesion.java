package CONTROLADOR;
import Dominio.Proyecto;
import java.util.*;

//Clase Singleton para mantener la informacion importante mas a mano para vista.
public class Sesion extends ConexionControladorBd {
    
    //Atributos estaticos que almacenan la info del usuario que inició, ademas de los proyectos.
    private static String cedula;
    private static String nombre;
    private static ArrayList<Proyecto> listaProyectos;
    private static Proyecto ProyectoActual;

    //Constructor donde damos valores a los atributos.
    public Sesion(String cedula, String nombre, ArrayList<Proyecto> listaProyectos){
        Sesion.cedula = cedula;
        Sesion.nombre = nombre;
        Sesion.listaProyectos = listaProyectos;
    }

    //Getters de los atributos.

    public static String getCedula() {
        return cedula;
    }

    public static ArrayList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setProyecto(Proyecto proyecto){
        Sesion.ProyectoActual = proyecto;
    }

    public static Proyecto getProyectoActual() {
        return ProyectoActual;
    }

    
}
