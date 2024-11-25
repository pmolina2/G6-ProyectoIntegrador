package MODELO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrearCuotaBd extends ConexionBd{

    /**
     * Método principal de la clase que se encarga de hacer un nuevo registro en la tabla Cuota
     * pasandole como parámetro los valores del registro
     */
    public void registrarCuota(Double valor, String fechaCuota, String cedulaCliente){

        // se realiza la conexión con el usuario asesorg6 y la contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");

        /**
         * En el bloque PL/SQL a ejecutar, se busca el código de la venta con la cedula del cliente.
         * Luego se hace la inserción de los datos en la tabla Cuota
         */
        String bloquePLSQL = """
                DECLARE
                    v_idVenta proyectoIntegradorg6.venta.id%TYPE;
                BEGIN
        
                    SELECT id INTO v_idVenta
                    FROM proyectoIntegradorg6.venta
                    WHERE cedulaCliente = ?;

                    INSERT INTO proyectoIntegradorg6.cuota
                    VALUES (proyectoIntegradorg6.cuota_id_seq.nextval, ?, 'Proxima a Vencer', ADD_MONTHS(?, 1), '1',  ?, v_idVenta);
                END;
            """;
        
        /**
         * Se cambia el formato de la fecha por el tipo SQL DATE para almacenarlo en la BD y se cambian
         * los signos ? por las variables en el orden adecuado, luego se ejecuta la sentencia.
         *
         */
        try {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaUtil = null;
            java.sql.Date fechaSql = null;

            fechaUtil = formato.parse(fechaCuota);
            fechaSql = new java.sql.Date(fechaUtil.getTime());

            CallableStatement statement = conexion.prepareCall(bloquePLSQL);
            statement.setString(1, cedulaCliente);
            statement.setDouble(2, valor);
            statement.setDate(3, fechaSql);
            statement.setString(4, cedulaCliente);

            statement.executeUpdate();

            //cierre del statement
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
     
        // cierre de la conexión
        closeConnection();

    }

}
