package CONTROLADOR;

import MODELO.*;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Clase encargada de hacer la peticion a modelo del reporte de las ventas de un asesor en especifico, extiende la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD
public class ReporteVentasAsesor extends ConexionControladorBd {
    
    //Metodo que hara la peticion a modelo para el reporte, para ello recibe la cedula del asesor como parametro y retornara un string.
    public String reporteVentasAsesor(String cedulaAsesor){
        //Instanciamos la clase que contiene el metodo encargado del reporte.
        ReporteVentasAsesorBd reporte = new ReporteVentasAsesorBd();
        
        //Abrimos un try-catch, esto para manejar las excepciones provenientes de Bd
        try {
            //Si no hay ningun error en modelo, retornamos el mensaje que nos dé modelo.
            return reporte.reporteVentasAsesor(cedulaAsesor);
            //En caso de haber algun error, FileNotFoundException Ocurre si el archivo que se intenta abrir o escribir no existe o no es accesible.
            // y DocumentException Lanzada por ifile cuando hay errores en la creacion del archivo.
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ReporteVentasAsesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
