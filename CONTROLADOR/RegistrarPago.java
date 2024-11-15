package CONTROLADOR;

import MODELO.GuardarPagoBd;

//Clase encargada de obtener la informacion del pago del package vista y enviarlo al package modelo
//Extendemos la clase abstracta para facilitar la conexion a Bd
public class RegistrarPago extends ConexionControladorBd {
    //Metodo que recibe la info proveniente de vista y hará la conexion a Bd.
    public String registrarPago(String numeroReferencia, String metodoPago, String valorPago, String fecha, String cedulaCliente, String idCuota, String numeroCuota){
        //Creamos una instancia de la clase de modelo que contiene el metodo para ejecutar el proceso.
        GuardarPagoBd pago = new GuardarPagoBd();
        //Creamos una varaible string para capturar el retorno del metodo de la clase
        //pasamos la info que viene de vista para que el metodo de modelo lo almacene
        String mensaje = pago.guardarPagoBd(numeroReferencia, metodoPago, valorPago, fecha, cedulaCliente, idCuota, numeroCuota);
        //Retornamos la variable que creamos antes.
        return mensaje;
    }
}
