package MODELO;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActualizarFechaBd extends ConexionBd{

    /*método principal de la clase para actualizar la fecha de la escritura en la tabla apartamento 
      al momento de hacer la venta
    */
    public void actualizarFechaEscritura(String matricula, String fecha){

        //se crea la conexión con el usuario asesorg6 y la contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");

        //se define la sentencia a ejecutar
        String sentencia = """
                UPDATE proyectoIntegradorg6.apartamento
                SET fechaEscritura = ?
                WHERE matricula = ?
                """;

        try (PreparedStatement statement = conexion.prepareStatement(sentencia)){
           
            /*
                Ajuste del dato de la fecha para poder almacenarla en la tabla
                esto se realiza porque SQL tiene un tipo de dato definido para las fechas
                con su formato, si queremos guardar la fecha como una string o como un tipo de dato fecha
                de la libreria java.util.Date dará error
             */
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
            java.sql.Date fechaSql = null;
            
            try {
                java.util.Date fechaUtil = formato.parse(fecha);
                fechaSql = new java.sql.Date(fechaUtil.getTime());
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha: " + e.getMessage());
            }

            // creación de los parametros de la PreparedStatement para reemplazar el simbolo ? con las variables en la sentencia
            statement.setDate(1, fechaSql);
            statement.setString(2, matricula);
            statement.executeUpdate(); 

            // cierre del statement
            statement.close();

        //Prevención de errores SQL,  en caso de que ocurra algo inesperado saltará el código dentro de las llaves
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        // cierre de la conexión
        closeConnection();
    }

}

