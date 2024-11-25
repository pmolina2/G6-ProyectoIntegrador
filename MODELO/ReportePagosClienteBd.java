package MODELO;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

public class ReportePagosClienteBd extends ConexionBd {
    
    /**
     * 
     * Método principal de la clase encargado de generar los reportes para los pagos de un cliente especifico
     * pasándole como parámetro la cédula, se usa la biblioteca Itext para lograr la generación del documento enrutada automaticamente
     * al escritorio del equipo que ejecute el programa
     * 
     */
    public String consultarPagosCedula(String cedula) {
        String mensaje = ""; 
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        Document documento = null;

        try {
            conexion = this.getConnection("adming6", "admin");
            String sentencia = """
                SELECT *
                FROM proyectoIntegradorg6.pago
                WHERE cedulaCliente = ?
            """;

            statement = conexion.prepareStatement(sentencia);
            statement.setString(1, cedula);
            resultset = statement.executeQuery();

            // Verificar si el ResultSet está vacío
            if (!resultset.isBeforeFirst()) { 
                // No se encontraron pagos
                mensaje = "Error: No se encontraron pagos para este cliente.\nIntente nuevamente.";
                return mensaje;
            }

            // Si hay resultados, procede a generar el PDF
            documento = new Document();
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pagos_Cliente.pdf"));
            documento.open();

            // Crear título y definir espacio debajo
            Paragraph title = new Paragraph("REPORTE DE PAGOS DEL CLIENTE");
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(40); // Añade un espacio de 20 puntos después del título
            documento.add(title);

            PdfPTable tabla = new PdfPTable(7);
            Font fuentePequena = FontFactory.getFont(FontFactory.HELVETICA, 8);

            // Agregar encabezados con texto centrado
            tabla.addCell(crearCeldaCentrada("Transferencia", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Metodo Pago", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Valor Pago", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Fecha", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Cedula del cliente", fuentePequena));
            tabla.addCell(crearCeldaCentrada("id de la cuota", fuentePequena));
            tabla.addCell(crearCeldaCentrada("Cuota Pagada", fuentePequena));

            // Agregar datos con texto centrado
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
            mensaje = "¡Reporte generado exitosamente!.\n Se ha descargado un archivo pdf en su escritorio";

        } catch (SQLException e) {
            mensaje = "Error: " + e.getMessage();
        } catch (FileNotFoundException fe) {
            mensaje = "Error: " + fe.getMessage();
        } catch (DocumentException de) {
            mensaje = "Error: " + de.getMessage();
        } finally {
            try {
                if (resultset != null) resultset.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
                if (documento != null && documento.isOpen()) documento.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mensaje;
    }

    /**
     * Método secundario de la clase encargado de centrar y cambiar la fuente
     * del contenido generado en las celdas de la tabla
     */
    private PdfPCell crearCeldaCentrada(String texto, Font fuente) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return celda;
    }
}
