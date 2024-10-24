/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import java.sql.*;

/**
 *
 * @author pierr
 */
public class ConsultarAsesor implements ConexionControladorBd {

    // método para devolver un objeto asesor a la vista
    public Asesor devolverAsesor(String ced) {

        try {

            ResultSet asesor = conexion.consultarBd("asesor");
            while (asesor.next()) {
                String cedula = asesor.getString("cedula");
                String nombreCompleto = asesor.getString("nombreCompleto");
                String direccion = asesor.getString("direccion");
                String telefono = asesor.getString("telefono");
                String correo = asesor.getString("correoElectronico");
                String contraseña = asesor.getString("contrasenna");

                if (cedula.equals(ced)) {
                    return new Asesor(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
                }

            }

        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;
    }

}
