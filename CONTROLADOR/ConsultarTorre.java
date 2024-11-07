package CONTROLADOR;

import java.util.ArrayList;
import java.util.Hashtable;
import MODELO.*;
import Dominio.*;

//Clase encargada de obtener la informacion de la torre, extiende la clase abstracta de ConexionControladorBd para facilitar
//la conexion a BD

public class ConsultarTorre extends ConexionControladorBd {

    // Método encargado de devolver la informacion de las torres, almacenando objetos en un arraylist, ademas
    //recibe como parametros la id del proyecto.

    public ArrayList<Torre> devolverTorres(String idProyecto) {

        //Creacion del arraylist de tipo torre donde se almacenara la info.
        ArrayList<Torre> listaTorres = new ArrayList<>();

        try {
            //inicio de la conexion a BD mediante la clase TorresBd.
            TorresBd torres = new TorresBd();
            //Obtenemos un hashtable con la informacion en strings, provenientes del metodo consultarTorreProyecto, enviando como parametro
            //la id del proyecto
            Hashtable<String, ArrayList<String>> torre = torres.consultarTorreProyecto(idProyecto);
            //Recorrido de cada uno de los elementos del hashtable.
            torre.forEach((key, values) -> {
            //Descompicision de los elementos en variables, 
                String id = key;
                String numTorre = values.get(0);
                String numApartamento = values.get(1);
                String idProyecto1 = values.get(2);
                //Creacion de un nuevo objeto de tipo torre, con la informacion almacenada en las variables
                Torre pTorre = new Torre(id,numTorre,numApartamento,idProyecto1);
                //Agregamos a la lista de torres, el objeto con la info de la torre.
                listaTorres.add(pTorre);
            });


        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        //Retorno de la lista con la informacion de las torres.
        return listaTorres;

    }

}