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



//CLASE PADRE ConexionBd QUE HACE LA CONEXION Y SE EXTIENDE A TODAS LAS CLASES PARA RELIZAR LAS CONSULTAS
public class ConexionBd {

    //VARIABLES DE LA CLASE

    //ENCARGADA DE REALIZAR LA CONEXION, LOS DATOS SE OBTIENEN DEL ARCHIVO LISTENER.ORA EN LOS ARCHIVOS DE ORACLE
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";

    //USUARIO Y CONTRASEÑA DEL USUARIO DE LA BASE DE DATOS.
    private String usuario = "proyectoIntegradorpg6";
    private String contraseña = "pg6";

    //OBJETO Connection con QUE ALMACENA LA CONEXION EN UNA VARIABLE, VALOR POR DEFECTO NULL.
    public Connection con = null;

    //CONSTRUCTOR DE LA CLASE
    public ConexionBd(){
        
    }

    //METODO PARA OBTENER LA CONEXION
    public Connection getConnection() {
        try {
            this.con = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return this.con;
    }

    //METODO PARA CERRAR LA CONEXION, ES RECOMENDABLE HACERLO DESPUES DE CADA CONSULTA PARA EVITAR ERRORES.
    public void closeConnection() {
        
        if (con != null) {
            try {
                con.close();
            } catch (SQLException sqlex) {
                System.out.println("Error " + sqlex.getMessage());
                Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, sqlex);
            }

        }
    }

}
