package CONTROLADOR;

import java.util.*;
import Dominio.*;
import MODELO.*;

//Clase encargada de obtener la informacion de los proyectos, extiende la clase abstracta de ConexionControladorBd para facilitar
//la conexion a BD
public class ConsultarProyecto extends ConexionControladorBd {

    // Método encargado de retornar la informacion de los proyectos, retornandolos en un arraylist de tipo proyecto.

    public ArrayList<Proyecto> devolverProyectos() {

    //Creacion del arraylist de tipo proyecto, encargado de almacenar los objetos con la info de los mismos.
    ArrayList<Proyecto> listaProyectos = new ArrayList<>();

    try {
        //Inicio de la conexion a BD con la clase ProyectosBd
        ProyectosBd proyectos = new ProyectosBd();
        //Se obtiene un hashtable proveniente de la consulta realizada en el metodo consultarProyectos de la clase ProyectosBd
        Hashtable<String, ArrayList<String>> proyecto = proyectos.consultarProyectos();

        //Recorrido de cada uno de los elementos en el hashtable.
        proyecto.forEach((key, values) -> {
            //Descomponemos los datos del proyecto y lo almacenamos en variables
            String id = key;
            String nombre = values.get(0);
            String direccion = values.get(1);
            String numTorres = values.get(2);

            //Con las variables creamos un nuevo objeto de tipo proyecto.
            Proyecto Pproyecto = new Proyecto(id,nombre,direccion,numTorres);
            //Almacenamos el objeto en el arraylist del principio.
            listaProyectos.add(Pproyecto);
        });

    } catch (Exception e) {
        System.out.println("Error " + e.getMessage());
    }
    //Retorno de la lista de proyectos que almacenó los objetos.
    return listaProyectos;
}

}