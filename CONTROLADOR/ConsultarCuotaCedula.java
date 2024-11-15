package CONTROLADOR;

import Dominio.*;
import MODELO.*;
import java.util.*;

//Clase encargada de obtener la informacion de las cuotas de un cliente en especifico, extiende la clase abstracta
//ConexionControladorBd para facilitar la conexion a BD
public class ConsultarCuotaCedula extends ConexionControladorBd {

    // Método encargado de devolver la info de la cuota del cliente, retorna un objeto de tipo cuota, ademas de recibir
    //un string cedulacliente proveniente del package vista.

    public Cuota devolverCuotaCedula(String cedulaCliente) {


        try {
            //Iniciamos la conexion creando una instancia de la clase CuotaCedulaBd
            CuotaCedulaBd cuota = new CuotaCedulaBd();
            //Obtenemos un arraylist con la informacion de la cuota del cliente producto del metodo 

            //consultarCuotaCedula de la clase CuotaCedulaBd
            ArrayList <String> cuotaCliente = cuota.consultarCuotaCedula(cedulaCliente);

            

            //Descomponemos el arraylist y le damos valor a las variables
            String id = cuotaCliente.get(0);
            String valor = cuotaCliente.get(1);
            String estado = cuotaCliente.get(2);
            String fechaCuota = cuotaCliente.get(3);
            String numeroCuota = cuotaCliente.get(4);
            String cedulaCliente1 = cuotaCliente.get(5);
            String idVenta = cuotaCliente.get(6);
            
            //Con las variables creamos un nuevo objeto de tipo Cuota
            Cuota pCuota = new Cuota(id, valor, numeroCuota, estado, cedulaCliente1, fechaCuota, idVenta);
            //Retornamos el objeto de tipo cuota
            return pCuota;
        }
         catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        //En caso de no encontrar la info se retornara nulo.
        return null;

    }

}