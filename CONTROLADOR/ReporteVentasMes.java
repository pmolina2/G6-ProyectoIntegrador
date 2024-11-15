package CONTROLADOR;

import MODELO.ReporteVentasMesBd;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;

public class ReporteVentasMes extends ConexionControladorBd{
    
    public void ventasPorMes() throws FileNotFoundException, DocumentException{
        
        ReporteVentasMesBd reporte = new ReporteVentasMesBd();

        reporte.reporteVentasMes();
    }
}
