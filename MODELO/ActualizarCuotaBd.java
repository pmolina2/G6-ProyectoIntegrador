package MODELO;

import java.sql.*;

public class ActualizarCuotaBd extends ConexionBd {
    
    public void actualizarCuotaBd(String idCuota){
        Connection conexion = this.getConnection("asesor", "asesor");

        String bloquePLSQL = """
            BEGIN
                proyectointegrador.actualizarcuota(?);
            END;
            """;

            try {
                // Crear CallableStatement para llamar al procedimiento almacenado
                CallableStatement statement = conexion.prepareCall(bloquePLSQL);
    
                statement.setString(1, idCuota);
    
                // Ejecutar la llamada al procedimiento
                statement.executeUpdate();
    
                // Cerrar el statement
                statement.close();
    
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
            closeConnection();
    }   


}
