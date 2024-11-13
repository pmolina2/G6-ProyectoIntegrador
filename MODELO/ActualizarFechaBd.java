package MODELO;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActualizarFechaBd extends ConexionBd{

    public void actualizarFechaEscritura(String matricula, String fecha){

        Connection conexion = this.getConnection("asesor", "asesor");

        String sentencia = """
                UPDATE proyectoIntegrador.apartamento
                SET fechaEscritura = ?
                WHERE matricula = ?
                """;

        try {
           
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta este formato según el formato de la fecha que recibas
            java.util.Date fechaUtil = null;
            java.sql.Date fechaSql = null;
            
            try {
                fechaUtil = formato.parse(fecha);
                fechaSql = new java.sql.Date(fechaUtil.getTime());
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha: " + e.getMessage());
            }

            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setDate(1, fechaSql);
            statement.setString(2, matricula);
            statement.executeUpdate(); 

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        closeConnection();
    }

}

