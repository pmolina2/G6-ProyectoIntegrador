package CONTROLADOR;

import MODELO.*;

public class ReporteVentasProyecto extends ConexionControladorBd {
    
    public String reporteVentasProyecto(String nombreProyecto){
        
        ReporteVentasPorProyectoBd reporte = new ReporteVentasPorProyectoBd();
        
        String mensaje = reporte.reporteVentasPorProyecto(nombreProyecto);
        
         return mensaje;
    }
    
}
