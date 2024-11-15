package CONTROLADOR;

import MODELO.*;
import java.io.FileNotFoundException;
import com.itextpdf.text.DocumentException;


//Clase encargada de hacer la peticion a modelo del reporte de los pagos de un cliente en especifico, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD
public class ReportePagosCedula extends ConexionControladorBd {

    //metodo encargado de enviar la cedula del cliente proveniente de vista y hacer la peticion a modelo para el reporte.
    public String devolverPagos(String cedula) throws FileNotFoundException, DocumentException{
    //Creamos una instancia de la clase encargada de hacer el reporte en modelo.
    ReportePagosClienteBd pagoBd = new ReportePagosClienteBd();
    //Creamos una variable string para capturar el retorno proveniente del metodo que hara el reporte.
    String mensaje = pagoBd.consultarPagosCedula(cedula); 
    //Retornamos la variable hacia vista.
    return mensaje;
    } 

}
