package CONTROLADOR;

import java.util.ArrayList;
import Dominio.*;
import MODELO.*; 

//Clase encargada de la consulta de la info de los asesores, extiende la clase ConexionControladorBd para agilizar la conexion a BD

public class ConsultarAsesor extends ConexionControladorBd {

    // Método encargado de obtener la informacion del asesor, que retorna un objeto de clase Asesor, ademas de recibit
    //un string llamado ced(cedula) proveniente del package vista.

    public Asesor devolverAsesor(String ced) {

        try {
            //Inicia la conexion a BD mediante la clase UsuarioBd.
            UsuarioBd usuario = new UsuarioBd();
            //Obtenemos un ArrayList de strings, provenientes del metodo consultarAsesor, de la clase UsuarioBd
            //le pasamos como parametros el nombre de la tabla en este caso asesor y el string de la cedula.
            ArrayList<String> asesor = usuario.consultarUsuario("asesor", ced);
            //Descomponemos el arraylist, dandole valores a las variables
            String cedula = asesor.get(0);
            String nombreCompleto = asesor.get(1);
            String direccion = asesor.get(2);
            String telefono = asesor.get(3);
            String correo = asesor.get(4);
            String contraseña = asesor.get(5);

            //Con las variables creamos un nuevo objeto de tipo Asesor.
            Asesor pAsesor = new Asesor(cedula, nombreCompleto, direccion, telefono, correo, contraseña);
            //Retornamos el objeto de tipo asesor recien creado al package Vista.
            return pAsesor;

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        //En caso de no poder encontrar el asesor, se retornara nulo.
        return null;

    }

}