/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ConexionBd;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pierr
 */

// Clase para el inicio de sesion
public class InicioSesionC {

    // metodo para verificar el inicio de sesion
    public boolean verificacionInicio(String cedula, String contraseña) {

        ConexionBd c = new ConexionBd();
        try {
            ResultSet rs = c.DatosInicioAsesor(cedula, contraseña);
            while (rs.next()) {
                return cedula.equals(rs.getString("cedula"))
                        && contraseña.equals(rs.getString("contrasenna"));
            }
        } catch (SQLException sqlex) {
            System.out.println("Error " + sqlex.getMessage());
            return false;
        }

        c.closeConnection(c.con);
        return true;

    }

    // metodo para obtener la informacion del asesor
    public String consultarAsesor(String cedula) {

        ConexionBd c = new ConexionBd();
        try {
            ResultSet rs = c.obtenerAsesor(cedula);
            while (rs.next()) {
                System.out.println(rs.getString("nombreCompleto"));
            }

            while (rs.next()) {
                return rs.getString("NombreCompleto");
            }
        } catch (SQLException sqlex) {
            System.out.println("Error " + sqlex.getMessage());
        }

        c.closeConnection(c.con);
        return "";

    }

}
