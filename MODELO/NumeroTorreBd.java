package MODELO;
import java.sql.*;

public class NumeroTorreBd extends ConexionBd{
    
    /**
     * Método principal de la clase, encargado de obtener el número de la torre
     * del que el apartamento cuya matricula sea parte de dicha torre.
     */
    public String consultarNumTorre(String matricula) throws SQLException{

        Connection conexion = this.getConnection("asesorg6","asesor");

        String sentencia = """
                SELECT t.numTorre
                FROM proyectointegradorg6.apartamento a
                JOIN proyectointegradorg6.torre t ON a.idTorre = t.id
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
