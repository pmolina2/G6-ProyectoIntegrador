package CONTROLADOR;
import MODELO.*;

//Clase encargada de crear un nuevo Asesor en el sistema y almacenarlo en la BD

public class CrearCliente extends ConexionControladorBd{

    public String crearCliente(String cedula, String nombreCompleto, String sisben, String subsidio,String direccion,String telefono , String correoElectronico){
        
        GuardarClienteBd clienteBd = new GuardarClienteBd();

        String Respuesta = clienteBd.registrarClienteBd(cedula,nombreCompleto,sisben,subsidio,direccion,telefono,correoElectronico);

        return Respuesta;
    }

}