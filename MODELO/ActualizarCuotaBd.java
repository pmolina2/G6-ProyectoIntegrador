package MODELO;

import java.sql.*;

public class ActualizarCuotaBd extends ConexionBd {
    
    //método principal de la clase para actualizar la información e una fila en la tabla Cuota
    public void actualizarCuotaBd(String idCuota){

        //se crea la conexión a la base de datos con el usuario asesorg6 y la contraseña asesor. Sólo el usuario asesor tiene acceso a esta sección del programa
        Connection conexion = this.getConnection("asesorg6", "asesor");

        /*  bloque PL/SQL a ejecutar llamando al procedimiento actualizarCuota() pasandole como parámetro el id de la cuota.
            Este procedimiento lo que hace es sumarle un mes a la fecha de la cuota para que sea la cuota del siguiente mes y sumarle uno a
            el número de cuota de la deuda total
        */
        String bloquePLSQL = """
            BEGIN
                proyectointegradorg6.actualizarcuota(?);
            END;
            """;

            /*
                Try - Catch con la creación del statement y la ejecución del bloque anónimo anteriormente definido
             */
            try (CallableStatement statement = conexion.prepareCall(bloquePLSQL)){
                statement.setString(1, idCuota);
    
                // Ejecutar la llamada de la sentencia
                statement.executeUpdate();
                
                // Cerrar el statement
                statement.close();
    
            //Prevención de errores SQL,  en caso de que ocurra algo inesperado saltará el código dentro de las llaves
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }

            //cerrar la conexión
            closeConnection();
    }   

}
