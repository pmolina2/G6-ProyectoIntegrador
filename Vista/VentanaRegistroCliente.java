package Vista;
//En esta ventana se lleva a cabo el registro de nuevos clientes en la base de datos. 

//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador y el package dominio. 

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import CONTROLADOR.*;


public class VentanaRegistroCliente extends javax.swing.JFrame {

   //Metodo constructor de la clase
    public VentanaRegistroCliente() {
        initComponents(); //Se inicializan los componentes
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage()); //Se establece el icono del jframe
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage().getScaledInstance(LabelImagenRC.getWidth(), LabelImagenRC.getHeight(), 0));
        LabelImagenRC.setIcon(miIcono); //Se agrega una imagen a un label
    }

  /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.  */                      
    private void initComponents() {

        PanelPrincipalRC = new javax.swing.JPanel();
        PanelRegistro = new javax.swing.JPanel();
        LabelTituloRC = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoCedula = new javax.swing.JTextField();
        CampoSisben = new javax.swing.JTextField();
        CampoCorreo = new javax.swing.JTextField();
        CampoDireccion = new javax.swing.JTextField();
        CampoTelefono = new javax.swing.JTextField();
        LabelCedula = new javax.swing.JLabel();
        LabelNombreCompleto = new javax.swing.JLabel();
        LabelSisben = new javax.swing.JLabel();
        LabelSubsidio = new javax.swing.JLabel();
        LabelDireccion = new javax.swing.JLabel();
        LabelTelefono = new javax.swing.JLabel();
        LabelSubsidio1 = new javax.swing.JLabel();
        BotonRegistrarC = new javax.swing.JButton();
        SubsidioComboBox = new javax.swing.JComboBox<>();
        PanelLateralRC = new javax.swing.JPanel();
        LabelImagenRC = new javax.swing.JLabel();
        BotonRegresarRC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Registro de Clientes");
        setResizable(false);

        PanelPrincipalRC.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalRC.setMaximumSize(new java.awt.Dimension(1400, 800));
        PanelPrincipalRC.setMinimumSize(new java.awt.Dimension(1400, 800));

        PanelRegistro.setBackground(new java.awt.Color(240, 240, 240));
        PanelRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        LabelTituloRC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); 
        LabelTituloRC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTituloRC.setText("REGISTRO DE CLIENTES");

        CampoNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); 
        CampoNombre.setForeground(new java.awt.Color(102, 102, 102));
        CampoNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoCedula.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); 
        CampoCedula.setForeground(new java.awt.Color(102, 102, 102));
        CampoCedula.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoSisben.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); 
        CampoSisben.setForeground(new java.awt.Color(102, 102, 102));
        CampoSisben.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoCorreo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); 
        CampoCorreo.setForeground(new java.awt.Color(102, 102, 102));
        CampoCorreo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoDireccion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); 
        CampoDireccion.setForeground(new java.awt.Color(102, 102, 102));
        CampoDireccion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoTelefono.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); 
        CampoTelefono.setForeground(new java.awt.Color(102, 102, 102));
        CampoTelefono.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
    
        LabelCedula.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelCedula.setForeground(new java.awt.Color(65, 65, 65));
        LabelCedula.setText("Cédula*");

        LabelNombreCompleto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelNombreCompleto.setForeground(new java.awt.Color(65, 65, 65));
        LabelNombreCompleto.setText("Nombre Completo*");

        LabelSisben.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelSisben.setForeground(new java.awt.Color(65, 65, 65));
        LabelSisben.setText("SISBEN*");

        LabelSubsidio.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelSubsidio.setForeground(new java.awt.Color(65, 65, 65));
        LabelSubsidio.setText("Subsidio*");

        LabelDireccion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelDireccion.setForeground(new java.awt.Color(65, 65, 65));
        LabelDireccion.setText("Dirección*");

        LabelTelefono.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelTelefono.setForeground(new java.awt.Color(65, 65, 65));
        LabelTelefono.setText("Teléfono*");

        LabelSubsidio1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        LabelSubsidio1.setForeground(new java.awt.Color(65, 65, 65));
        LabelSubsidio1.setText("Correo Electrónico*");

        //Boton para confirmar el registro del cliente, el cual se guarda de manera automática en la base de datos.
        BotonRegistrarC.setBackground(new java.awt.Color(0, 51, 102));
        BotonRegistrarC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonRegistrarC.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistrarC.setText("REGISTRAR");
        BotonRegistrarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegistrarC.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarCActionPerformed(evt);
            }
        });

        SubsidioComboBox.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 15)); 
        SubsidioComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));
        SubsidioComboBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelCedula)
                    .addComponent(CampoCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(LabelSubsidio)
                    .addComponent(CampoCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(LabelSubsidio1)
                    .addComponent(SubsidioComboBox, 0, 245, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelDireccion)
                            .addComponent(LabelNombreCompleto))
                        .addGap(139, 139, 139)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelSisben)
                            .addComponent(LabelTelefono)))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoSisben, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(BotonRegistrarC, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTituloRC, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(LabelTituloRC, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCedula)
                    .addComponent(LabelNombreCompleto)
                    .addComponent(LabelSisben))
                .addGap(7, 7, 7)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoSisben, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSubsidio)
                    .addComponent(LabelDireccion)
                    .addComponent(LabelTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubsidioComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CampoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(LabelSubsidio1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(BotonRegistrarC, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        PanelLateralRC.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralRC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        BotonRegresarRC.setBackground(new java.awt.Color(240, 240, 240));
        BotonRegresarRC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonRegresarRC.setText("← Regresar");
        BotonRegresarRC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonRegresarRC.setContentAreaFilled(false);
        BotonRegresarRC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresarRC.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarRCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralRCLayout = new javax.swing.GroupLayout(PanelLateralRC);
        PanelLateralRC.setLayout(PanelLateralRCLayout);
        PanelLateralRCLayout.setHorizontalGroup(
            PanelLateralRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralRCLayout.createSequentialGroup()
                .addGroup(PanelLateralRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLateralRCLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(BotonRegresarRC, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLateralRCLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(LabelImagenRC, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelLateralRCLayout.setVerticalGroup(
            PanelLateralRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralRCLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelImagenRC, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonRegresarRC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout PanelPrincipalRCLayout = new javax.swing.GroupLayout(PanelPrincipalRC);
        PanelPrincipalRC.setLayout(PanelPrincipalRCLayout);
        PanelPrincipalRCLayout.setHorizontalGroup(
            PanelPrincipalRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalRCLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(PanelLateralRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(PanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        PanelPrincipalRCLayout.setVerticalGroup(
            PanelPrincipalRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalRCLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PanelPrincipalRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelLateralRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }



//Al hacer clic en el botón regresar, se crea una nueva instancia de VentanaInicioAsesor, se desecha la ventana actual y se hace visible la nueva ventana. 
    private void BotonRegresarRCActionPerformed(java.awt.event.ActionEvent evt) {                                                
        VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
        this.dispose();
        VentanaAsesor.setVisible(true);
    }                                               



/*Este método realiza diversas verificaciones sobre la información ingresada por el asesor en los campos de texto. Tales como, verificar que la cédula no tenga letras, que el
nivel de sisben se componga de un número y una letra, que el número de teléfono no contenta letras, que el correo contenga "@"" y ".",  y que la opción seleccionada del combo box
no sea la opción por defecto.*/
    private boolean VerificarInfoCampos(){
        boolean Verificacion;
        if (CampoCedula.getText().length() <8 || CampoCedula.getText().matches(".*[a-zA-Z].*")){
            JOptionPane.showMessageDialog(this, "Error al introducir la cédula. Asegurese de que esta \n no contenga letras y su longitud sea mayor o igual a 8.", 
            "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(!CampoSisben.getText().matches(".*[A-Za-z].*") || !CampoSisben.getText().matches(".*\\d.*")){
            JOptionPane.showMessageDialog(this, "Error: Recuerde que los niveles del SISBEN se componen de \nuna letra y uno o más números", 
            "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(CampoTelefono.getText().matches(".*[A-Za-z].*")){
            JOptionPane.showMessageDialog(this, "Error: El número de teléfono no puede contener letras.", 
            "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(!CampoCorreo.getText().contains("@") || !CampoCorreo.getText().contains(".")){
            JOptionPane.showMessageDialog(this, "Error: El correo ingresado no es válido.", 
            "Mensaje de Error", JOptionPane.ERROR_MESSAGE);  
            return false;
        }else if(SubsidioComboBox.getSelectedItem().equals("Seleccionar")){
            JOptionPane.showMessageDialog(this, "Selecciona una opcion para el subsidio.", 
            "Mensaje de Error", JOptionPane.INFORMATION_MESSAGE); 
            return false;
    }
        return true; //Si pasa todas las verificacioens se retorna true.
    }
    
    
    //Al presinar el botón registrar
    private void BotonRegistrarCActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(VerificarInfoCampos()){ //Se valida si la información ingresada en los campos es correcta. de ser así:
            CrearCliente clienteC = new CrearCliente(); //Se crea una instancia de la clase  CrearCliente
            String mensaje = clienteC.crearCliente(CampoCedula.getText(), CampoNombre.getText(), CampoSisben.getText(),  //Se ejecuta su método crearCliente, pasándole la información
            SubsidioComboBox.getSelectedItem().toString(),CampoDireccion.getText(), CampoTelefono.getText(), CampoCorreo.getText()); //de todos los campos. Este método retorna
            if (mensaje.contains("Error")) { //Si el mensaje contiene error                                                            un mensaje
                JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE); //Se muestra un mensaje de error
            } else { //De lo contrario
                JOptionPane.showMessageDialog(this, mensaje, "Mensaje de Confirmación",
                        JOptionPane.INFORMATION_MESSAGE); //Se muestra un mensaje de confirmación
                VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor(); //Nueva instancia de VentanaInicioAsesor, se cierra la ventana actual y se hace visible la nueva.
                this.dispose();
                VentanaAsesor.setVisible(true);
            }
        }
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
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroCliente().setVisible(true);
            }
        });
    }

    // Declaración de variables                 
    private javax.swing.JButton BotonRegistrarC;
    private javax.swing.JButton BotonRegresarRC;
    private javax.swing.JTextField CampoCedula;
    private javax.swing.JTextField CampoCorreo;
    private javax.swing.JTextField CampoDireccion;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoSisben;
    private javax.swing.JTextField CampoTelefono;
    private javax.swing.JLabel LabelCedula;
    private javax.swing.JLabel LabelDireccion;
    private javax.swing.JLabel LabelImagenRC;
    private javax.swing.JLabel LabelNombreCompleto;
    private javax.swing.JLabel LabelSisben;
    private javax.swing.JLabel LabelSubsidio;
    private javax.swing.JLabel LabelSubsidio1;
    private javax.swing.JLabel LabelTelefono;
    private javax.swing.JLabel LabelTituloRC;
    private javax.swing.JPanel PanelLateralRC;
    private javax.swing.JPanel PanelPrincipalRC;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JComboBox<String> SubsidioComboBox;
    // Fin de declaración de variables                 
}
