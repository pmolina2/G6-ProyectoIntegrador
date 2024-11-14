package CONTROLADOR;
import Dominio.*;
import MODELO.*;
import java.util.ArrayList;
import java.util.Hashtable;


//Clase encargada de la consulta de los apartamentos, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion.
public class ConsultarApartamento extends ConexionControladorBd{

    //metodo de tipo Arraylist que contiene objetos de clase Apartamento, es el encargado de devolver
    //los apartamentos pertenecientes a una torre, esto mediante consulta con Base de datos, recibiendo
    //la id de la torre, proveniente desde el package Vista.
    
    public ArrayList<Apartamento> devolverApartamentos(String idTorre, String usuario, String contraseña){

        //Arraylist donde se almacenaran los objetos de tipo apartamento.
        ArrayList<Apartamento> listaApartamentos = new ArrayList<>();

        try {
            //Creamos la conexion a BD mediante la clase ApartamentoBd
            ApartamentoBd apartamentoBd = new ApartamentoBd();
            //Obtenemos un Hashtable proveniente del metodo consultarAptoTorre de la clase ApartamentoBd
            //le pasamos la id de la torre para que logre hacer la consulta en la BD
            Hashtable<String, ArrayList<String>> apartamento = apartamentoBd.consultarAptoTorre(idTorre, usuario, contraseña);
            //Recorremos todos los elementos del hastable
            apartamento.forEach((key, values) -> {
            //Descomponemos los datos del hashtable para almacenarlos en variables
            String matricula = key;
            String numApto = values.get(0);
            String tipoUnidad = values.get(1);
            String area = values.get(2);
            String valorApto = values.get(3);
            //Con las variables anteriores, creamos el objeto de la clase Apartamento
            //y la agregamos a la lista "listaApartamentos".
            Apartamento pApartamento = new Apartamento(matricula, numApto, tipoUnidad, area, valorApto);
            listaApartamentos.add(pApartamento);
        });

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        //Retornamos "listaApartamentos", con los objetos de la clase Apartamento creados anterioremente
        return listaApartamentos;

    }
    
    

}
