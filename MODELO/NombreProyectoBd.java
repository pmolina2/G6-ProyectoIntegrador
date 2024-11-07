package MODELO;
import java.sql.*;

public class NombreProyectoBd extends ConexionBd{
    
    public String consultarNombreProyecto(String matricula) throws SQLException{

        Connection conexion = this.getConnection();
        
        String sentencia = """
                SELECT p.nombre
                FROM proyecto p
                JOIN torre t ON p.id = t.idProyecto
                JOIN apartamento a ON a.idTorre = t.id
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
