package Vista;

/*En esta ventana se puede registrar el pago de la cuota actual de un cliente, para ello se deben ingresar una serie de datos. Al registrar 
el pago la cuota del cliente esta se actualizará automáticamente*/


//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador y el package dominio. 
import CONTROLADOR.*;
import Dominio.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaPagoCuota extends javax.swing.JFrame {

    Cuota CuotaPago; //Se define un atributo del tipo Cuota.

    public VentanaPagoCuota(Cuota CuotaActual) { //Recibe un objeto del tipo Cuota
        this.CuotaPago = CuotaActual; //Establece el valor del atributo CuotaPago como la cuota pasada como parametro.
        initComponents(); //Se inician los componentes
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage()); //Se establece el icono de la ventana
        
        FondoPanel fondo = new FondoPanel(); //Se crea una instancia de la clase Jpanel
        fondo.setLayout(new BorderLayout()); //Se establece el layout del fondo

        //Agregar el panel principal al panel de fondo
        fondo.add(PanelPrincipalPC);

        this.setContentPane(fondo); //Se establece el fondo de la ventana.

        // Hacer el panel principal transparente
        PanelPrincipalPC.setOpaque(false);

        //Se añaden DocumentListeners a tres de los campos
        CampoFechaPago.getDocument().addDocumentListener(new FieldListener());
        CampoNoTransferencia.getDocument().addDocumentListener(new FieldListener());
        CampoValorPago.getDocument().addDocumentListener(new FieldListener());

        //Se establece el texto del CampoValorPago como el valor de la Cuota pasada como parametro
        CampoValorPago.setText("$" + CuotaActual.getValor());
        CampoValorPago.setEditable(false); //Se hace que este campo no sea editable

    }

    /*Este método verifica si cada uno de los campos contienen texto, utilizando isEmpty(). Si ninguno de los campos de texto están vacíos (es decir, están llenos), entonces
    el valor de "camposLlenos" será true, y se habilitará el botón "BotonConfirmarPago", en caso de que alguno de los campos esté vacío, su valor será false, y "BotonConfirmarPago"
    no se activará. Al final se ejecuta el método ActualizarAparienciaBoton()*/
    private void revisarCampos() {
        boolean camposLlenos = !CampoFechaPago.getText().trim().isEmpty()
                && !CampoNoTransferencia.getText().trim().isEmpty() && !CampoValorPago.getText().trim().isEmpty()
                && !MetodoPagoComboBox.getSelectedItem().equals("Seleccionar");
        // Activa o desactiva el botón de confirmar pago según el estado de los campos
        BotonConfirmarPago.setEnabled(camposLlenos);
        ActualizarAparienciaBoton();
    }

//Este método actualiza la apariencia del BotonConfirmarPago dependiendo de si está o no habilitado.
    private void ActualizarAparienciaBoton() {
        if (!BotonConfirmarPago.isEnabled()) { //Si no está habilitado
            BotonConfirmarPago.setBackground(Color.GRAY); // Color de fondo gris
            BotonConfirmarPago.setForeground(new Color(100, 100, 100)); // Color de texto negro
        } else { //Si está habilitado
            BotonConfirmarPago.setBackground(new Color(0, 51, 102)); // Color de fondo azul
            BotonConfirmarPago.setForeground(Color.WHITE); // Color de texto blanco
        }
        BotonConfirmarPago.repaint(); //Se redibuja el componente para que se reflejen los cambios realizados
    }


/*Cuando se presiona el boton de confirmar pago, primero se valida que la fecha ingresada en CampoFechaPago esté en el formato dd/mm/yyyy, de lo contrario se abre una ventana 
emergente con un mensaje de error. Después se verifica que se haya seleccionado una opción distinta a la opción por defecto del ComboBox, de no ser así, ocurre lo mismo, 
se genera un mensaje de error. Si pasa estas dos validaciones, se crea una instancia de la clase RegistrarPago, y el mensaje que devuelva su metodo "registrarPago", al pasarle
como parametros el valor de algunos campos y de algunos atributos del objeto de tipo Cuota (que es en sí mismo un atributo de la clase), se almacena en una variable de tipo string.
Si el mensaje contiene la palabra error, no se puedo registrar el pago, y se muestra una ventana emergente con un mensaje de error, de lo contrario, se muestra un mensaje
de confirmación y se crea una instancia de la clase ActualizarCuota, para ejecutar su método actualizarCuota pasándole como parámetro el id de la CuotaPago. Luego, se instancia
una nueva ventana de inicio de asesor, se desecha la ventana actual, y la nueva se hace visible.
*/


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


/*El propósito de esta clase es reaccionar a los cambios en el contenido de cada campo de texto y ejecutar el método revisarCampos.*/
    private class FieldListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) { //Se invoca cuando se inserta texto
            revisarCampos();
        }

        @Override
        public void removeUpdate(DocumentEvent e) { //Se invoca cuando se elimina texto
            revisarCampos();
        }

        @Override
        public void changedUpdate(DocumentEvent e) { //Se invoca cuando cambian los atributos del texto
            revisarCampos();
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">


/* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/
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


        //Boton que confirma el pago, y redirige al asesor a la ventana de inicio.
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

    // Declaración de Variables
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
    //Fin de la Declaración de Variables

}