/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author pierr
 */
public class ConexionBd {

    private String url = "";
    private String usuario = "";
    private String contraseña = "";
    public Connection con = null;

    public ConexionBd(){

        url = "jdbc:oracle:thin:@localhost:1521:XE";
        usuario = "proyectoIntegrador";
        contraseña = "pg6";

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

    // método para el verificado del inicio de sesión de asesores
    public ResultSet DatosInicioAsesor(String cedula, String contraseña) throws SQLException {

        PreparedStatement statement = con.prepareStatement("SELECT cedula, contrasenna FROM asesor WHERE cedula = ? AND contrasenna = ?");
        statement.setString(1, cedula);
        statement.setString(2, contraseña);
        ResultSet res = statement.executeQuery();

        return res;

    }

    // método para obtener la información del asesor
    public ResultSet obtenerAsesor(String cedula) throws SQLException {

        PreparedStatement statement = con.prepareStatement("SELECT * FROM asesor WHERE cedula=?");
        statement.setString(1, cedula);
        ResultSet res = statement.executeQuery();

        return res;

    }
    

    // método para obtener los datos de las tablas
    public ResultSet consultarBd(String nombreTabla) throws SQLException {

        PreparedStatement statement = con.prepareStatement("SELECT * FROM ?");
        statement.setString(1, nombreTabla);
        ResultSet res = statement.executeQuery();

        return res;
    }

}
