/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author pierre
 */


/*
    Clase ConexionBd encargada de realizar la conexión a la base de datos mediante el driverManager.
*/
public class ConexionBd {

    /*  Se almacenan los valores de la url de la conexión, el usuario junto a su clave en el servidor Oracle en este caso
        y la variable con que almacenará la conexión de la clase.
    */
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario = "proyectoIntegradorpg6";
    private String contraseña = "pg6";
    public Connection con = null;

    
    // Constructor de la clase que genera la conexión mediante los atributos anteriormente definidos
    public ConexionBd(){

        try {
            con = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    // getter del atributo con (Connection)
    public Connection getConnection() {
        return con;
    }

    //método para cerrar la conexión de la clase y sus instancias, pasandole la conexion del momento como parámetro.
    public void closeConnection(Connection con) {
        
        /*  
            si la conexion es distinta a nula, es decir, si existe una conexión, se cierra 
            mediante la función de la clase Connection .close().
            Siempre que se hacen operaciones SQL se hace un try catch con un SQLException "var" para prevenir
            posibles errores SQL
        */
        if (con != null) {
            try {
                con.close();
            } catch (SQLException sqlex) {
                System.out.println("Error " + sqlex.getMessage());
                Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, sqlex);
            }

        }
    }

    /*
        Método principal de consulta de la clase, obteniendo todos los registros
        de una tabla específica pasando su nombre como el parámetro "nombreTabla"
    
        throws SQLException se usa cuando la consulta devuelve un error SQL.
        Básicamente sería el equivalente a usar el try catch con SQLException
    */
    public ResultSet consultarBd(String nombreTabla) throws SQLException {

        PreparedStatement statement = con.prepareStatement("SELECT * FROM "+nombreTabla);
        ResultSet res = statement.executeQuery();

        return res;
    }
    
    /*
        Método para realizar consultas específicas. Con el fin de no sobre-
        cargar la clase con métodos se simplificó todo en un método que pide
        como parámetro la sentencia SQL a ejecutar desde el paquete controlador
    */
    public ResultSet consultarBdSentencia(String sentencia) throws SQLException{
        
        PreparedStatement statement = con.prepareStatement(sentencia);
        ResultSet res = statement.executeQuery();
        
        return res;
        
    }
    
    /*
        Todos los métodos de consulta devuelven un ResultSet que es un tipo
        de dato incluido en la biblioteca SQL de java.
    */

}
