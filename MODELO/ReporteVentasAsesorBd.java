package MODELO;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

public class ReporteVentasAsesorBd extends ConexionBd {

    /**
     * Método principal del programa encargado de la generación del reporte de las ventas realizadas por un asesor específico,
     * pasandole como parámetro al método la cédula del asesor
     * Se usa la libreria de Itext para la generación del documento enrutado automaticamente en el escritorio
     * del equipo que ejecute el programa
     */
    public String reporteVentasAsesor(String cedulaAsesor) throws FileNotFoundException, DocumentException {

        Connection conexion = null;
        ResultSet resultset = null;
        Document documento = null;
        String mensaje;
        String nombreAsesor = null;


        try {
            conexion = this.getConnection("adming6", "admin");

            // Llamar a la función para obtener el nombre del asesor
            CallableStatement callableStatement = conexion.prepareCall("{ ? = call proyectointegradorg6.nombre_asesor_cedula(?) }");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2, cedulaAsesor);
            callableStatement.execute();
            nombreAsesor = callableStatement.getString(1);

            String sentencia = """
            SELECT *
            FROM proyectoIntegradorg6.venta
            WHERE cedulaasesor = ?
            """;
            
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, cedulaAsesor);
            resultset = statement.executeQuery();

            if (!resultset.isBeforeFirst()) {
                mensaje = "Error: El asesor con la cédula ingresada no ha realizado ninguna venta.";
                return mensaje;
            }

            // generación y enrutamiento del documento
            documento = new Document();
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas_Asesor.pdf"));
            documento.open();

            // agregarle un titulo a la página
            Paragraph title = new Paragraph("REPORTE DE VENTAS DEL ASESOR ");
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(15);
            documento.add(title);

            Font fuenteasesor = FontFactory.getFont(FontFactory.HELVETICA, 9);
            Paragraph parrafoAsesor = new Paragraph("ASESOR: " + nombreAsesor.toUpperCase(), fuenteasesor);
            parrafoAsesor.setAlignment(Element.ALIGN_CENTER);
            parrafoAsesor.setSpacingAfter(30);
            documento.add(parrafoAsesor);

            // generación de la tabla con el número de columnas
            PdfPTable tabla = new PdfPTable(8);
            Font fuentePequena = FontFactory.getFont(FontFactory.HELVETICA, 7.5f); 

            tabla.addCell(crearCeldaCentrada("Id venta", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Precio Total de la venta", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Numero de cuotas", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Porcentaje de interés", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Cedula Asesor", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Matricula del apartamento", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Cedula del cliente", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Fecha de escritura", fuentePequena));

            while (resultset.next()) {
                tabla.addCell(crearCeldaCentrada(resultset.getString("id"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("PrecioTotalVenta"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("numCuotas"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("porcentajeinteres"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("cedulaasesor"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("matriculaapto"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getString("cedulaCliente"), fuentePequena));
                tabla.addCell(crearCeldaCentrada(resultset.getDate("fechaescritura").toString(), fuentePequena));
            }

            documento.add(tabla);

            documento.close();

            mensaje = "Reporte generado exitosamente! \nSe ha descargado un archivo pdf en su escritorio";
        } catch (SQLException e) {
            System.out.println("SQL Error during report generation: " + e.getMessage());
            mensaje = "Error en la creación del reporte";
        } catch (FileNotFoundException e) {
            System.out.println("File error during report generation: " + e.getMessage());
            mensaje = "Error en la creación del reporte";
        } catch (DocumentException e) {
            System.out.println("Document error during report generation: " + e.getMessage());
            mensaje = "Error en la creación del reporte";
        } finally {
            try {
                if (resultset != null) resultset.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return mensaje;
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
