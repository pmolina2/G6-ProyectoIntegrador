package CONTROLADOR;
import java.sql.*;

//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarAsesor implements ConexionControladorBd {

    // Método de tipo "Asesor", recibe un parametro String ced (cedula), sirve para validar la existencia del asesor relacionado con esa cedula
    // además, retornando la informacion correspondiente a ese asesor, hacia el package vista.

    public Asesor devolverAsesor(String ced) {

        try {

            ResultSet asesor = conexion.consultarBd("asesor");
            while (asesor.next()) {
                String cedula = asesor.getString("cedula");
                String nombreCompleto = asesor.getString("nombreCompleto");
                String direccion = asesor.getString("direccion");
                String telefono = asesor.getString("telefono");
                String correo = asesor.getString("correoElectronico");
                String contraseña = asesor.getString("contrasenna");

                if (cedula.equals(ced)) {
                    return new Asesor(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
                }

            }

        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;
    }

}
