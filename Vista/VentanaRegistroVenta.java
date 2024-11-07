
package Vista;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JOptionPane;
import CONTROLADOR.*;
import Dominio.Apartamento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VentanaRegistroVenta extends javax.swing.JFrame {

    int TasaInteres;
    Apartamento ApartamentoVenta;

    public VentanaRegistroVenta(Apartamento AptoElegido) {
        initComponents();
        this.ApartamentoVenta = AptoElegido;
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage()
                .getScaledInstance(LabelImagen4.getWidth(), LabelImagen4.getHeight(), 0));
        LabelImagen4.setIcon(miIcono);
        ActualizarAparienciaBoton();

        // Método para obtener el número de la torre con el id del apartamento dado
        ConsultarNombreProyecto nombreProyecto = new ConsultarNombreProyecto();
        LabelProyecto2.setText("PROYECTO: " + nombreProyecto.devolverNombreProyecto(AptoElegido.getMatricula()).toUpperCase());
        ConsultarNumTorre numTorre = new ConsultarNumTorre();
        LabelTorre2.setText("TORRE: " + numTorre.devolverNumTorre(AptoElegido.getMatricula()));
        LabelApartamento.setText("APARTAMENTO: " + AptoElegido.getNumApto());
        CampoFechaEscritura.getDocument().addDocumentListener(new FieldListener());
        CampoCedulaCliente.getDocument().addDocumentListener(new FieldListener());
        CampoFechaEscritura.getDocument().addDocumentListener(new FieldListener());
        CampoCedulaCliente.setText(Sesion.getCedula());
        AsignarFechaActual();
    }

    private void revisarCampos() {
        boolean camposLlenos = !CampoFechaEscritura.getText().trim().isEmpty()
                && !CampoCedulaCliente.getText().trim().isEmpty() && !CampoFechaEscritura.getText().trim().isEmpty();
        // Activa o desactiva el botón de registrar según el estado de los campos
        BotonRegistrar.setEnabled(camposLlenos);
        ActualizarAparienciaBoton();
    }

     private void AsignarFechaActual() {
        
        // Se Obtiene la fecha actual
        LocalDate fechaHoy = LocalDate.now();
        
        // Se Formatea la fecha en el formato deseado (en este caso "dd/MM/yyyy")
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaHoy.format(formato);
        
        // Asignar la fecha formateada al JTextField
        CampoFechaEscritura.setText(fechaFormateada);
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

    private void ActualizarAparienciaBoton() {
        if (!BotonRegistrar.isEnabled()) {
            BotonRegistrar.setBackground(Color.GRAY); // Color de fondo gris
            BotonRegistrar.setForeground(new Color(100, 100, 100)); // Color de texto negro
        } else {
            BotonRegistrar.setBackground(new Color(0, 51, 102)); // Color de fondo original
            BotonRegistrar.setForeground(Color.WHITE); // Color de texto original
        }
        BotonRegistrar.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        PanelRegistroVenta = new javax.swing.JPanel();
        PanelLateralVenta = new javax.swing.JPanel();
        LabelImagen4 = new javax.swing.JLabel();
        LabelRegistroVenta = new javax.swing.JLabel();
        PanelInfoVenta = new javax.swing.JPanel();
        LabelTorre2 = new javax.swing.JLabel();
        LabelProyecto2 = new javax.swing.JLabel();
        LabelApartamento = new javax.swing.JLabel();
        CampoFechaEscritura = new javax.swing.JTextField();
        CampoCedulaCliente = new javax.swing.JTextField();
        LabelCedCliente = new javax.swing.JLabel();
        LabelFechaEscritura = new javax.swing.JLabel();
        LabelNomVendedor = new javax.swing.JLabel();
        LavelNumCuotas = new javax.swing.JLabel();
        LabelTasaInt = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JButton();
        NoCuotasComboBox = new javax.swing.JComboBox<>();
        CampoCedulaCliente1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Registro de Venta");
        setResizable(false);

        PanelRegistroVenta.setBackground(new java.awt.Color(255, 255, 255));
        PanelRegistroVenta.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelLateralVenta.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralVenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        javax.swing.GroupLayout PanelLateralVentaLayout = new javax.swing.GroupLayout(PanelLateralVenta);
        PanelLateralVenta.setLayout(PanelLateralVentaLayout);
        PanelLateralVentaLayout.setHorizontalGroup(
            PanelLateralVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralVentaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LabelImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelLateralVentaLayout.setVerticalGroup(
            PanelLateralVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralVentaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(419, Short.MAX_VALUE))
        );

        LabelRegistroVenta.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelRegistroVenta.setText("REGISTRAR UNA VENTA");

        PanelInfoVenta.setBackground(new java.awt.Color(240, 240, 240));
        PanelInfoVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        LabelTorre2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelTorre2.setForeground(new java.awt.Color(51, 51, 51));
        LabelTorre2.setText("Torre:  ");

        LabelProyecto2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelProyecto2.setForeground(new java.awt.Color(51, 51, 51));
        LabelProyecto2.setText("Proyecto:");

        LabelApartamento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelApartamento.setForeground(new java.awt.Color(51, 51, 51));
        LabelApartamento.setText("Apartamento:");

        javax.swing.GroupLayout PanelInfoVentaLayout = new javax.swing.GroupLayout(PanelInfoVenta);
        PanelInfoVenta.setLayout(PanelInfoVentaLayout);
        PanelInfoVentaLayout.setHorizontalGroup(
            PanelInfoVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoVentaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelInfoVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelTorre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelProyecto2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(LabelApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        PanelInfoVentaLayout.setVerticalGroup(
            PanelInfoVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoVentaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelProyecto2)
                .addGap(12, 12, 12)
                .addComponent(LabelTorre2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelApartamento)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        CampoFechaEscritura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        CampoFechaEscritura.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoFechaEscritura.setEnabled(false);

        CampoCedulaCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        CampoCedulaCliente.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoCedulaCliente.setEnabled(false);
        

        LabelCedCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        LabelCedCliente.setForeground(new java.awt.Color(51, 51, 51));
        LabelCedCliente.setText("Cedula del Cliente*");

        LabelFechaEscritura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        LabelFechaEscritura.setForeground(new java.awt.Color(51, 51, 51));
        LabelFechaEscritura.setText("Fecha de Escritura*");

        LabelNomVendedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        LabelNomVendedor.setForeground(new java.awt.Color(51, 51, 51));
        LabelNomVendedor.setText("Cédula del Asesor*");

        LavelNumCuotas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        LavelNumCuotas.setForeground(new java.awt.Color(51, 51, 51));
        LavelNumCuotas.setText("Numero de Cuotas*");

        LabelTasaInt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        LabelTasaInt.setForeground(new java.awt.Color(51, 51, 51));
        LabelTasaInt.setText("Tasa de Interés:    ");
        LabelTasaInt.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        BotonRegistrar.setBackground(new java.awt.Color(0, 51, 102));
        BotonRegistrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistrar.setText("REGISTRAR");
        BotonRegistrar.setBorder(null);
        BotonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegistrar.setEnabled(false);
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });

        NoCuotasComboBox.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        NoCuotasComboBox.setForeground(new java.awt.Color(102, 102, 102));
        NoCuotasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "60", "120", "180" }));
        NoCuotasComboBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        NoCuotasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuotasComboBoxActionPerformed(evt);
            }
        });

        CampoCedulaCliente1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        CampoCedulaCliente1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        javax.swing.GroupLayout PanelRegistroVentaLayout = new javax.swing.GroupLayout(PanelRegistroVenta);
        PanelRegistroVenta.setLayout(PanelRegistroVentaLayout);
        PanelRegistroVentaLayout.setHorizontalGroup(
            PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroVentaLayout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroVentaLayout.createSequentialGroup()
                        .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroVentaLayout.createSequentialGroup()
                                .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelFechaEscritura)
                                    .addComponent(LabelCedCliente)
                                    .addComponent(LabelTasaInt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(136, 136, 136)
                                .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelRegistroVentaLayout.createSequentialGroup()
                                .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoFechaEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoCedulaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CampoCedulaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(LavelNumCuotas)
                                    .addComponent(LabelNomVendedor)
                                    .addComponent(NoCuotasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroVentaLayout.createSequentialGroup()
                        .addComponent(LabelRegistroVenta)
                        .addGap(352, 352, 352))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroVentaLayout.createSequentialGroup()
                        .addComponent(PanelInfoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308)))
                .addComponent(PanelLateralVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        PanelRegistroVentaLayout.setVerticalGroup(
            PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroVentaLayout.createSequentialGroup()
                .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroVentaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(PanelLateralVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroVentaLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LabelRegistroVenta)
                        .addGap(59, 59, 59)
                        .addComponent(PanelInfoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNomVendedor)
                            .addComponent(LabelCedCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoCedulaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFechaEscritura)
                            .addComponent(LavelNumCuotas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoCuotasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoFechaEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(PanelRegistroVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelTasaInt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistroVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistroVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (NoCuotasComboBox.getSelectedItem().equals("Seleccionar")) { // Verifica si no hay selección
            JOptionPane.showMessageDialog(this, "Por favor elija la cantidad de cuotas.", "Mensaje de Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            CrearVenta CrearVenta = new CrearVenta();
            String seleccionCuotas = (String) NoCuotasComboBox.getSelectedItem(); // Obtener el elemento seleccionado
                                                                                  // como String
            int numeroCuotas = Integer.parseInt(seleccionCuotas); // Convertir el String a int
            CrearVenta.GuardarVenta(CampoCedulaCliente1.getText(), Sesion.getCedula(), numeroCuotas, this.TasaInteres,
                    CampoFechaEscritura.getText(), ApartamentoVenta);
            JOptionPane.showMessageDialog(this, "¡Venta Exitosa!. \nSe ha creado la cuota de este cliente", "Mensaje de Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void NoCuotasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        String seleccion = (String) NoCuotasComboBox.getSelectedItem();
        if (seleccion.equals("1")) {
            LabelTasaInt.setText("Tasa de Interés: N/a");
            this.TasaInteres = 0;
        } else if (seleccion.equals("60")) {
            LabelTasaInt.setText("Tasa de Interés: 10%");
            this.TasaInteres = 10;

        } else if (seleccion.equals("120")) {
            LabelTasaInt.setText("Tasa de Interés: 15%");
            this.TasaInteres = 15;

        } else if (seleccion.equals("180")) {
            LabelTasaInt.setText("Tasa de Interés: 20%");
            this.TasaInteres = 20;

        } else {
            LabelTasaInt.setText("Tasa de Interés: ");
        }
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
            java.util.logging.Logger.getLogger(VentanaRegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JTextField CampoCedulaCliente1;
    private javax.swing.JTextField CampoFechaEscritura;
    private javax.swing.JTextField CampoCedulaCliente;
    private javax.swing.JLabel LabelApartamento;
    private javax.swing.JLabel LabelCedCliente;
    private javax.swing.JLabel LabelFechaEscritura;
    private javax.swing.JLabel LabelImagen4;
    private javax.swing.JLabel LabelNomVendedor;
    private javax.swing.JLabel LabelProyecto2;
    private javax.swing.JLabel LabelRegistroVenta;
    private javax.swing.JLabel LabelTasaInt;
    private javax.swing.JLabel LabelTorre2;
    private javax.swing.JLabel LavelNumCuotas;
    private javax.swing.JComboBox<String> NoCuotasComboBox;
    private javax.swing.JPanel PanelInfoVenta;
    private javax.swing.JPanel PanelLateralVenta;
    private javax.swing.JPanel PanelRegistroVenta;
    // End of variables declaration
}
