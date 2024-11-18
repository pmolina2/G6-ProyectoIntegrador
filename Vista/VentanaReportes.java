package Vista;
/*Esta ventana sirve para llamar a los métodos de las clases del paquete controlador, que sirven para generar los reportes, haciendo uso de otras clases del paquete modelo
que conectan con la base de datos y realizan consultas*/


//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador.
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import CONTROLADOR.*;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VentanaReportes extends javax.swing.JFrame {

//Metodo constructor de la clase
    public VentanaReportes() {
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage()); //Se establece el icono de la ventana
        initComponents(); //Se inicializan los componentes
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage().getScaledInstance(LabelImagenReportes.getWidth(), LabelImagenReportes.getHeight(), 0));
        LabelImagenReportes.setIcon(miIcono); //Se agrega una imagen al LabelImagenReporte
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">        


/* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/
    private void initComponents() {

        PanelPrincipalReporte = new javax.swing.JPanel();
        PanelReportes = new javax.swing.JPanel();
        LabelTituloReportes = new javax.swing.JLabel();
        BotonClientesRegistrados = new javax.swing.JButton();
        BotonVentasMensuales1 = new javax.swing.JButton();
        BotonVentasProyecto1 = new javax.swing.JButton();
        BotonVentasAsesor1 = new javax.swing.JButton();
        BotonPagosMensuales1 = new javax.swing.JButton();
        BotonPagosCliente1 = new javax.swing.JButton();
        PanelLateralReportes = new javax.swing.JPanel();
        LabelImagenReportes = new javax.swing.JLabel();
        BotonRegresarReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGBU - Reportes");
        setResizable(false);

        PanelPrincipalReporte.setBackground(new java.awt.Color(255, 255, 255));

        PanelReportes.setBackground(new java.awt.Color(240, 240, 240));
        PanelReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        LabelTituloReportes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); 
        LabelTituloReportes.setText("GENERACION DE REPORTES");
        LabelTituloReportes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));


      //Se crean todos los botones que desencadenan en el programa la acción de generar un reporte.

        BotonClientesRegistrados.setBackground(new java.awt.Color(0, 51, 102));
        BotonClientesRegistrados.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        BotonClientesRegistrados.setForeground(new java.awt.Color(255, 255, 255));
        BotonClientesRegistrados.setText("CLIENTES REGISTRADOS");
        BotonClientesRegistrados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonClientesRegistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesRegistradosActionPerformed(evt);
            }
        });

        BotonVentasMensuales1.setBackground(new java.awt.Color(0, 51, 102));
        BotonVentasMensuales1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonVentasMensuales1.setForeground(new java.awt.Color(255, 255, 255));
        BotonVentasMensuales1.setText("VENTAS MENSUALES");
        BotonVentasMensuales1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonVentasMensuales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentasMensuales1ActionPerformed(evt);
            }
        });

        BotonVentasProyecto1.setBackground(new java.awt.Color(0, 51, 102));
        BotonVentasProyecto1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonVentasProyecto1.setForeground(new java.awt.Color(255, 255, 255));
        BotonVentasProyecto1.setText("VENTAS POR PROYECTO");
        BotonVentasProyecto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonVentasProyecto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentasProyecto1ActionPerformed(evt);
            }
        });

        BotonVentasAsesor1.setBackground(new java.awt.Color(0, 51, 102));
        BotonVentasAsesor1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonVentasAsesor1.setForeground(new java.awt.Color(255, 255, 255));
        BotonVentasAsesor1.setText("VENTAS POR ASESOR");
        BotonVentasAsesor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonVentasAsesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentasAsesor1ActionPerformed(evt);
            }
        });

        BotonPagosMensuales1.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagosMensuales1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonPagosMensuales1.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagosMensuales1.setText("PAGOS MENSUALES");
        BotonPagosMensuales1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPagosMensuales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPagosMensuales1ActionPerformed(evt);
            }
        });

        BotonPagosCliente1.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagosCliente1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonPagosCliente1.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagosCliente1.setText("PAGOS POR CLIENTE");
        BotonPagosCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPagosCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    BotonPagosCliente1ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VentanaReportes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout PanelReportesLayout = new javax.swing.GroupLayout(PanelReportes);
        PanelReportes.setLayout(PanelReportesLayout);
        PanelReportesLayout.setHorizontalGroup(
            PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelReportesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReportesLayout.createSequentialGroup()
                        .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonVentasAsesor1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonVentasMensuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonPagosMensuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonVentasProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))
                    .addGroup(PanelReportesLayout.createSequentialGroup()
                        .addComponent(BotonPagosCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelReportesLayout.setVerticalGroup(
            PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(LabelTituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonVentasMensuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonVentasProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonVentasAsesor1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPagosMensuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonPagosCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelLateralReportes.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        BotonRegresarReportes.setBackground(new java.awt.Color(240, 240, 240));
        BotonRegresarReportes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonRegresarReportes.setText("← Regresar");
        BotonRegresarReportes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonRegresarReportes.setContentAreaFilled(false);
        BotonRegresarReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralReportesLayout = new javax.swing.GroupLayout(PanelLateralReportes);
        PanelLateralReportes.setLayout(PanelLateralReportesLayout);
        PanelLateralReportesLayout.setHorizontalGroup(
            PanelLateralReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLateralReportesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonRegresarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(PanelLateralReportesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LabelImagenReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelLateralReportesLayout.setVerticalGroup(
            PanelLateralReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralReportesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelImagenReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                .addComponent(BotonRegresarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout PanelPrincipalReporteLayout = new javax.swing.GroupLayout(PanelPrincipalReporte);
        PanelPrincipalReporte.setLayout(PanelPrincipalReporteLayout);
        PanelPrincipalReporteLayout.setHorizontalGroup(
            PanelPrincipalReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalReporteLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(PanelReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(PanelLateralReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        PanelPrincipalReporteLayout.setVerticalGroup(
            PanelPrincipalReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalReporteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelPrincipalReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelLateralReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      


//Al presionar el botón de regresar al inicio, se crea una nueva instancia de  VentanaInicioAdmin, se desecha la ventana actual y se hace visible la nueva ventana
    private void BotonRegresarReportesActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        VentanaInicioAdmin VentanaAdmin = new VentanaInicioAdmin();
        this.dispose();
        VentanaAdmin.setVisible(true);
    }                                                     


    private void BotonVentasMensuales1ActionPerformed(java.awt.event.ActionEvent evt) {     
         // Se crea una instancia de la clase ReporteVentasMes, que gestiona los reportes de ventas mensuales
        ReporteVentasMes reporteVentas = new ReporteVentasMes();
        try {
             // Se invoca el método ventasPorMes para generar el reporte de ventas por mes
            reporteVentas.ventasPorMes();
        } catch (FileNotFoundException | DocumentException ex) {
            // Se registra cualquier excepción que ocurra durante la generación del reporte
            Logger.getLogger(VentanaReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Se muestra un mensaje de confirmación al usuario indicando que el reporte fue generado exitosamente
        JOptionPane.showMessageDialog(this,"¡Reporte generado exitosamente!.\n Se ha descargado un archivo pdf en su escritorio","Mensaje de Confirmación",JOptionPane.INFORMATION_MESSAGE);
    }                                                     



    private void BotonVentasProyecto1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Se declara la variable nombreProyecto e inicializa como null
         String nombreProyecto = null;

        // Se inicia un ciclo para capturar el nombre del proyecto hasta que sea válido (no nulo ni vacío)
        while (nombreProyecto == null || nombreProyecto.trim().isEmpty()) {
        // Se solicita al usuario que ingrese el nombre del proyecto mediante un cuadro de diálogo
        nombreProyecto = JOptionPane.showInputDialog(null, 
            "Por favor, ingrese el nombre del proyecto", 
            "Captura de Datos", 
            JOptionPane.PLAIN_MESSAGE);
        
        // Si el nombre del proyecto está vacío o es nulo, se muestra un mensaje de advertencia
        if (nombreProyecto == null || nombreProyecto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Debe ingresar el nombre del proyecto para continuar.", 
                "Entrada obligatoria", 
                JOptionPane.WARNING_MESSAGE);
        }
    }   // Se crea una instancia de la clase ReporteVentasProyecto, que se encarga de generar el reporte
        ReporteVentasProyecto reporte = new ReporteVentasProyecto();
        String mensaje = null;
         // Se intenta generar el reporte para el proyecto ingresado, y el método devuelve un mensaje
        mensaje = reporte.reporteVentasProyecto(nombreProyecto);
        if (mensaje.contains("Error")){ // Si el mensaje contiene la palabra "Error", se muestra un mensaje de error al usuario
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }else{
            // Si no hay errores, se muestra el mensaje de confirmación al usuario
    JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Confirmación", JOptionPane.INFORMATION_MESSAGE);}
    }        


    private void BotonVentasAsesor1ActionPerformed(java.awt.event.ActionEvent evt) {   
        // Se declara la variable cedulaAsesor e inicializa como null
        String cedulaAsesor = null;

        // Se inicia un ciclo para capturar la cédula del asesor hasta que sea válida (no nula ni vacía)
        while (cedulaAsesor == null || cedulaAsesor.trim().isEmpty()) {
        // Se solicita al usuario que ingrese la cédula del asesor mediante un cuadro de diálogo
        cedulaAsesor = JOptionPane.showInputDialog(null, 
            "Por favor, ingrese la cédula del asesor", 
            "Captura de Datos", 
            JOptionPane.PLAIN_MESSAGE);

        // Si la cédula está vacía o es nula, se muestra un mensaje de advertencia
        if (cedulaAsesor == null || cedulaAsesor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Debe ingresar la cédula del asesor para continuar.", 
                "Entrada obligatoria", 
                JOptionPane.WARNING_MESSAGE);
        }
    }   // Se crea una instancia de la clase ReporteVentasAsesor, que se encarga de generar el reporte
        ReporteVentasAsesor reporteAsesor = new ReporteVentasAsesor();
        String mensaje = null;

        // Se intenta generar el reporte para el proyecto ingresado, y el método devuelve un mensaje
        mensaje = reporteAsesor.reporteVentasAsesor(cedulaAsesor);
        if (mensaje.contains("Error")){ // Si el mensaje contiene la palabra "Error", se muestra un mensaje de error al usuario
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }else{
            // Si no hay errores, se muestra el mensaje de confirmación al usuario
    JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Confirmación", JOptionPane.INFORMATION_MESSAGE);}

    }                                                  

    private void BotonPagosMensuales1ActionPerformed(java.awt.event.ActionEvent evt) {  
        // Se crea una instancia de la clase ReportePagosMes, que se encarga de generar el reporte de pagos mensuales
            ReportePagosMes reportePagos = new ReportePagosMes();
            // Se genera el reporte de pagos mensuales
            reportePagos.reportePagosMes();
            // Se muestra un mensaje de confirmación al usuario indicando que el reporte fue generado exitosamente
            JOptionPane.showMessageDialog(this,"¡Reporte generado exitosamente!.\n Se ha descargado un archivo pdf en su escritorio","Mensaje de Confirmación",JOptionPane.INFORMATION_MESSAGE);                             
    }                                                    


    private void BotonPagosCliente1ActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException { 
    // Se declara la variable cedulaCliente e inicializa como null                                                  
    String cedulaCliente = null;

    // Se inicia un ciclo para capturar la cédula del cliente hasta que sea válida (no nula ni vacía)
    while (cedulaCliente == null || cedulaCliente.trim().isEmpty()) {
        // Se solicita al usuario que ingrese la cédula del cliente mediante un cuadro de diálogo
        cedulaCliente = JOptionPane.showInputDialog(null, 
            "Por favor, ingrese la cédula del cliente", 
            "Captura de Datos", 
            JOptionPane.PLAIN_MESSAGE);
        
         // Si la cédula está vacía o es nula, se muestra un mensaje de advertencia
        if (cedulaCliente == null || cedulaCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Debe ingresar la cédula del cliente para continuar.", 
                "Entrada obligatoria", 
                JOptionPane.WARNING_MESSAGE);
        }
    }

    // Se crea una instancia de la clase ReportePagosCedula, que se encarga de procesar los pagos según la cédula del cliente
    ReportePagosCedula consultapago = new ReportePagosCedula();
    String mensaje = null;
        try {
            // Se obtiene el mensaje relacionado con los pagos del cliente, usando la cédula como parámetro
            mensaje = consultapago.devolverPagos(cedulaCliente);
        } catch (DocumentException ex) {
            // Si ocurre un error durante el procesamiento del reporte, se registra el error
            Logger.getLogger(VentanaReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Si el mensaje contiene la palabra "Error", se muestra un mensaje de error
        if (mensaje.contains("Error")){
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }else{
            // Si no hay errores, se muestra un mensaje de confirmación
    JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Confirmación", JOptionPane.INFORMATION_MESSAGE);}
}
     

    private void BotonClientesRegistradosActionPerformed(java.awt.event.ActionEvent evt) {
        // Se crea una instancia de la clase ReporteClientesRegistrados, que se encarga de generar el reporte de clientes registrados
        ReporteClientesRegistrados reporte = new ReporteClientesRegistrados();
        // Se genera el reporte de clientes registrados
        reporte.reporteClientes();
        // Se muestra un mensaje de confirmación al usuario indicando que el reporte fue generado exitosamente
        JOptionPane.showMessageDialog(this,"¡Reporte generado exitosamente!.\n Se ha descargado un archivo pdf en su escritorio","Mensaje de Confirmación",JOptionPane.INFORMATION_MESSAGE);                             
}                                                  



    /**
     * @param args the command line arguments
     */
//Metodo main definido por defecto por Netbeans
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReportes().setVisible(true);
            }
        });
    }

    // Declaracion de Variables                
    private javax.swing.JButton BotonPagosCliente1;
    private javax.swing.JButton BotonPagosMensuales1;
    private javax.swing.JButton BotonClientesRegistrados;
    private javax.swing.JButton BotonRegresarReportes;
    private javax.swing.JButton BotonVentasAsesor1;
    private javax.swing.JButton BotonVentasMensuales1;
    private javax.swing.JButton BotonVentasProyecto1;
    private javax.swing.JLabel LabelImagenReportes;
    private javax.swing.JLabel LabelTituloReportes;
    private javax.swing.JPanel PanelLateralReportes;
    private javax.swing.JPanel PanelPrincipalReporte;
    private javax.swing.JPanel PanelReportes;
    //Fin de declaracion de variables
}