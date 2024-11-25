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

public class ReporteVentasMesBd extends ConexionBd {

    /**
     * Método principal del programa encargado de la generación del reporte de las ventas hechas en el mes actual
     * Se usa la libreria de Itext para la generación del documento enrutado automaticamente en el escritorio
     * del equipo que ejecute el programa
     */
    public void reporteVentasMes() throws FileNotFoundException, DocumentException {

        Connection conexion = null;
        ResultSet resultset = null;
        Document documento = null;
        CallableStatement callableStatement = null;
        int numVentas = 0;
        int dineroVentas = 0;

        try {
            conexion = this.getConnection("adming6", "admin");

            // Ejecutar la función numero_ventas_realizadas
            callableStatement = conexion.prepareCall("{ ? = call proyectointegradorg6.numero_ventas_realizadas() }");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            numVentas = callableStatement.getInt(1);

            // Ejecutar la función dinero_ventas_realizadas
            callableStatement = conexion.prepareCall("{ ? = call proyectointegradorg6.dinero_ventas_realizadas() }");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            dineroVentas = callableStatement.getInt(1);

            String sentencia = """
            SELECT *
            FROM proyectoIntegradorg6.venta
            WHERE TO_CHAR(fechaEscritura, 'MM') = TO_CHAR(SYSDATE, 'MM')
            """;
            
            Statement statement = conexion.createStatement();
            resultset = statement.executeQuery(sentencia);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
            String nombreMes = sdf.format(new Date());

            // generación y enrutamiento del documento
            documento = new Document();
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas_Mes.pdf"));
            documento.open();

            // generación del titulo de la página
            Paragraph title = new Paragraph("REPORTE DE VENTAS DEL MES DE " + nombreMes.toUpperCase());
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(40);
            documento.add(title);

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
            Font fuenteMediana= FontFactory.getFont(FontFactory.HELVETICA, 9);
            Paragraph textoFinal = new Paragraph("Número de ventas realizadas: " + numVentas + "\n"
                    + "Dinero total recaudado por ventas: $" + dineroVentas, fuenteMediana);
            textoFinal.setSpacingBefore(20);
            textoFinal.setAlignment(Element.ALIGN_CENTER);
            documento.add(textoFinal);

            documento.close();

        } catch (SQLException e) {
            System.out.println("SQL Error during report generation: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File error during report generation: " + e.getMessage());
        } catch (DocumentException e) {
            System.out.println("Document error during report generation: " + e.getMessage());
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
