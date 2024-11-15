package CONTROLADOR;

import MODELO.*;

//Clase encargada de hacer la peticion a modelo del reporte de las ventas por proyecto, es decir, las ventas de cada proyecto, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD

public class ReporteVentasProyecto extends ConexionControladorBd {
    
    //Metodo encargado de hacer la peticion del reporte a Bd, recibimos el nombre del proyecto que queremos reportar las ventas.
    public String reporteVentasProyecto(String nombreProyecto){
        //Instanciamos la clase que contiene el metodo para hacer el reporte
        ReporteVentasPorProyectoBd reporte = new ReporteVentasPorProyectoBd();
        //creamos una variable para almacenar el retorno del metodo de modelo con el objeto ejecutamos el metodo que hara el reporte.
        String mensaje = reporte.reporteVentasPorProyecto(nombreProyecto);
        //retornamos la variable.
         return mensaje;
    }
    
}
