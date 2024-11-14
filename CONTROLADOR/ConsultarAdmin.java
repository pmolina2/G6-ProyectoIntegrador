package CONTROLADOR;

import Dominio.*;
import MODELO.*;
import java.util.ArrayList;

//Clase de operacion entre logica y modelo, extendemos la clase abstracta ConexionControladorBd para la conexion a Bd

public class ConsultarAdmin extends ConexionControladorBd {

    // Método de tipo "Admin", que recibe un parametro String ced (cedula) proveniente del package vista, sirve para validar
    // que la cedula existe en la base de datos, y además retornando la información de ese administrador hacia el package vista.
 
    public Admin devolverAdmin(String ced) {
        try {
            //Consulta la informacion haciendo una consulta en Modelo utilizando la clase llamada UsuarioBd
            UsuarioBd usuario = new UsuarioBd();

            //La informacion de la consulta se almacena en un arraylist de tipo string
            ArrayList<String> admin = usuario.consultarUsuario("administrador", ced);

            // Verifica si el ArrayList no está vacío y si la cédula coincide con la buscada
            if (!admin.isEmpty() && admin.get(0).equals(ced)) {
                //si existe, descompone el arraylist dandole valores a las variables declaradas
                String cedula = admin.get(0);
                String nombreCompleto = admin.get(1);
                String direccion = admin.get(2);
                String telefono = admin.get(3);
                String correo = admin.get(4);
                String contraseña = admin.get(5);

                // crea y retorna un nuevo objeto admin con las variables anteriores.
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
