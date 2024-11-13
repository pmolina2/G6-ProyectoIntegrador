package MODELO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class GuardarPagoBd extends ConexionBd{

    public String guardarPagoBd(String numeroReferencia, String metodoPago, String valorPago, String fecha, String cedulaCliente, String idCuota, String numeroCuota){
        
        String mensaje="";
        Connection conexion = this.getConnection("asesor", "asesor");

        // Procedimiento PL/SQL que invoca el procedimiento almacenado insertarPago
        String bloquePLSQL = """
            BEGIN
                proyectointegrador.insertarPago(?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?);
            END;
        """;

        try {
            // Crear CallableStatement para llamar al procedimiento almacenado
            CallableStatement statement = conexion.prepareCall(bloquePLSQL);

            // Establecer los parámetros de la llamada al procedimiento
            statement.setString(1, numeroReferencia);
            statement.setString(2, metodoPago);
            statement.setString(3, valorPago);
            statement.setString(4, fecha);  // La fecha debe tener el formato 'DD/MM/YYYY'
            statement.setString(5, cedulaCliente);
            statement.setString(6, idCuota);
            statement.setString(7, numeroCuota);

            // Ejecutar la llamada al procedimiento
            statement.executeUpdate();

            // Cerrar el statement
            statement.close();
            mensaje = "Pago registrado exitosamente, se ha actualizado\nla cuota actual del cliente.";
            System.out.println(mensaje);
            return mensaje;

        } catch (SQLException e) {
            if(e.getErrorCode() == 20006){
                mensaje = "Error: El pago se debe haber realizado en los últimos 3 días";
            }else{
                mensaje = ("Error al insertar el pago: " + e.getMessage());
            }
        }
        closeConnection();
        return mensaje;
    }
}
