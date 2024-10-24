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
public class ConexionBd {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario = "proyectoIntegradorpg6";
    private String contraseña = "pg6";
    public Connection con = null;

    public ConexionBd(){

        try {
            con = DriverManager.getConnection(url, usuario, contraseña);
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Base de datos conectada " + meta.getDriverName());
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException sqlex) {
                System.out.println("Error " + sqlex.getMessage());
                Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, sqlex);
            }

        }
    }

    // método para obtener los datos de las tablas
    public ResultSet consultarBd(String nombreTabla) throws SQLException {

        PreparedStatement statement = con.prepareStatement("SELECT * FROM "+nombreTabla);
        ResultSet res = statement.executeQuery();

        return res;
    }
    
    //método para que el constructor cree la sentencia que quiere realizar
    public ResultSet consultarBdSentencia(String sentencia) throws SQLException{
        
        PreparedStatement statement = con.prepareStatement(sentencia);
        ResultSet res = statement.executeQuery();
        
        return res;
        
    }

}
