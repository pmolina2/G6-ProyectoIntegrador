package MODELO;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;



public class ReporteClientesRegistradosBd extends ConexionBd{
    
    /**
     * 
     * Método principal de la clase. Se encarga de la generación del reporte en formato PDF
     * para los clientes registrados en la base de datos. Se utiliza la libreria Itext para lograrlo.
     * La conexión a la base de datos se realiza con el usuario adming6 y contraseña admin pues el administrador
     * es el único usuario con acceso a la gestión de reportes. El documento se almacena en el escritorio
     * del equipo automaticamente con el nombre creado en la ruta
     * 
     */
    public void reporteClientesBd(){
       Connection conexion = null;
        ResultSet resultset = null;
        Document documento = null;

        

        try {
            conexion = this.getConnection("adming6", "admin");

            String sentencia = """
            SELECT *
            FROM proyectoIntegradorg6.cliente
            """;
            
            Statement statement = conexion.createStatement();
            resultset = statement.executeQuery(sentencia);

            documento = new Document();
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            documento.open();

            Paragraph title = new Paragraph("REPORTE DE CLIENTES REGISTRADOS");
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(40); 
            documento.add(title);

            PdfPTable tabla = new PdfPTable(7);
            Font fuentePequena = FontFactory.getFont(FontFactory.HELVETICA, 7.5f);

            tabla.addCell(crearCeldaCentrada("Cedula", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Nombre", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Sisben", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Subsidio", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Direccion", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Telefono", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Correo electronico", fuentePequena));

            while (resultset.next()) {
                tabla.addCell(crearCeldaCentrada(resultset.getString("cedula"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("nombrecompleto"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("sisben"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("subsidio"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("direccion"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("telefono"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("correoelectronico"), fuentePequena));
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
     * Método secundario de la clase encargado de centrar y adapatar
     * la fuente del contenido de las celdas de la tabla generada en el documento
     */
    private PdfPCell crearCeldaCentrada(String texto, Font fuente) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPadding(5);
        return celda;
    }
    
}
