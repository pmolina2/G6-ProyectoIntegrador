package Vista;

import Dominio.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JOptionPane;
import CONTROLADOR.*;

public class VentanaPagoCuota extends javax.swing.JFrame {

    Cuota CuotaPago;

    public VentanaPagoCuota(Cuota CuotaActual) {
        this.CuotaPago = CuotaActual;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        FondoPanel fondo = new FondoPanel();
        fondo.setLayout(new BorderLayout());

        // Agregar el panel principal al panel de fondo
        fondo.add(PanelPrincipalPC);

        this.setContentPane(fondo);

        // Hacer el panel principal transparente
        PanelPrincipalPC.setOpaque(false);

        CampoFechaPago.getDocument().addDocumentListener(new FieldListener());
        CampoNoTransferencia.getDocument().addDocumentListener(new FieldListener());
        CampoValorPago.getDocument().addDocumentListener(new FieldListener());

        CampoValorPago.setText("$" + CuotaActual.getValor());
        CampoValorPago.setEditable(false);

    }

    private void revisarCampos() {
        boolean camposLlenos = !CampoFechaPago.getText().trim().isEmpty()
                && !CampoNoTransferencia.getText().trim().isEmpty() && !CampoValorPago.getText().trim().isEmpty()
                && !MetodoPagoComboBox.getSelectedItem().equals("Seleccionar");
        // Activa o desactiva el botón de registrar según el estado de los campos
        BotonConfirmarPago.setEnabled(camposLlenos);
        ActualizarAparienciaBoton();
    }

    private void ActualizarAparienciaBoton() {
        if (!BotonConfirmarPago.isEnabled()) {
            BotonConfirmarPago.setBackground(Color.GRAY); // Color de fondo gris
            BotonConfirmarPago.setForeground(new Color(100, 100, 100)); // Color de texto negro
        } else {
            BotonConfirmarPago.setBackground(new Color(0, 51, 102)); // Color de fondo orx|iginal
            BotonConfirmarPago.setForeground(Color.WHITE); // Color de texto original
        }
        BotonConfirmarPago.repaint();
    }

    private void BotonConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {
        if (!CampoFechaPago.getText().matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Error: La fecha ingresada debe estar en el fórmato dd/mm/yyyy",
                    "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } else if(MetodoPagoComboBox.getSelectedItem().toString().equals("Seleccionar")){
                JOptionPane.showMessageDialog(this, "Por favor seleccione un método de pago", "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else{
            RegistrarPago RegistroPago = new RegistrarPago();
            String mensaje = RegistroPago.registrarPago(CampoNoTransferencia.getText(),
                    MetodoPagoComboBox.getSelectedItem().toString(), CuotaPago.getValor(), CampoFechaPago.getText(),
                    CuotaPago.getCedulaCliente(), CuotaPago.getId(), CuotaPago.getNumeroCuota());
            if (mensaje.contains("Error")) {
                JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                ActualizarCuota ActualizarCuota = new ActualizarCuota();
                ActualizarCuota.actualizarCuota(CuotaPago.getId());
                VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
                this.dispose();
                VentanaAsesor.setVisible(true);
            }
        }
    }

    private class FieldListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            revisarCampos();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            revisarCampos();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            revisarCampos();
        }
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
        setTitle("SGPU - Registrar Pago");
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
        CampoValorPago.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)),
                javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoNoTransferencia.setBackground(new java.awt.Color(245, 245, 245));
        CampoNoTransferencia.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 19)); // NOI18N
        CampoNoTransferencia.setForeground(new java.awt.Color(102, 102, 102));
        CampoNoTransferencia.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)),
                javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoNoTransferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        CampoFechaPago.setBackground(new java.awt.Color(255, 255, 255));
        CampoFechaPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 19)); // NOI18N
        CampoFechaPago.setForeground(new java.awt.Color(102, 102, 102));
        CampoFechaPago.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)),
                javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
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
        MetodoPagoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Seleccionar", "Transferencia Bancaria", "PSE", "Cheque" }));

        BotonConfirmarPago.setBackground(new java.awt.Color(0, 51, 102));
        BotonConfirmarPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonConfirmarPago.setForeground(new java.awt.Color(255, 255, 255));
        BotonConfirmarPago.setText("CONFIRMAR PAGO");
        BotonConfirmarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonConfirmarPago.setEnabled(false);
        BotonConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPagoCuotaLayout = new javax.swing.GroupLayout(PanelPagoCuota);
        PanelPagoCuota.setLayout(PanelPagoCuotaLayout);
        PanelPagoCuotaLayout.setHorizontalGroup(
                PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                PanelPagoCuotaLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotonConfirmarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 193,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(410, 410, 410))
                        .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                                .addGroup(PanelPagoCuotaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                                                .addGap(218, 218, 218)
                                                .addGroup(PanelPagoCuotaLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(CampoValorPago,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 252,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LabelValorPago)
                                                        .addComponent(LabelMetodoPago)
                                                        .addComponent(MetodoPagoComboBox,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 252,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(91, 91, 91)
                                                .addGroup(PanelPagoCuotaLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LabelFechaPago)
                                                        .addComponent(CampoFechaPago,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 252,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(CampoNoTransferencia,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 252,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LabelNoTransferencia)))
                                        .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                                                .addGap(369, 369, 369)
                                                .addComponent(LabelRegistrarPago)))
                                .addContainerGap(213, Short.MAX_VALUE)));
        PanelPagoCuotaLayout.setVerticalGroup(
                PanelPagoCuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPagoCuotaLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(LabelRegistrarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addGroup(PanelPagoCuotaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelValorPago)
                                        .addComponent(LabelNoTransferencia))
                                .addGap(7, 7, 7)
                                .addGroup(PanelPagoCuotaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoNoTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(PanelPagoCuotaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelMetodoPago)
                                        .addComponent(LabelFechaPago))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelPagoCuotaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CampoFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MetodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73,
                                        Short.MAX_VALUE)
                                .addComponent(BotonConfirmarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)));

        javax.swing.GroupLayout PanelPrincipalPCLayout = new javax.swing.GroupLayout(PanelPrincipalPC);
        PanelPrincipalPC.setLayout(PanelPrincipalPCLayout);
        PanelPrincipalPCLayout.setHorizontalGroup(
                PanelPrincipalPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPrincipalPCLayout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(PanelPagoCuota, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(189, Short.MAX_VALUE)));
        PanelPrincipalPCLayout.setVerticalGroup(
                PanelPrincipalPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPrincipalPCLayout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(PanelPagoCuota, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(116, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelPrincipalPC, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelPrincipalPC, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
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
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPagoCuota.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
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