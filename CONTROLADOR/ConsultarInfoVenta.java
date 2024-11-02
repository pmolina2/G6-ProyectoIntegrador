package CONTROLADOR;

import MODELO.*;

public class ConsultarInfoVenta extends ConexionControladorBd {
    
    public String devolverNumTorre(String matricula){

        NumeroTorreBd numTorreBd = new NumeroTorreBd();
        String numTorre = null;

        try {
            numTorre = numTorreBd.consultarNumTorre(matricula);
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }

        return numTorre;
    }

    public String devolverNombreProyecto(String matricula){
        NombreProyectoBd nomProyectoBd = new NombreProyectoBd();
        String nombreProyecto = null;

        try {
            nombreProyecto = nomProyectoBd.consultarNombreProyecto(matricula);
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }

        return nombreProyecto;

    }

}
