package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GuardarClienteBd extends ConexionBd{
    
    /**
     * Método principal de la clase que se encarga de registrar clientes
     * pasándole como parámetros los datos del cliente, retorna una variable de tipoString
     * 
     * 
     * Se crea la sentencia y se cambian los valores de los signos ? por los valores
     * de las variables en los parámetros en el orden especificado, se ejecuta la sentencia y se devuelve un mensaje
     * especificando el resultado de la consulta
     */
    public String registrarClienteBd(String cedula, String nombreCompleto, String sisben, String subsidio,String direccion,String telefono , String correoElectronico) {

        //se crea la conexión con el usuario asesorg6 y la contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");
        String mensaje = "";

        String sentencia = """
                INSERT INTO proyectoIntegradorg6.cliente
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
