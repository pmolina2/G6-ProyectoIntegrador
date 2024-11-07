package MODELO;
import java.sql.*;

/*
 *CLASE CrearUsuarioBd QUE EXTIENDE LA CLASE ConexionBd
 PARA HACER LA CONEXION CON LA BASE DE DATOS
*/
public class CrearAsesorBd extends ConexionBd{
    
    //METODO RegistrarUsuario PARA LA CREACION DE UN NUEVO USUARIO EN LA BASE DE DATOS
    public String registrarAsesor(String cedula, String nombreCompleto, String direccion, String telefono, String correoElectronico, String contrasenna){

        Connection conexion = this.getConnection();

        String sentencia = """
                INSERT INTO ASESOR
                VALUES(?, ?, ?, ?, ?)
                """;

        try {
         
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, cedula);
            statement.setString(2, nombreCompleto);
            statement.setString(3, direccion);
            statement.setString(4, telefono);
            statement.setString(5, correoElectronico);
            statement.setString(6, contrasenna);
            statement.executeQuery();
            statement.executeUpdate();

            statement.close();
            closeConnection();
            return "Usuario registrado exitosamente";
            
        } catch (SQLException sqlex) {
            System.out.println("Error "+sqlex);
        }

        return "";

    }

}
