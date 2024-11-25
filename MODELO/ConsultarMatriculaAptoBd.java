package MODELO;
import java.sql.*;

public class ConsultarMatriculaAptoBd extends ConexionBd{

    /**
     * Método principal de la clase que devuelve un valor booleano.
     * Se encarga de consultar la matricula del apartamento en la tabla venta
     * pasándole como parámetro la matricula del apartamento a buscar
     */
    public boolean consultarMatriculaBd(String matricula){
        
        // se crea la conexión con el usuario asesorg6 y la contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");

        // sentencia SQL a ejecutar
        String sentencia = """
                SELECT matriculaApto
                FROM proyectoIntegradorg6.venta
                WHERE matriculaApto = ?
                """;

        /**
         * Se prepara la sentencia y se reemplaza el valor del signo ? por la variable.
         * Se ejecuta la sentencia y se retorna verdadero o falso dependiendo si la consulta
         * devuelve un valor o no devuelve nada, si no devuelve nada es porque no existe ninguna venta
         * con esa matricula de apartamento
         */
        try {

            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, matricula);
            ResultSet resultset = statement.executeQuery();

            //se cierra el statement, el resultset y se retorna verdadero o galso
            statement.close();
            resultset.close();
            return resultset.next();

        } catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }

        // retorno de un valor por defecto para que la función no arroje error
        return false;

    }
}
