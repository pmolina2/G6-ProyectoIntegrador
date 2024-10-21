/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CONTROLADOR;

import java.sql.*;
import java.util.ArrayList;
import MODELO.ConexionBd;

/**
 *
 * @author gutie
 */

public class ConsultarProyecto {

    public ArrayList<Proyecto> consultarProyectos() {

        ConexionBd c = new ConexionBd();
        ArrayList<Proyecto> ListaProyectos = new ArrayList<>();

        try {
            ResultSet rs = c.consultarBd("proyecto");
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                int numTorres = rs.getInt("numTorres");

                Proyecto p = new Proyecto(id, nombre, direccion, numTorres);
                ListaProyectos.add(p);
            }
        } catch (SQLException sqlex) {
            System.out.println("Error " + sqlex.getMessage());
        }

        return ListaProyectos;
    }
}