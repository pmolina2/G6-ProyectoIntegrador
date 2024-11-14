package CONTROLADOR;

import MODELO.*;

//Clase encargada de obtener el nombre del proyecto, extendemos la clase abstracta conexioncontroladorbd para facilitar la conexion a bd.

public class ConsultarNombreProyecto extends ConexionControladorBd{

    //Metodo que retornara el nombre del proyecto, recibe la matricula del apartamento como parametro.

    public String devolverNombreProyecto(String matricula){

         //Inicio de la conexion a Bd con la clase NombreProyectoBd
        NombreProyectoBd nomProyectoBd = new NombreProyectoBd();
        try {
            //Ejecucion del metodo encargado de devolver el nombre del proyecto en el package modelo.
            //Guardamos el retorno del metodo en una variable de tipo string
            String nombreProyecto = nomProyectoBd.consultarNombreProyecto(matricula);
            //Retornamos la variable donde se almaceno el nombre del proyecto.
            return nombreProyecto;
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        
        return "";

    }
    
}