package CONTROLADOR;
import MODELO.*;

//Clase encargada de actualizar la fecha de escritura en la tabla apartamento en el momento de hacer la venta
public class ActualizarFecha extends ConexionControladorBd{
    
    //Metodo que actualiza la fecha, recibe la matricula del apartamento y la fecha como parametro
    public void actualizarFechaEscritura(String matricula, String fecha){

        //Creamos una instancia de la clase de la capa modelo que hara la actualizacion
        ActualizarFechaBd aj = new ActualizarFechaBd();
        //con el objeto de la clase de modelo, le enviamos los parametros al metodo encargado de actualizar.
        aj.actualizarFechaEscritura(matricula, fecha);

    }

}
