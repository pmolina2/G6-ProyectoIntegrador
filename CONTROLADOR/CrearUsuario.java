package CONTROLADOR;
import MODELO.*;

//Clase encargada de crear un nuevo Asesor en el sistema y almacenarlo en la BD

public class CrearUsuario extends ConexionControladorBd{

    public String GuardarUsuario(String cedula, String nombreCompleto, String direccion, String telefono, String correoElectronico, String contrasenna ){
        CrearAsesorBd UsuarioBd = new CrearAsesorBd();

        String Respuesta = UsuarioBd.registrarAsesor(cedula,nombreCompleto,direccion,telefono,correoElectronico,contrasenna);

        return Respuesta;
    }

}