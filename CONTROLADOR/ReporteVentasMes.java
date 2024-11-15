package CONTROLADOR;

import MODELO.ReporteVentasMesBd;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;

//Clase encargada de hacer la peticion a modelo del reporte de las ventas del mes presente, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD

public class ReporteVentasMes extends ConexionControladorBd{
    //metodo encargado de hacer la peticion a Bd para el reporte, En caso de haber algun error, FileNotFoundException Ocurre si el archivo que se intenta abrir o escribir no existe o no es accesible.
    // y DocumentException Lanzada por ifile cuando hay errores en la creacion del archivo.
    public void ventasPorMes() throws FileNotFoundException, DocumentException{
        
        //Instanciamos la clase que contiene el metodo para hacer el reporte
        ReporteVentasMesBd reporte = new ReporteVentasMesBd();
        //Con el objeto ejecutamos el metodo que hara el reporte.
        reporte.reporteVentasMes();
    }
}
