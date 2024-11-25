package MODELO;
import java.sql.*;
import java.util.*;

public class ProyectosBd extends ConexionBd{
    
    /**
     * 
     * Método principal de la clase encargado de realizar la consulta de proyectos. Se pasan como parámetros el usuario y la contraseña
     * a la base de datos porque tanto el administrador como el asesor tendrán acceso a esta sección del programa.
     * Este método devuelve un hashtable con todos los registros de la tabla Proyecto
     * 
     */
    public Hashtable<String, ArrayList<String>> consultarProyectos(String usuario, String contraseña) throws SQLException{

        Connection conexion = this.getConnection(usuario, contraseña);
        
        Hashtable<String, ArrayList<String>> hashProyectos = new Hashtable<>();
        String sentencia = """
                SELECT * 
                FROM proyectoIntegradorg6.PROYECTO
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
