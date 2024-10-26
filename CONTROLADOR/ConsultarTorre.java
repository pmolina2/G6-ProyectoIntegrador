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
public class ConsultarTorre implements ConexionControladorBd {

    // método para devolver un objeto proyecto a la vista
    public ArrayList<Torre> devolverTorres(String idProyecto) {

        ArrayList<Torre> listaTorres = new ArrayList<>();

        try {

            ResultSet Torre = conexion.consultarBdSentencia("SELECT * FROM torre WHERE id = "+idProyecto);
            while (Torre.next()) {
                String id = Torre.getString("id");
                String numTorre = Torre.getString("numTorre");
                String NumApartamento = Torre.getString("NumApartamento");
                
                Torre t = new Torre(id, numTorre, NumApartamento, idProyecto);
                listaTorres.add(t);

            }

            return listaTorres;


        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;

    }

}
