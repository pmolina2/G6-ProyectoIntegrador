package CONTROLADOR;
import java.sql.*;

//Clase de operacion entre logica y modelo, implementamos la interfaz de ConexionControladorBd para agilizar el proceso de conexion.

public class ConsultarAdmin implements ConexionControladorBd {

    // Método de tipo "Admin", que recibe un parametro String ced (cedula) proveniente del package vista, sirve para validar
    // que la cedula existe en la base de datos, y además retornando la información de ese administrador hacia el package vista.
 
    public Admin devolverAdmin(String ced) {

        try {

            ResultSet admin = conexion.consultarBd("administrador");
            while (admin.next()) {
                String cedula = admin.getString("cedula");
                String nombreCompleto = admin.getString("nombreCompleto");
                String direccion = admin.getString("direccion");
                String telefono = admin.getString("telefono");
                String correo = admin.getString("correoElectronico");
                String contraseña = admin.getString("contrasenna");

                if (cedula.equals(ced)) {
                    return new Admin(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
                }
            }

        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;
    }

}
