/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author pierr
 */
public class ConsultarProyecto implements ConexionControladorBd {

    // método para devolver un objeto proyecto a la vista
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
