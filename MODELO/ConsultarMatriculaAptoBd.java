package MODELO;
import java.sql.*;

public class ConsultarMatriculaAptoBd extends ConexionBd{

    public boolean consultarMatriculaBd(String matricula){
        
        Connection conexion = this.getConnection("asesor", "asesor");

        String sentencia = """
                SELECT matriculaApto
                FROM proyectoIntegrador.venta
                WHERE matriculaApto = ?
                """;
        try {

            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, matricula);
            ResultSet resultset = statement.executeQuery();
            return resultset.next();

        } catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }

        return false;

    }
}
