package CONTROLADOR;

<<<<<<< Updated upstream
import MODELO.ConexionBd;
import java.sql.ResultSet;
import java.sql.SQLException;
=======
>>>>>>> Stashed changes
import java.util.ArrayList;
import MODELO.*;

// Clase de operacion entre vista y logica, encargada del inicio de sesion.

<<<<<<< Updated upstream
public class InicioSesionC {

    ConexionBd conexion = new ConexionBd();
=======
public class InicioSesionC extends ConexionControladorBd{
>>>>>>> Stashed changes

    // Método para verificar las credenciales del usuario, recibiendo un string cedula y otro string contraseña, proveniente del package vista
    // utilizamos un Arraylist llamado datos, el cual, después de verificar que la cedula ingresada, existe en la tabla de asesor o en
    // la tabla de administrador, agrega la informacion al arraylist y esta se retorna hacia el package vista.

    public ArrayList<String> verificacionInicio(String cedula, String contraseña) {

        ArrayList<String> datos = new ArrayList<>();

        try {
            InicioSesionBd inicioSesion = new InicioSesionBd();
            ArrayList<String> asesor = inicioSesion.consultarInicioSesion("asesor", cedula, contraseña);
            ArrayList<String> administrador = inicioSesion.consultarInicioSesion("administrador", cedula, contraseña);

            if(!administrador.isEmpty() && administrador.get(0).equals(cedula) && administrador.get(1).equals(contraseña)){

                datos.add(cedula);
                datos.add(contraseña);
                datos.add("administrador");
                
            } else if (!asesor.isEmpty() && asesor.get(0).equals(cedula) && asesor.get(1).equals(contraseña)) {
                datos.add(cedula);
                datos.add(contraseña);
                datos.add("asesor");


            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return datos;
    }

}
