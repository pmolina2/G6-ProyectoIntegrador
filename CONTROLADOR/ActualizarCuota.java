package CONTROLADOR;
        
import MODELO.*;

//Clase encargada de actualizar el mes de la fecha, agregandole un mes a la fecha de pago, extiende la clase abstracta
//para facilitar la conexion a Bd
public class ActualizarCuota extends ConexionControladorBd {
    //Metodo que hace la conexion a Bd, recibe el id de la cuota y se llama la clase de modelo.
    public void actualizarCuota(String idCuota){
        //Creamos una instancia de la clase en Modelo que hará la operacion para actualizarlo.
        ActualizarCuotaBd cuota = new ActualizarCuotaBd();
        //Con la instancia, llamamos al metodo que tiene la operación.
        cuota.actualizarCuotaBd(idCuota);
    }
}
