package MODELO;
import java.util.*;
import java.sql.*;

public class UsuarioBd extends ConexionBd{
    
    public ArrayList<String> consultarUsuario(String nombreTabla, String cedula){

        Connection conexion = this.getConnection("userInicio", "userInicio");
        
        ArrayList<String> datosUsuario = new ArrayList<>();

        String sentencia = String.format("""
                SELECT *
                FROM proyectoIntegrador.%s
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

            statement.close();
            resultset.close();
            
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        closeConnection();
        return datosUsuario;

    }

}
