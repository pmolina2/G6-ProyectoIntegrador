package CONTROLADOR;

import java.util.*;
import Dominio.*;
import MODELO.*;

//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarProyecto extends ConexionControladorBd {

    // Método de tipo ArrayList de la clase "Proyecto", sirve para retornar una lista de la informacion de los proyectos hacia el package de vista.

    public ArrayList<Proyecto> devolverProyectos() {

    ArrayList<Proyecto> listaProyectos = new ArrayList<>();

    try {
        ProyectosBd proyectos = new ProyectosBd();
        Hashtable<String, ArrayList<String>> proyecto = proyectos.consultarProyectos();

        proyecto.forEach((key, values) -> {
            
            String id = key;
            String nombre = values.get(0);
            String direccion = values.get(1);
            String numTorres = values.get(2);

            Proyecto Pproyecto = new Proyecto(id,nombre,direccion,numTorres);
            listaProyectos.add(Pproyecto);
        });

    } catch (Exception e) {
        System.out.println("Error " + e.getMessage());
    }

    return listaProyectos;
}

}