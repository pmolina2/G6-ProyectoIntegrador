package MODELO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;  
public class ConsultarCuotaClienteBd extends ConexionBd {
    

    public boolean consultaCedulaCuotaBd(String cedula) {

        Connection conexion = this.getConnection("asesor", "asesor");

        String bloquePLSQL = """
            BEGIN
                ? := proyectointegrador.Verificar_cuota_cliente(?);
            END;
        """;

        boolean existeCuota = false; 

        try {
           
            CallableStatement statement = conexion.prepareCall(bloquePLSQL);

            
            statement.registerOutParameter(1, Types.INTEGER);  

            statement.setString(2, cedula);

            statement.execute();

         
            int numeroRegistros = statement.getInt(1);

           
            if (numeroRegistros > 0) {
                existeCuota = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar la cuota: " + e.getMessage());
        } finally {
     
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return existeCuota;  
    }    
}
