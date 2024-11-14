/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class VentanaReportes extends javax.swing.JFrame {

    public VentanaReportes() {
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        initComponents();
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage().getScaledInstance(LabelImagenReportes.getWidth(), LabelImagenReportes.getHeight(), 0));
        LabelImagenReportes.setIcon(miIcono);
    }

    
    @SuppressWarnings("unchecked")                     
    private void initComponents() {

        PanelPrincipalReporte = new javax.swing.JPanel();
        PanelReportes = new javax.swing.JPanel();
        LabelTituloReportes = new javax.swing.JLabel();
        BotonPagosProyecto = new javax.swing.JButton();
        BotonVentasMensuales1 = new javax.swing.JButton();
        BotonVentasProyecto1 = new javax.swing.JButton();
        BotonVentasAsesor1 = new javax.swing.JButton();
        BotonPagosMensuales1 = new javax.swing.JButton();
        BotonPagosCliente1 = new javax.swing.JButton();
        PanelLateralReportes = new javax.swing.JPanel();
        LabelImagenReportes = new javax.swing.JLabel();
        BotonRegresarReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Generar Reportes");
        setResizable(false);

        PanelPrincipalReporte.setBackground(new java.awt.Color(255, 255, 255));

        PanelReportes.setBackground(new java.awt.Color(240, 240, 240));
        PanelReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        LabelTituloReportes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); // NOI18N
        LabelTituloReportes.setText("GENERACION DE REPORTES");
        LabelTituloReportes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        BotonPagosProyecto.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagosProyecto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonPagosProyecto.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagosProyecto.setText("PAGOS POR PROYECTO");
        BotonPagosProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonVentasMensuales1.setBackground(new java.awt.Color(0, 51, 102));
        BotonVentasMensuales1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonVentasMensuales1.setForeground(new java.awt.Color(255, 255, 255));
        BotonVentasMensuales1.setText("VENTAS MENSUALES");
        BotonVentasMensuales1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonVentasProyecto1.setBackground(new java.awt.Color(0, 51, 102));
        BotonVentasProyecto1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonVentasProyecto1.setForeground(new java.awt.Color(255, 255, 255));
        BotonVentasProyecto1.setText("VENTAS POR PROYECTO");
        BotonVentasProyecto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonVentasAsesor1.setBackground(new java.awt.Color(0, 51, 102));
        BotonVentasAsesor1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonVentasAsesor1.setForeground(new java.awt.Color(255, 255, 255));
        BotonVentasAsesor1.setText("VENTAS POR ASESOR");
        BotonVentasAsesor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonPagosMensuales1.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagosMensuales1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonPagosMensuales1.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagosMensuales1.setText("PAGOS MENSUALES");
        BotonPagosMensuales1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonPagosCliente1.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagosCliente1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonPagosCliente1.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagosCliente1.setText("PAGOS POR CLIENTE");
        BotonPagosCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                            .addComponent(BotonPagosProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(BotonPagosProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void BotonRegresarReportesActionPerformed(java.awt.event.ActionEvent evt) {                                                      

        VentanaInicioAdmin VentanaAdmin = new VentanaInicioAdmin();
        this.dispose();
        VentanaAdmin.setVisible(true);

    }                                                     

  
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

             
    private javax.swing.JButton BotonPagosCliente1;
    private javax.swing.JButton BotonPagosMensuales1;
    private javax.swing.JButton BotonPagosProyecto;
    private javax.swing.JButton BotonRegresarReportes;
    private javax.swing.JButton BotonVentasAsesor1;
    private javax.swing.JButton BotonVentasMensuales1;
    private javax.swing.JButton BotonVentasProyecto1;
    private javax.swing.JLabel LabelImagenReportes;
    private javax.swing.JLabel LabelTituloReportes;
    private javax.swing.JPanel PanelLateralReportes;
    private javax.swing.JPanel PanelPrincipalReporte;
    private javax.swing.JPanel PanelReportes;

}
