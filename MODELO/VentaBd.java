package MODELO;
import java.sql.*;
import java.text.ParseException; 
import java.text.SimpleDateFormat;

public class VentaBd extends ConexionBd {

    /**
     * Método principal de la clase encargado de guardar un registro en la tabla Venta pasandole los datos
     * de la fila como parámetros los datos de las columnas
     */
    public String registrarVenta(String precio, int numCuotas, int intereses, String cedulaAsesor, String matricula, String cedulaCliente, String fechaEscritura) {

        // se realiza la conexión a la base de datos con el usuario asesorg6 y contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");
        String mensaje = "";

        String sentencia = """
                INSERT INTO proyectoIntegradorg6.venta
                VALUES(proyectoIntegradorg6.venta_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?)
                """;
        
        try {
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, precio);
            statement.setInt(2, numCuotas);
            statement.setInt(3, intereses);
            statement.setString(4, cedulaAsesor);
            statement.setString(5, matricula);

            // adaptación de la fecha a formato SQL DATE para su ingreso
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaUtil; 
            java.sql.Date fechaSql = null;

            try {
                fechaUtil = formato.parse(fechaEscritura);
                fechaSql = new Date(fechaUtil.getTime());
            } catch (ParseException e) {
                mensaje = ("Error al parsear la fecha: " + e.getMessage());
                return mensaje;
            }

            // Reemplazar los signos ? por las variables en orden
            statement.setString(6, cedulaCliente);
            statement.setDate(7, fechaSql);
            statement.executeQuery();

            // asignación del mensaje y cerrar el statement y la conexión
            mensaje = "Venta registrada exitosamente \n Se ha creado la cuota actual de este cliente.";
            statement.close();
            closeConnection();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20004) { 
                mensaje = "Error: La cédula ingresada no corresponde con \n ningún cliente registrado en la Base de Datos";
            } else if(e.getErrorCode() == 20005){
                mensaje = "Error: El cliente ingresado ya tiene otra \n venta activa, intente con otra cédula";
            } else {
                mensaje = ("Error al registrar la venta: " + e.getMessage());
            }
        }
        
        return mensaje;
    }

}
