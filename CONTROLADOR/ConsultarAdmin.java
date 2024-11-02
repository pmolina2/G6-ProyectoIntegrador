package CONTROLADOR;

import Dominio.*;
import MODELO.*;
import java.util.ArrayList;

//Clase de operacion entre logica y modelo, implementamos la interfaz de ConexionControladorBd para agilizar el proceso de conexion.

public class ConsultarAdmin extends ConexionControladorBd {

    // Método de tipo "Admin", que recibe un parametro String ced (cedula) proveniente del package vista, sirve para validar
    // que la cedula existe en la base de datos, y además retornando la información de ese administrador hacia el package vista.
 
    public Admin devolverAdmin(String ced) {
        try {
            // Consulta los datos del usuario y almacénalos en el ArrayList
            UsuarioBd usuario = new UsuarioBd();
            ArrayList<String> admin = usuario.consultarUsuario("administrador", ced);

            // Verifica si el ArrayList no está vacío y si la cédula coincide con la buscada
            if (!admin.isEmpty() && admin.get(0).equals(ced)) {
                String cedula = admin.get(0);
                String nombreCompleto = admin.get(1);
                String direccion = admin.get(2);
                String telefono = admin.get(3);
                String correo = admin.get(4);
                String contraseña = admin.get(5);

                // Crea y retorna el objeto Admin
                return new Admin(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
            } else {
                System.out.println("No se encontró un administrador con la cédula: " + ced);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null; // Retorna null si no encuentra coincidencia o hay un error
    }


}
