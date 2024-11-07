
package Vista;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;


public class VentanaCuotaCliente extends javax.swing.JFrame {

   
    public VentanaCuotaCliente() {
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        
        initComponents();
        
        FondoPanel fondo = new FondoPanel();
        fondo.setLayout(new BorderLayout());
    
        // Agregar el panel principal al panel de fondo
        fondo.add(PanelPrincipalCC);  
        this.setContentPane(fondo);
    
        // Hacer el panel principal transparente
        PanelPrincipalCC.setOpaque(false);
        

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelPrincipalCC = new javax.swing.JPanel();
        PanelCuotaCliente = new javax.swing.JPanel();
        EncabezadoCuota = new javax.swing.JPanel();
        LabelNomCliente = new javax.swing.JLabel();
        LabelCedCliente = new javax.swing.JLabel();
        LabelValorCuota = new javax.swing.JLabel();
        LabelEstadoCuota = new javax.swing.JLabel();
        LabelFechaPago = new javax.swing.JLabel();
        LabelNumeroCuota = new javax.swing.JLabel();
        BotonPagarCuota = new javax.swing.JButton();
        LabelTituloCC = new javax.swing.JLabel();
        BotonRegresarCC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Información de Cuota");
        setResizable(false);

        PanelPrincipalCC.setBackground(new java.awt.Color(255, 255, 255));

        PanelCuotaCliente.setBackground(new java.awt.Color(153, 0, 0));
        PanelCuotaCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        EncabezadoCuota.setBackground(new java.awt.Color(51, 51, 51));

        LabelNomCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelNomCliente.setForeground(new java.awt.Color(255, 255, 255));
        LabelNomCliente.setText("Pierre Angelo Molina Motta");

        LabelCedCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelCedCliente.setForeground(new java.awt.Color(255, 255, 255));
        LabelCedCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelCedCliente.setText("CC. 1097493167");

        javax.swing.GroupLayout EncabezadoCuotaLayout = new javax.swing.GroupLayout(EncabezadoCuota);
        EncabezadoCuota.setLayout(EncabezadoCuotaLayout);
        EncabezadoCuotaLayout.setHorizontalGroup(
            EncabezadoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoCuotaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LabelNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelCedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        EncabezadoCuotaLayout.setVerticalGroup(
            EncabezadoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoCuotaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(EncabezadoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        LabelValorCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 60)); // NOI18N
        LabelValorCuota.setForeground(new java.awt.Color(255, 255, 255));
        LabelValorCuota.setText("$10.800.000");

        LabelEstadoCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelEstadoCuota.setForeground(new java.awt.Color(255, 255, 255));
        LabelEstadoCuota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelEstadoCuota.setText("ESTADO: VENCIDA");

        LabelFechaPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        LabelFechaPago.setForeground(new java.awt.Color(255, 255, 255));
        LabelFechaPago.setText("Fecha: 03/09/2024");

        LabelNumeroCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        LabelNumeroCuota.setForeground(new java.awt.Color(255, 255, 255));
        LabelNumeroCuota.setText("Cuota: 24/60");

        javax.swing.GroupLayout PanelCuotaClienteLayout = new javax.swing.GroupLayout(PanelCuotaCliente);
        PanelCuotaCliente.setLayout(PanelCuotaClienteLayout);
        PanelCuotaClienteLayout.setHorizontalGroup(
            PanelCuotaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EncabezadoCuota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelCuotaClienteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelCuotaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCuotaClienteLayout.createSequentialGroup()
                        .addComponent(LabelValorCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(LabelEstadoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCuotaClienteLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelCuotaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNumeroCuota)
                            .addComponent(LabelFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        PanelCuotaClienteLayout.setVerticalGroup(
            PanelCuotaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuotaClienteLayout.createSequentialGroup()
                .addComponent(EncabezadoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelCuotaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCuotaClienteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(LabelValorCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCuotaClienteLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(LabelEstadoCuota)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNumeroCuota)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        BotonPagarCuota.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagarCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonPagarCuota.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagarCuota.setText("REGISTRAR PAGO");
        BotonPagarCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BotonPagarCuota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPagarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPagarCuotaActionPerformed(evt);
            }
        });

        LabelTituloCC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 60)); // NOI18N
        LabelTituloCC.setText("INFORMACIÓN DE LA CUOTA");

        BotonRegresarCC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        BotonRegresarCC.setText("← Regresar");
        BotonRegresarCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        BotonRegresarCC.setContentAreaFilled(false);
        BotonRegresarCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresarCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalCCLayout = new javax.swing.GroupLayout(PanelPrincipalCC);
        PanelPrincipalCC.setLayout(PanelPrincipalCCLayout);
        PanelPrincipalCCLayout.setHorizontalGroup(
            PanelPrincipalCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalCCLayout.createSequentialGroup()
                .addGroup(PanelPrincipalCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalCCLayout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(PanelCuotaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalCCLayout.createSequentialGroup()
                        .addGap(629, 629, 629)
                        .addComponent(BotonPagarCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalCCLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(LabelTituloCC, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalCCLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(BotonRegresarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(352, Short.MAX_VALUE))
        );
        PanelPrincipalCCLayout.setVerticalGroup(
            PanelPrincipalCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalCCLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelTituloCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(PanelCuotaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(BotonPagarCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BotonRegresarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void BotonPagarCuotaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        VentanaPagoCuota PagoCuota = new VentanaPagoCuota();
        this.dispose();
        PagoCuota.setVisible(true);
    }                                               

    private void BotonRegresarCCActionPerformed(java.awt.event.ActionEvent evt) {                                                
       VentanaCuotas VentanaCuotas = new VentanaCuotas();
       this.dispose();
       VentanaCuotas.setVisible(true);

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
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCuotaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonPagarCuota;
    private javax.swing.JButton BotonRegresarCC;
    private javax.swing.JPanel EncabezadoCuota;
    private javax.swing.JLabel LabelCedCliente;
    private javax.swing.JLabel LabelEstadoCuota;
    private javax.swing.JLabel LabelFechaPago;
    private javax.swing.JLabel LabelNomCliente;
    private javax.swing.JLabel LabelNumeroCuota;
    private javax.swing.JLabel LabelTituloCC;
    private javax.swing.JLabel LabelValorCuota;
    private javax.swing.JPanel PanelCuotaCliente;
    private javax.swing.JPanel PanelPrincipalCC;
    // End of variables declaration                   
}
