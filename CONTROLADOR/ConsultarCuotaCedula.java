package CONTROLADOR;

import java.util.*;
import MODELO.*;
import Dominio.*;

//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarCuotaCedula extends ConexionControladorBd {

    // Método de tipo ArrayList de la clase "Torre", sirve para almacenar los objetos en listaTorres
    // y al final del ciclo lo retorna al package vista.


    public Cuota devolverCuotaCedula(String cedulaCliente) {


        try {
            CuotaCedulaBd cuota = new CuotaCedulaBd();
            ArrayList <String> cuotaCliente = cuota.consultarCuotaCedula(cedulaCliente);
            String id = cuotaCliente.get(0);
            String valor = cuotaCliente.get(1);
            String numeroCuota = cuotaCliente.get(2);
            String estado = cuotaCliente.get(3);
            String cedulaCliente1 = cuotaCliente.get(4);
            String fechaCuota = cuotaCliente.get(4);

            Cuota pCuota = new Cuota(id, valor, numeroCuota, estado, cedulaCliente1, fechaCuota);
            return pCuota;
        }


         catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return null;

    }

}