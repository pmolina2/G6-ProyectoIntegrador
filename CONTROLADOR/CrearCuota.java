package CONTROLADOR;

import MODELO.*;

//Clase encargada de crear la cuota, extendemos la clase abstracta para facilitar la conexion a bd.

public class CrearCuota extends ConexionControladorBd{

    //Metodo que enviara la informacion a modelo para almacenar la cuota en bd, recibe como parametros el valor, fecha de la cuota y la cedula del cliente.
 
    public void registrarCuota(double valor, String fechaCuota, String cedulaCliente){

        //Creamos un objeto de la clase en modelo que hará el registro.
        CrearCuotaBd cc = new CrearCuotaBd();
        //con el objeto iniciamos el metodo que almacena la cuota, enviandole como parametros el valor, la fecha y la cedula del cliente.
        cc.registrarCuota(valor, fechaCuota, cedulaCliente);

    }
    
}
