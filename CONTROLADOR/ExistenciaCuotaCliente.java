package CONTROLADOR;

import MODELO.*;

//Clase encargada de enviar la cedula del cliente para verificar si la cedula del cliente existe en Bd
//Extendemos la clase abstracta para facilitar la conexion a Bd
public class ExistenciaCuotaCliente extends ConexionControladorBd {
    //Metodo encargado de llamar a la clase de modelo que ejecutará el proceso para verificar en Bd
    //recibe la cedula del cliente para verificarlo en bd
    public boolean existenciaCuota(String cedula){
        //Creamos una instancia de la clase de modelo que contiene el metodo para el proceso.
        ConsultarCuotaClienteBd consultaCuota = new ConsultarCuotaClienteBd();
        //Creamos una variable boolean para obtener el retorno del metodo que hara el proceso.
        boolean respuesta = consultaCuota.consultaCedulaCuotaBd(cedula);
        //Retornamos la variable hacia el package vista.
        return respuesta;
    }
    
}