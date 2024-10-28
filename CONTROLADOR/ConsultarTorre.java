package CONTROLADOR;
import java.sql.*;
import java.util.ArrayList;

//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarTorre implements ConexionControladorBd {

    // Método de tipo ArrayList de la clase "Torre", sirve para almacenar los objetos en listaTorres
    // y al final del ciclo lo retorna al package vista.


    public ArrayList<Torre> devolverTorres(String idProyecto) {

        ArrayList<Torre> listaTorres = new ArrayList<>();

        try {

            ResultSet Torre = conexion.consultarBdSentencia("SELECT * FROM torre WHERE idProyecto = "+idProyecto);
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
