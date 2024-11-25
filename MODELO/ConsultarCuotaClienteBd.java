package MODELO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;  


public class ConsultarCuotaClienteBd extends ConexionBd {
    
    /**
     *  Método principal de la clase que se encarga de hacer una consulta en la tabla cuota para verificar
     *  que haya una cuota creada con la cédula que se le pasa como parámetro retornando un valor booleano en caso
     *  de ser verdadero o falso.
     * 
     */
    public boolean consultaCedulaCuotaBd(String cedula) {

        // creación de la conexión con el usuario asesorg6 y la contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");

        /** 
         *  bloque PL/SQL a ejecutar con la función verificar_cuota_cliente,
         *  se le pasa como parámetro la cédula del cliente y verifica que este no tenga una cuota
         *  activa en el momento, esto con el fin de que los clientes que tengan cuotas de una deuda
         *  activa no puedan realizar otra compra
         * 
        */
        String bloquePLSQL = """
            BEGIN
                ? := proyectointegradorg6.Verificar_cuota_cliente(?);
            END;
        """;


        /**
         *  Se crea la variable existeCuota con valor false por defecto para retornarlo
         *  y se ejecuta la sentencia anteriormente creada
         */


        boolean existeCuota = false; 

        try (CallableStatement statement = conexion.prepareCall(bloquePLSQL);){
            
            // creación de los parametros de la PreparedStatement para reemplazar el simbolo ? con las variables en la sentencia
            statement.registerOutParameter(1, Types.INTEGER);  
            statement.setString(2, cedula);
            statement.execute();

         
            /**
             *  condicional que verifica la existencia de la cuota, si existe regresa verdadero  
             */ 
            int numeroRegistros = statement.getInt(1);

           
            if (numeroRegistros > 0) {
                existeCuota = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar la cuota: " + e.getMessage());
        } finally {
     
            // cierre de la conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // retorno del valor existeCuota.
        return existeCuota;  
    }    
}
