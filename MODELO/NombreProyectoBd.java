package MODELO;
import java.sql.*;

public class NombreProyectoBd extends ConexionBd{
    
    /**
     * 
     * Método principal de la clase encargado de consultar el nombre de un proyecto
     * pasándole como parámetro la matricula del apartamento, se reemplaza el valor de los
     * signos ? por los valores en las variable matricula para que el resultset contenga un único registro
     * donde las matriculas coincidan, se retorna el nombre del proyecto y si no se encuentra ninguna
     * coincidencia se retorna una cadena vacía
     * 
     */
    public String consultarNombreProyecto(String matricula) throws SQLException{

        Connection conexion = this.getConnection("asesorg6", "asesor");
        
        String sentencia = """
                SELECT p.nombre
                FROM proyectoIntegradorg6.proyecto p
                JOIN proyectoIntegradorg6.torre t ON p.id = t.idProyecto
                JOIN proyectoIntegradorg6.apartamento a ON a.idTorre = t.id
                WHERE a.matricula = ?
                """;
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        statement.setString(1, matricula);
        ResultSet resultset = statement.executeQuery();

        if(resultset.next()){
            return resultset.getString("nombre");
        } 

        statement.close();
        resultset.close();
        closeConnection();
        return "";

    }

}
