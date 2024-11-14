package MODELO;
import java.util.*;
import java.sql.*;

public class ProyectosBd extends ConexionBd{
    
    public Hashtable<String, ArrayList<String>> consultarProyectos(String usuario, String contraseña) throws SQLException{

        Connection conexion = this.getConnection(usuario, contraseña);
        
        Hashtable<String, ArrayList<String>> hashProyectos = new Hashtable<>();
        String sentencia = """
                SELECT * 
                FROM proyectoIntegrador.PROYECTO
                """;
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        ResultSet resultset = statement.executeQuery();

        while(resultset.next()){
 
            ArrayList<String> datosProyecto = new ArrayList<>();
            String id = resultset.getString("id");
            String nombre = resultset.getString("nombre");
            String numTorres = String.valueOf(resultset.getInt("numTorres"));
            String direccion = resultset.getString("direccion");
            datosProyecto.add(nombre);
            datosProyecto.add(direccion);
            datosProyecto.add(numTorres);

            hashProyectos.put(id, datosProyecto);
           
        }

        statement.close();
        resultset.close();
        closeConnection();
        
        return hashProyectos;

    }

}
