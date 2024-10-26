package CONTROLADOR;

import MODELO.ConexionBd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Clase de operacion entre vista y logica, encargada del inicio de sesion.

public class InicioSesionC {

    ConexionBd conexion = new ConexionBd();

    // Método para verificar las credenciales del usuario, recibiendo un string cedula y otro string contraseña, proveniente del package vista
    // utilizamos un Arraylist llamado datos, el cual, después de verificar que la cedula ingresada, existe en la tabla de asesor o en
    // la tabla de administrador, agrega la informacion al arraylist y esta se retorna hacia el package vista.

    public ArrayList<String> verificacionInicio(String cedula, String contraseña) {

        ArrayList<String> datos = new ArrayList<>();

        try {
            ResultSet asesor = conexion.consultarBd("asesor");
            ResultSet administrador = conexion.consultarBd("administrador");

            while (asesor.next()) {
                String cedAsesor = asesor.getString("cedula");
                String contraAsesor = asesor.getString("contrasenna");

                if (cedAsesor.equals(cedula) && contraAsesor.equals(contraseña)) {
                    datos.add(cedula);
                    datos.add(contraseña);
                    datos.add("asesor");

                    return datos;
                }

            }

            while (administrador.next()) {
                String cedAdmin = administrador.getString("cedula");
                String contraAdmin = administrador.getString("contrasenna");

                if (cedAdmin.equals(cedula) && contraAdmin.equals(contraseña)) {
                    datos.add(cedula);
                    datos.add(contraseña);
                    datos.add("administrador");

                    return datos;
                }

            }
        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }
        return null;
    }

}
