package CONTROLADOR;

import MODELO.*;
import java.util.ArrayList;

//Clase encargada de obtener el nombre del cliente, extendemos la clase abstracta ConexionControladorBd para facilitar la conexion.

public class ConsultarCliente extends ConexionControladorBd{

    //Metodo encargado de obtener la informacion del cliente, recibe la cedula del cliente como parametro.

    public String consultarCliente(String cedulaCliente){

        //Creamos un arraylist donde recibimos la informacion desde la capa modelo.
        ArrayList<String> cliente = new ArrayList<>();
        //Creamos un objeto de la clase de la capa modelo.
        ClienteBd Cliente = new ClienteBd();
        //le damos valores al arraylist con el arraylist que devuelve el metodo consultarCliente de modelo, pasandole la cedula del cliente como parametro.
        cliente = Cliente.consultarCliente(cedulaCliente);
        //Obtenemos los datos en la posicion 1 del arraylist, lo que vendria siendo el nombre del cliente.
        String nombreCliente = cliente.get(1);
        
        //retornamos el nombre del cliente.
        return nombreCliente;
        
    }

}