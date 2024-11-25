package MODELO;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportePagosMesBd extends ConexionBd {
    
    /**
     * Método principal del programa encargado de la generación del reporte de los pagos realizados en el mes.
     * Se usa la libreria de Itext para la generación del documento enrutado automaticamente en el escritorio
     * del equipo que ejecute el programa
     */
    public void reportePagosMesBd(){
        Connection conexion = null;
        ResultSet resultset = null;
        Document documento = null;

        

        try {
            conexion = this.getConnection("adming6", "admin");

            String sentencia = """
            SELECT *
            FROM proyectoIntegradorg6.pago
            WHERE TO_CHAR(fecha, 'MM') = TO_CHAR(SYSDATE, 'MM')
            """;
            
            Statement statement = conexion.createStatement();
            resultset = statement.executeQuery(sentencia);
            

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
            String nombreMes = sdf.format(new Date());

            // generación del documento
            documento = new Document();
            String ruta = System.getProperty("user.home");

            // declaración de la ruta del documento
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pagos_Mes.pdf"));
            documento.open();

            // definición y agregación del titulo de la página
            Paragraph title = new Paragraph("REPORTE DE PAGOS DEL MES DE " + nombreMes.toUpperCase());
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(40);
            documento.add(title);

            PdfPTable tabla = new PdfPTable(7);
            Font fuentePequena = FontFactory.getFont(FontFactory.HELVETICA, 7.5f); 

            // agregar las celdas a la tabla con el método crearCeldaCentrada()
            tabla.addCell(crearCeldaCentrada("Transferencia", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Metodo Pago", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Valor Pago", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Fecha", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Cedula del cliente", fuentePequena));
            tabla.addCell(crearCeldaCentrada("id de la cuota", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Cuota Pagada", fuentePequena));

            while (resultset.next()) {
                tabla.addCell(crearCeldaCentrada(resultset.getString("numTransferencia"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("metodoPago"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("valorPago"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getDate("fecha").toString(), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("cedulaCliente"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("idCuota"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("cuotaPagada"), fuentePequena));
            }

            documento.add(tabla);
            documento.close();

        } catch (SQLException e) {
            System.out.println("SQL Error during report generation: " + e.getMessage());
        } catch (FileNotFoundException e) {
           System.out.println("SQL Error during report generation: " + e.getMessage());
        } catch (DocumentException e) {
            System.out.println("SQL Error during report generation: " + e.getMessage());
        } 
    }
    
    /**
     * Método secundario de la clase encargado de centrar y cambiar
     * la fuente de las celdas de la tabla generada.
     */
    private PdfPCell crearCeldaCentrada(String texto, Font fuente) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPadding(5);
        return celda;
    }
    
}
