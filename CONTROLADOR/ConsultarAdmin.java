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
public class ConsultarAdmin implements ConexionControladorBd {

    // método para devolver un objeto asesor a la vista
    public Admin devolverAdmin(String ced) {

        try {

            ResultSet admin = conexion.consultarBd("administrador");
            while (admin.next()) {
                String cedula = admin.getString("cedula");
                String nombreCompleto = admin.getString("nombreCompleto");
                String direccion = admin.getString("direccion");
                String telefono = admin.getString("telefono");
                String correo = admin.getString("correoElectronico");
                String contraseña = admin.getString("contrasenna");

                if (cedula.equals(ced)) {
                    return new Admin(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
                }
            }

        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;
    }

}
