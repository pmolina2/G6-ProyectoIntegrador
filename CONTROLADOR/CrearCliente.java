package CONTROLADOR;
import MODELO.*;

//Clase encargada de registrar a un nuevo cliente en el sistema y almacenarlo en la BD
//Extendemos la clase abstracta para facilitar la conexion a Bd.
public class CrearCliente extends ConexionControladorBd{
    //metodo que hara la conexion a Bd, recibe los datos del cliente en formato string.
    public String crearCliente(String cedula, String nombreCompleto, String sisben, String subsidio,String direccion,String telefono , String correoElectronico){
        //instanciamos la clase de modelo encargada de almacernar la info
        GuardarClienteBd clienteBd = new GuardarClienteBd();
        //creamos una variable string para capturar el retorno del metodo que hara el almacenamiento
        //con la instancia se llama el metodo y se le pasa toda la info del cliente.
        String Respuesta = clienteBd.registrarClienteBd(cedula,nombreCompleto,sisben,subsidio,direccion,telefono,correoElectronico);
        //retornamos la variable que creamos antes con el retorno del metodo
        return Respuesta;
    }

}