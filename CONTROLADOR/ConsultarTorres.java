/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CONTROLADOR;

import java.util.ArrayList;
import java.sql.*;
import MODELO.ConexionBd;

/**
 *
 * @author gutie
 */

public class ConsultarTorres {

    public ArrayList<Torre> consultarTorres() {

        ConexionBd c = new ConexionBd();
        ArrayList<Torre> ListaTorres = new ArrayList<>();

        try {
            ResultSet rs = c.consultarBd("Torre");
            while (rs.next()) {
                String id = rs.getString("id");
                String numTorre = rs.getString("numTorre");
                String numApartamento = rs.getString("numApartamento");
                String idProyecto = rs.getString("idProyecto");

                Torre t = new Torre(id, numTorre, numApartamento, idProyecto);
                ListaTorres.add(t);
            }
        } catch (SQLException sqlex) {
            System.out.println("Error " + sqlex.getMessage());
        }

        return ListaTorres;
    }
}