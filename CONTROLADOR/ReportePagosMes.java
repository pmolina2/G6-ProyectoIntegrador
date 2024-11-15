package CONTROLADOR;

import MODELO.*;

//Clase encargada de hacer la peticion a modelo del reporte de los pagos del presente mes, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD
public class ReportePagosMes extends ConexionControladorBd{
    
    //metodo encargado de hacer la peticion a Bd para el reporte
    public void reportePagosMes(){
        //Instanciamos la clase que contiene el metodo para hacer el reporte
        ReportePagosMesBd reporte = new ReportePagosMesBd();
        //Con el objeto ejecutamos el metodo que hara el reporte.
        reporte.reportePagosMesBd();
    }
    
}
