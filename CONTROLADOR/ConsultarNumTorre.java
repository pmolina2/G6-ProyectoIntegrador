package CONTROLADOR;

import MODELO.*;


public class ConsultarNumTorre extends ConexionControladorBd{

    public String devolverNumTorre(String matricula){
        //Inicio de la conexion a Bd con la clase NumeroTorreBd
        NumeroTorreBd numTorreBd = new NumeroTorreBd();
        //Variable donde se almacenará el numero de la torre del apartamento.
        

        try {
            //Ejecucion del metodo encargado de devolver el numero de torre en el package modelo.
            String numTorre = numTorreBd.consultarNumTorre(matricula);
            return numTorre;
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        //Retorno de la variable con el numero de la torre ya almacenado.
        return "";
    }

}