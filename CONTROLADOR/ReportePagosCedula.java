package CONTROLADOR;

import MODELO.*;
import java.io.FileNotFoundException;
import com.itextpdf.text.DocumentException;


//Clase encargada de obtener la info de las cuotas de todos los clientes, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD
public class ReportePagosCedula extends ConexionControladorBd {

    //metodo encargado de obtener y retornar la informacion de las cuotas.
    public String devolverPagos(String cedula) throws FileNotFoundException, DocumentException{

    ReportePagosClienteBd pagoBd = new ReportePagosClienteBd();

    String mensaje = pagoBd.consultarPagosCedula(cedula); // TODO: handle exception
        
    return mensaje;
    } 

}
