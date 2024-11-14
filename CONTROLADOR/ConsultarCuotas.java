package CONTROLADOR;

import MODELO.*;
import java.util.*;
import Dominio.*;

//Clase encargada de obtener la info de las cuotas de todos los clientes, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD
public class ConsultarCuotas extends ConexionControladorBd {

    //metodo encargado de obtener y retornar la informacion de las cuotas.
    public ArrayList<Cuota> devolverCuotas() {

        //se crea un arraylist de tipo Cuota donde se almacenaran los objetos de tipo cuota con la informacion de cada una.
        ArrayList<Cuota> listaCuotas = new ArrayList<>();

        try {
            //Inicia la conexion a BD creando una instancia de la clase CuotasBd.
            CuotasBd cuota = new CuotasBd();
            //se obtiene un hashtable con una cadena y un arraylist de cadenas en su interior, esto proviene del metodo
            //consultarCuotas de la clase CuotasBd.
            Hashtable<String, ArrayList<String>> cuotas = cuota.consultarCuotas();

            //Recorrido de cada elemento del hashtable
            cuotas.forEach((key, values) -> {
                //Descomposicion los elementos del hashtable con la informacion de las cuotas en variables
                String id = key;
                String valor = values.get(0);
                String estado = values.get(1);
                String fechaCuota = values.get(2);
                String numeroCuota = values.get(3);
                String cedulaCliente = values.get(4);
                String idVenta = values.get(5);
                //Con las variables, se crea un objeto de tipo cuota.
                Cuota pCuotas = new Cuota(id, valor, numeroCuota, estado, cedulaCliente, fechaCuota, idVenta);
                //Se almacena en el arraylist creado en el principio.
                listaCuotas.add(pCuotas);
            });

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        //Retorno de la lista de cuotas con los objetos de tipo Cuota.
        return listaCuotas;
    }

}
