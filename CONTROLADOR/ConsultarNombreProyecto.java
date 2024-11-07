package CONTROLADOR;

import MODELO.*;


public class ConsultarNombreProyecto extends ConexionControladorBd{

    public String devolverNombreProyecto(String matricula){
         //Inicio de la conexion a Bd con la clase NombreProyectoBd
        NombreProyectoBd nomProyectoBd = new NombreProyectoBd();
        try {
            //Ejecucion del metodo encargado de devolver el nombre del proyecto en el package modelo.
            String nombreProyecto = nomProyectoBd.consultarNombreProyecto(matricula);
            return nombreProyecto;
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        //Retorno de la variable con el nombre del proyecto ya almacenado.
        return "";

    }
    
}