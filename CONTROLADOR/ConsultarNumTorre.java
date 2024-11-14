package CONTROLADOR;

import MODELO.*;

//Clase encargada de obtener el mumero de la torre, extendemos la clase abstracta para facilitar la conexxion a bd.

public class ConsultarNumTorre extends ConexionControladorBd{

    //metodo que retornara el numero de la torre, recibe la matricula como parametro para hacer la consulta en bd.

    public String devolverNumTorre(String matricula){

        //Inicio de la conexion a Bd con la clase NumeroTorreBd
        NumeroTorreBd numTorreBd = new NumeroTorreBd();
        try {
            //Ejecucion del metodo encargado de devolver el numero de torre en el package modelo.
            //Variable donde se recibe el retorno del metodo encargado de la consulta en modelo.
            String numTorre = numTorreBd.consultarNumTorre(matricula);
            //Retornamos el numero de la torre.
            return numTorre;
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        return "";
    }

}