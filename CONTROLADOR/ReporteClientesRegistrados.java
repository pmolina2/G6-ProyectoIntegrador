package CONTROLADOR;

import MODELO.*;

//Clase encargada de pedir a modelo el reporte de los clientes registrados.
//Extendemos la clase abstracta para facilitar la conexion a Bd
public class ReporteClientesRegistrados extends ConexionControladorBd{
    //Metodo que hara la peticion a modelo.
    public void reporteClientes(){
        //Creamos la instancia de la clase de modelo.
        ReporteClientesRegistradosBd reporteC = new ReporteClientesRegistradosBd();
        //Con el objeto de la clase, ejecutamos el metodo que hara el reporte.
        reporteC.reporteClientesBd();
    }
    
}
