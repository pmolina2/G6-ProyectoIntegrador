package CONTROLADOR;

import java.util.ArrayList;
import Dominio.*;
import MODELO.*; 


//Clase de operacion entre logica y modelo, implementa la interfaz ConexionControladorBd para agilizar el proceso de conexion a base de datos.

public class ConsultarAsesor extends ConexionControladorBd {

    // Método de tipo "Asesor", recibe un parametro String ced (cedula), sirve para validar la existencia del asesor relacionado con esa cedula
    // además, retornando la informacion correspondiente a ese asesor, hacia el package vista.

    public Asesor devolverAsesor(String ced) {

        try {
            UsuarioBd usuario = new UsuarioBd();
            ArrayList<String> asesor = usuario.consultarUsuario("asesor", ced);
            String cedula = asesor.get(0);
            String nombreCompleto = asesor.get(1);
            String direccion = asesor.get(2);
            String telefono = asesor.get(3);
            String correo = asesor.get(4);
            String contraseña = asesor.get(5);

            Asesor pAsesor = new Asesor(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
            return pAsesor;

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return null;

    }

}