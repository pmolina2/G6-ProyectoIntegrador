
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

    private int TasaInteres;
    private Apartamento ApartamentoVenta;

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
        LabelTorre2.setText("TORRE: " + numTorre.devolverNumTorre(AptoElegido.getMatricula()).toUpperCase());
        LabelApartamento.setText("APARTAMENTO: " + AptoElegido.getNumApto());
        CampoFechaEscritura.getDocument().addDocumentListener(new FieldListener());
        CampoCedulaCliente1.getDocument().addDocumentListener(new FieldListener());
        CampoFechaEscritura.getDocument().addDocumentListener(new FieldListener());
        CampoCedulaAsesor.setText(Sesion.getCedula());
        AsignarFechaActual();
    }

    private void revisarCampos() {
        boolean camposLlenos = !CampoFechaEscritura.getText().trim().isEmpty()
                && !CampoCedulaCliente1.getText().trim().isEmpty() && !CampoFechaEscritura.getText().trim().isEmpty();
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
        Nota1 = new javax.swing.JLabel();
        Nota2 = new javax.swing.JLabel();
        Nota3 = new javax.swing.JLabel();
        BotonRegresoInicio = new javax.swing.JButton();
        LabelRegistroVenta = new javax.swing.JLabel();
        PanelInfoVenta = new javax.swing.JPanel();
        LabelTorre2 = new javax.swing.JLabel();
        LabelProyecto2 = new javax.swing.JLabel();
        LabelApartamento = new javax.swing.JLabel();
        CampoFechaEscritura = new javax.swing.JTextField();
        CampoCedulaAsesor = new javax.swing.JTextField();
        LabelCedCliente = new javax.swing.JLabel();
        LabelFechaEscritura = new javax.swing.JLabel();
        LabelNomVendedor = new javax.swing.JLabel();
        LavelNumCuotas = new javax.swing.JLabel();
        LabelTasaInt = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JButton();
        NoCuotasComboBox = new javax.swing.JComboBox<>();
        CampoCedulaCliente1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Registro de Venta");
        setResizable(false);

        PanelRegistroVenta.setBackground(new java.awt.Color(255, 255, 255));
        PanelRegistroVenta.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelLateralVenta.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralVenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        Nota1.setForeground(new java.awt.Color(153, 153, 153));
        Nota1.setText("Nota: El porcentaje de interés se aplica al valor ");

        Nota2.setForeground(new java.awt.Color(153, 153, 153));
        Nota2.setText("de cada cuota mensual, y no es un interés");

        Nota3.setForeground(new java.awt.Color(153, 153, 153));
        Nota3.setText("compuesto.");

        BotonRegresoInicio.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        BotonRegresoInicio.setText("← Regresar al Inicio");
        BotonRegresoInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        BotonRegresoInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresoInicio.setContentAreaFilled(false);
        BotonRegresoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresoInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralVentaLayout = new javax.swing.GroupLayout(PanelLateralVenta);
        PanelLateralVenta.setLayout(PanelLateralVentaLayout);
        PanelLateralVentaLayout.setHorizontalGroup(
            PanelLateralVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralVentaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LabelImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLateralVentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLateralVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLateralVentaLayout.createSequentialGroup()
                        .addGroup(PanelLateralVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nota1)
                            .addComponent(Nota3)
                            .addComponent(Nota2))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLateralVentaLayout.createSequentialGroup()
                        .addComponent(BotonRegresoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );
        PanelLateralVentaLayout.setVerticalGroup(
            PanelLateralVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralVentaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Nota1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nota2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nota3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(BotonRegresoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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


        CampoCedulaAsesor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        CampoCedulaAsesor.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoCedulaAsesor.setEnabled(false);


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
                .addContainerGap(246, Short.MAX_VALUE)
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
                                    .addComponent(CampoCedulaAsesor, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
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
                            .addComponent(CampoCedulaAsesor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelRegistroVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistroVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );

        pack();
    }



       private void BotonRegresoInicioActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
        this.dispose();
        VentanaAsesor.setVisible(true);
    }                                                  
   
    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (NoCuotasComboBox.getSelectedItem().equals("Seleccionar")) { // Verifica si no hay selección
            JOptionPane.showMessageDialog(this, "Por favor elija la cantidad de cuotas.", "Mensaje de advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } else if(CampoCedulaCliente1.getText().matches(".*[a-zA-Z].*")) {
         JOptionPane.showMessageDialog(this, "La cédula ingresada contiene letras, \nintente nuevamente", "Mensaje de Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            CrearVenta CrearVenta = new CrearVenta();
            String seleccionCuotas = (String) NoCuotasComboBox.getSelectedItem();                                    
            int numeroCuotas = Integer.parseInt(seleccionCuotas); 
            String mensaje = CrearVenta.GuardarVenta(CampoCedulaCliente1.getText(), Sesion.getCedula(), numeroCuotas, this.TasaInteres,
                    CampoFechaEscritura.getText(), ApartamentoVenta);
            if (mensaje.contains("Error")){
                 JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error",JOptionPane.ERROR_MESSAGE);}
            else{

                JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Confirmación",JOptionPane.INFORMATION_MESSAGE);
                ActualizarFecha ActualizarFecha = new ActualizarFecha();
                ActualizarFecha.actualizarFechaEscritura(ApartamentoVenta.getMatricula(),CampoFechaEscritura.getText());

                //Ahora se pasa el ValorApto que es una string a entero para poder calcular el valor de cada cuota mensual.
                String ValorApto = (String) ApartamentoVenta.getValorApto();                                    
                int ValorAptoNumero = Integer.parseInt(ValorApto); 

                //Se calcula el valor de la cuota. Se convierten las variables a double, con el fin de garantizar que la operacion si me devuelva un valor de tipo double.
                double ValorCuota = ( (double) ValorAptoNumero / numeroCuotas); 
                double ValorCuotaInteres = ValorCuota + (ValorCuota*((double)TasaInteres / 100));

                CrearCuota CrearCuota = new CrearCuota();
                CrearCuota.registrarCuota(ValorCuotaInteres, CampoFechaEscritura.getText(), CampoCedulaCliente1.getText()); 
        
                VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
                this.dispose();
                VentanaAsesor.setVisible(true);

            }
            }
    }
            
        

    private void NoCuotasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        String seleccion = (String) NoCuotasComboBox.getSelectedItem();
        if (seleccion.equals("1")) {
            LabelTasaInt.setText("Tasa de Interés: N/a");
            this.TasaInteres = 0;
        } else if (seleccion.equals("60")) {
            LabelTasaInt.setText("Tasa de Interés: 8%");
            this.TasaInteres = 8;

        } else if (seleccion.equals("120")) {
            LabelTasaInt.setText("Tasa de Interés: 10%");
            this.TasaInteres = 10;

        } else if (seleccion.equals("180")) {
            LabelTasaInt.setText("Tasa de Interés: 12%");
            this.TasaInteres = 12;

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
    private javax.swing.JButton BotonRegresoInicio;
    private javax.swing.JTextField CampoCedulaAsesor;
    private javax.swing.JTextField CampoCedulaCliente1;
    private javax.swing.JTextField CampoFechaEscritura;
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
    private javax.swing.JLabel Nota1;
    private javax.swing.JLabel Nota2;
    private javax.swing.JLabel Nota3;
    private javax.swing.JPanel PanelInfoVenta;
    private javax.swing.JPanel PanelLateralVenta;
    private javax.swing.JPanel PanelRegistroVenta;
    // End of variables declaration
}
