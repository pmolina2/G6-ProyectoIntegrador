package MODELO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import oracle.jdbc.OracleTypes;

public class ReporteVentasPorProyectoBd extends ConexionBd {
    
    /**
     * Método principal del programa encargado de la generación del reporte de las ventas de un proyecto especifico
     * pasandole como parámetro al método el nombre del proyecto
     * Se usa la libreria de Itext para la generación del documento enrutado automaticamente en el escritorio
     * del equipo que ejecute el programa
     */
    public String reporteVentasPorProyecto(String nombreProyecto) {

        Connection conexion = null;
        ResultSet resultset = null;
        Document documento = null;
        String mensaje;

        try {
            // Conexión a la base de datos
            conexion = this.getConnection("adming6", "admin");

            // Bloque PL/SQL para obtener ventas según el nombre del proyecto
            String bloquePLSQL = """
                DECLARE
                    v_idProyecto proyectoIntegradorg6.proyecto.id%TYPE;
                BEGIN
                    
                    SELECT id INTO v_idProyecto
                    FROM proyectoIntegradorg6.proyecto
                    WHERE UPPER(nombre) = UPPER(?);

                    
                    OPEN ? FOR
                        SELECT v.*
                        FROM proyectointegradorg6.proyecto p 
                        JOIN proyectointegradorg6.torre t on p.id = t.idProyecto
                        JOIN proyectointegradorg6.apartamento ap ON t.id = ap.idtorre
                        JOIN proyectointegradorg6.venta v ON ap.matricula = v.matriculaapto
                        WHERE p.id = v_idProyecto;
                END;
            """;
            
            CallableStatement statement = conexion.prepareCall(bloquePLSQL);
            statement.setString(1, nombreProyecto);
            statement.registerOutParameter(2, OracleTypes.CURSOR); // Para obtener el resultado de la segunda consulta
            statement.execute();

            // Recuperar los resultados de la segunda consulta
            resultset = (ResultSet) statement.getObject(2);
            
            if (!resultset.isBeforeFirst()) {
                mensaje = "Error: No se ha realizado ninguna venta en este proyecto.";
                return mensaje;
            }

            // Crear el documento PDF
            documento = new Document();
            String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Ventas_Proyecto.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Añadir título al PDF
            Paragraph title = new Paragraph("REPORTE DE VENTAS DEL PROYECTO " + nombreProyecto.toUpperCase());
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(40);
            documento.add(title);

            // Crear tabla con encabezados
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

            // Agregar datos del resultset a la tabla
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
            // Cerrar conexiones y liberar recursos
            try {
                if (resultset != null) resultset.close();
                if (conexion != null) conexion.close();
                if (documento != null && documento.isOpen()) documento.close();
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

    
