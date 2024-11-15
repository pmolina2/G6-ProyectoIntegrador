package CONTROLADOR;

import MODELO.*;

public class ReportePagosMes extends ConexionControladorBd{
    
    public void reportePagosMes(){
        
        ReportePagosMesBd reporte = new ReportePagosMesBd();
        
        reporte.reportePagosMesBd();
    }
    
}
