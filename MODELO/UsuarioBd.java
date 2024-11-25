package MODELO;
import java.sql.*;
import java.util.*;

public class UsuarioBd extends ConexionBd{
    
    /**
     * Método principal de la clase. Encargado de hacer una consulta de usuario,
     * que hace referencia tanto al asesor como al administrador pues ambos comparten los mismos atributos
     * en la base de datos. El método retorna un ArrayList de tipo string con la fila devuelta en la consulta
     */
    public ArrayList<String> consultarUsuario(String nombreTabla, String cedula){

        Connection conexion = this.getConnection("userInicio", "userInicio");
        
        ArrayList<String> datosUsuario = new ArrayList<>();

        String sentencia = String.format("""
                SELECT *
                FROM proyectoIntegradorg6.%s
                WHERE cedula = ?
                """, nombreTabla);
        
        try {

            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, cedula);
            ResultSet resultset = statement.executeQuery();

            if(resultset.next()){

                datosUsuario.add(resultset.getString("cedula"));
                datosUsuario.add(resultset.getString("nombreCompleto"));
                datosUsuario.add(resultset.getString("direccion"));
                datosUsuario.add(resultset.getString("telefono"));
                datosUsuario.add(resultset.getString("correoElectronico"));
                datosUsuario.add(resultset.getString("contrasenna"));

            }

            // cierre del statement y el resultset
            statement.close();
            resultset.close();
            
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        // cierre de la conexión y la lista
        closeConnection();
        return datosUsuario;

    }

}
