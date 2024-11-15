package CONTROLADOR;

import MODELO.*;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteVentasAsesor extends ConexionControladorBd {
    
    public String reporteVentasAsesor(String cedulaAsesor){
        
        ReporteVentasAsesorBd reporte = new ReporteVentasAsesorBd();
        
        
        try {
            return reporte.reporteVentasAsesor(cedulaAsesor);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteVentasAsesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ReporteVentasAsesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
