package MODELO;
import java.util.*;
import java.sql.*;

public class TorresBd extends ConexionBd{
    
    public Hashtable<String, ArrayList<String>> consultarTorreProyecto(String idProyecto) throws SQLException {

        Connection conexion = this.getConnection();

        Hashtable<String, ArrayList<String>> hashTorres = new Hashtable<>();

        String sentencia = "SELECT * FROM torre WHERE idProyecto = ?";
        
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        statement.setString(1, idProyecto);

        ResultSet resultset = statement.executeQuery();
        
        while(resultset.next()){
 
            ArrayList<String> datosTorre = new ArrayList<>();
            datosTorre.add(resultset.getString("numTorre"));
            datosTorre.add(resultset.getString("numApartamento"));
            datosTorre.add(resultset.getString("idProyecto"));

            hashTorres.put(resultset.getString("id"), datosTorre);
           
        }

        statement.close();
        resultset.close();
        closeConnection();

        return hashTorres;

    }

}
