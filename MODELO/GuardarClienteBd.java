package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GuardarClienteBd extends ConexionBd{
    
    public String registrarClienteBd(String cedula, String nombreCompleto, String sisben, String subsidio,String direccion,String telefono , String correoElectronico) {

        Connection conexion = this.getConnection("asesor", "asesor");
        String mensaje = "";

        String sentencia = """
                INSERT INTO proyectoIntegrador.cliente
                VALUES(?, ?, ?, ?, ?, ?,?)
                """;
        
        try {
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, cedula);
            statement.setString(2, nombreCompleto);
            statement.setString(3, sisben);
            statement.setString(4, subsidio);
            statement.setString(5, direccion);
            statement.setString(6, telefono);
            statement.setString(7, correoElectronico);

            statement.executeQuery();

            mensaje = "Cliente registrado de forma exitosa.\n";
            statement.close();
            closeConnection();
            
        } catch (SQLException e) {
            if(e.getErrorCode() == 20005){
                mensaje = "Error: La cedula del cliente, ya fue registrada con anterioridad.\n";
            } else {
                mensaje = ("Error al registrar la venta: " + e.getMessage());
            }
        }
        
        return mensaje;
    }
}
