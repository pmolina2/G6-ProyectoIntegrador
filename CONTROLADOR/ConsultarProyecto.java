package CONTROLADOR;

import java.sql.*;
import java.util.ArrayList;

//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarProyecto implements ConexionControladorBd {

    // Método de tipo ArrayList de la clase "Proyecto", sirve para retornar una lista de la informacion de los proyectos hacia el package de vista.

    public ArrayList<Proyecto> devolverProyectos() {

        ArrayList<Proyecto> listaProyectos = new ArrayList<>();

        try {

            ResultSet proyecto = conexion.consultarBd("proyecto");
            while (proyecto.next()) {
                String id = proyecto.getString("id");
                String nombre = proyecto.getString("nombre");
                String direccion = proyecto.getString("direccion");
                int numTorres = proyecto.getInt("numTorres");
                Proyecto p = new Proyecto(id, nombre, direccion, numTorres);

                listaProyectos.add(p);
            }
            return listaProyectos;

        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;

    }

}
