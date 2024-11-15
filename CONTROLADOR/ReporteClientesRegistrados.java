package CONTROLADOR;

import MODELO.*;

public class ReporteClientesRegistrados extends ConexionControladorBd{
    
    public void reporteClientes(){
        ReporteClientesRegistradosBd reporteC = new ReporteClientesRegistradosBd();
        reporteC.reporteClientesBd();
    }
    
}
