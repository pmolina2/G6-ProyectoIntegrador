package MODELO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CrearCuotaBd extends ConexionBd{

    public void registrarCuota(Double valor, String fechaCuota, String cedulaCliente){

        Connection conexion = this.getConnection("asesor", "asesor");

        String bloquePLSQL = """
                DECLARE
                    v_idVenta proyectoIntegrador.venta.id%TYPE;
                BEGIN
        
                    SELECT id INTO v_idVenta
                    FROM proyectoIntegrador.venta
                    WHERE cedulaCliente = ?;

                    INSERT INTO proyectoIntegrador.cuota
                    VALUES (proyectoIntegrador.cuota_id_seq.nextval, ?, 'Proxima a Vencer', ADD_MONTHS(?, 1), '1',  ?, v_idVenta);
                END;
            """;
        
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
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }

        closeConnection();

    }

}
