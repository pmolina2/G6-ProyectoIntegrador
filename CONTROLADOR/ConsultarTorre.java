package CONTROLADOR;

import java.util.ArrayList;
import java.util.Hashtable;
import MODELO.*;
import Dominio.*;

//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarTorre extends ConexionControladorBd {

    // Método de tipo ArrayList de la clase "Torre", sirve para almacenar los objetos en listaTorres
    // y al final del ciclo lo retorna al package vista.


    public ArrayList<Torre> devolverTorres(String idProyecto) {

        ArrayList<Torre> listaTorres = new ArrayList<>();

        try {
            TorresBd torres = new TorresBd();
            Hashtable<String, ArrayList<String>> torre = torres.consultarTorreProyecto(idProyecto);
            torre.forEach((key, values) -> {
            
            String id = key;
            String numTorre = values.get(0);
            String numApartamento = values.get(1);
            String idProyecto1 = values.get(2);

<<<<<<< Updated upstream
            ResultSet Torre = conexion.consultarBdSentencia("SELECT * FROM torre WHERE id = "+idProyecto);
            while (Torre.next()) {
                String id = Torre.getString("id");
                String numTorre = Torre.getString("numTorre");
                String NumApartamento = Torre.getString("NumApartamento");
                
                Torre t = new Torre(id, numTorre, NumApartamento, idProyecto);
                listaTorres.add(t);

            }

            return listaTorres;
=======
            Torre pTorre = new Torre(id,numTorre,numApartamento,idProyecto1);
            listaTorres.add(pTorre);
        });
>>>>>>> Stashed changes


        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return listaTorres;

    }

}