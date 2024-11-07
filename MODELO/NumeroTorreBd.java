package MODELO;
import java.sql.*;

public class NumeroTorreBd extends ConexionBd{
    
    public String consultarNumTorre(String matricula) throws SQLException{

        Connection conexion = this.getConnection();

        String sentencia = """
                SELECT t.numTorre
                FROM apartamento a
                JOIN torre t ON a.idTorre = t.id
                WHERE a.matricula = ?
                """;
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        statement.setString(1, matricula);
        ResultSet resultset = statement.executeQuery();

        if(resultset.next()){
            return resultset.getString("numTorre");
        }

        statement.close();
        resultset.close();
        closeConnection();
        return "";

    }

}
