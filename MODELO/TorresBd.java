package MODELO;
import java.sql.*;
import java.util.*;

public class TorresBd extends ConexionBd{


    /**
     * 
     * Método principal de la clase para consultar las torres de un proyecto, que devuelve
     * un hashtable con todos los registros de la tabla torre donde la llave foránea idProyecto concuerde con
     * el valor de la variable idProyecto pasada en el parámetro.
     * 
     */
    public Hashtable<String, ArrayList<String>> consultarTorreProyecto(String idProyecto, String usuario, String contraseña) throws SQLException {

        Connection conexion = this.getConnection(usuario, contraseña);

        Hashtable<String, ArrayList<String>> hashTorres = new Hashtable<>();

        String sentencia = "SELECT * FROM proyectoIntegradorg6.torre WHERE idProyecto = ?";
        
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        statement.setString(1, idProyecto);

        ResultSet resultset = statement.executeQuery();
        
        while(resultset.next()){
 
            ArrayList<String> datosTorre = new ArrayList<>();
            datosTorre.add(resultset.getString("numTorre"));
            datosTorre.add(resultset.getString("numApartamentos"));
            datosTorre.add(resultset.getString("idProyecto"));

            hashTorres.put(resultset.getString("id"), datosTorre);
           
        }

        // cierre del statement, el resultset y la conexión
        statement.close();
        resultset.close();
        closeConnection();

        //retorno del hashtable
        return hashTorres;

    }

}
