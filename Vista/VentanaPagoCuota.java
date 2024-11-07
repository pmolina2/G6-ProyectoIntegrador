
package Vista;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;


public class VentanaPagoCuota extends javax.swing.JFrame {

  
    public VentanaPagoCuota() {  
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        FondoPanel fondo = new FondoPanel();
        fondo.setLayout(new BorderLayout());
    
        // Agregar el panel principal al panel de fondo
        fondo.add(PanelPrincipalPC);  
        
        this.setContentPane(fondo);
    
        // Hacer el panel principal transparente
        PanelPrincipalPC.setOpaque(false);
        addFieldListeners();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelPrincipalPC = new javax.swing.JPanel();
        PanelPagoCuota = new javax.swing.JPanel();
        LabelRegistrarPago = new javax.swing.JLabel();
        CampoValorPago = new javax.swing.JTextField();
        CampoNoTransferencia = new javax.swing.JTextField();
        CampoFechaPago = new javax.swing.JTextField();
        LabelNoTransferencia = new javax.swing.JLabel();
        LabelValorPago = new javax.swing.JLabel();
        LabelMetodoPago = new javax.swing.JLabel();
        LabelFechaPago = new javax.swing.JLabel();
        MetodoPagoComboBox = new javax.swing.JComboBox<>();
        BotonConfirmarPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Registrar Pago");
        setResizable(false);

        PanelPrincipalPC.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalPC.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelPagoCuota.setBackground(new java.awt.Color(255, 255, 255));
        PanelPagoCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        LabelRegistrarPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); // NOI18N
        LabelRegistrarPago.setText("REGISTRAR PAGO");

        CampoValorPago.setBackground(new java.awt.Color(245, 245, 245));
        CampoValorPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 19)); // NOI18N
        CampoValorPago.setForeground(new java.awt.Color(102, 102, 102));
        CampoValorPago.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoNoTransferencia.setBackground(new java.awt.Color(245, 245, 245));
        CampoNoTransferencia.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 19)); // NOI18N
        CampoNoTransferencia.setForeground(new java.awt.Color(102, 102, 102));
        CampoNoTransferencia.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoNoTransferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        CampoFechaPago.setBackground(new java.awt.Color(255, 255, 255));
        CampoFechaPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 19)); // NOI18N
        CampoFechaPago.setForeground(new java.awt.Color(102, 102, 102));
        CampoFechaPago.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoFechaPago.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        LabelNoTransferencia.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        LabelNoTransferencia.setText("No. de Transferencia *");

        LabelValorPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        LabelValorPago.setText("Valor del Pago *");

        LabelMetodoPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        LabelMetodoPago.setText("Método de Pago *");

        LabelFechaPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        LabelFechaPago.setText("Fecha de Pago *");

        MetodoPagoComboBox.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 19)); // NOI18N
        MetodoPagoComboBox.setForeground(new java.awt.Color(102, 102, 102));
        MetodoPagoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Transferencia Bancaria", "PSE", "Cheque" }));

        BotonConfirmarPago.setBackground(new java.awt.Color(0, 51, 102));
        BotonConfirmarPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonConfirmarPago.setForeground(new java.awt.Color(255, 255, 255));
        BotonConfirmarPago.setText("CONFIRMAR PAGO");
        BotonConfirmarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonConfirmarPago.setEnabled(false);

        javax.swing.GroupLayout PanelPagoCuotaLayout = new javax.swing.GroupLayout(PanelPagoCuota);
        PanelPagoCuota.setLayout(PanelPagoCuotaLayout);
        PanelPagoCuotaLayout.setHorizontalGroup(
            PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPagoCuotaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonConfirmarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410))
            .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelValorPago)
                            .addComponent(LabelMetodoPago)
                            .addComponent(MetodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelFechaPago)
                            .addComponent(CampoFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoNoTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelNoTransferencia)))
                    .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(LabelRegistrarPago)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        PanelPagoCuotaLayout.setVerticalGroup(
            PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(LabelRegistrarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelValorPago)
                    .addComponent(LabelNoTransferencia))
                .addGap(7, 7, 7)
                .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoNoTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMetodoPago)
                    .addComponent(LabelFechaPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MetodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(BotonConfirmarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout PanelPrincipalPCLayout = new javax.swing.GroupLayout(PanelPrincipalPC);
        PanelPrincipalPC.setLayout(PanelPrincipalPCLayout);
        PanelPrincipalPCLayout.setHorizontalGroup(
            PanelPrincipalPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalPCLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(PanelPagoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        PanelPrincipalPCLayout.setVerticalGroup(
            PanelPrincipalPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalPCLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(PanelPagoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    
      private void addFieldListeners() {
       
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPagoCuota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonConfirmarPago;
    private javax.swing.JTextField CampoFechaPago;
    private javax.swing.JTextField CampoNoTransferencia;
    private javax.swing.JTextField CampoValorPago;
    private javax.swing.JLabel LabelFechaPago;
    private javax.swing.JLabel LabelMetodoPago;
    private javax.swing.JLabel LabelNoTransferencia;
    private javax.swing.JLabel LabelRegistrarPago;
    private javax.swing.JLabel LabelValorPago;
    private javax.swing.JComboBox<String> MetodoPagoComboBox;
    private javax.swing.JPanel PanelPagoCuota;
    private javax.swing.JPanel PanelPrincipalPC;
    // End of variables declaration                   

  
}
