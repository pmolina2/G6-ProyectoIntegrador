package Vista;
/*En esta ventana se muestra un scroll pane, con todas las cuotas actuales de los clientes que tienen una venta activa. Así mismo, hay una barra de búsqueda
para obtener la cuota actual de un cliente específico de manera rápida.*/


//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador y las que contiene el package Dominio. 
import CONTROLADOR.*;
import Dominio.*;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class VentanaCuotaCliente extends javax.swing.JFrame {

    //Se define un atributo del tipo Cuota.
    Cuota CuotaAPagar;
   
   //Metodo constructor de la clase. 
    public VentanaCuotaCliente(String CedulaCliente) { //Recibe como parámetro la Cedula de un cliente.
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage()); //Se establece el icono del jframe.
        
        initComponents(); //Se inicializan los componentes 
        
        //Se establece el fondo del panel principal, para ello:

        FondoPanel fondo = new FondoPanel();      //Instancia de la clase panel
        fondo.setLayout(new BorderLayout());  //Se establece su layout
    
        //Se agrega el panel principal al panel de fondo
        fondo.add(PanelPrincipalCC);  
        this.setContentPane(fondo);
    
        //Se hace el panel principal transparente
        PanelPrincipalCC.setOpaque(false);

        LabelCedCliente.setText("CC " + CedulaCliente); //Se establece el texto de LabelCedCliente como la cédula recibida como parametro.

        ConsultarCuotaCedula ConsultaCuota = new ConsultarCuotaCedula(); //Se crea una instancia de la clase ConsultarCuotaCedula.
        Cuota CuotaCliente = ConsultaCuota.devolverCuotaCedula(CedulaCliente); /*Se ejecuta su método devolverCuotaCedula, pasándole como parámetro la cedula del cliente. 
        Este devuelve un objeto del tipo cuota que se almacena en una variable*/
        this.CuotaAPagar = CuotaCliente; //El atributo CuotaAPagar de la clase será este objeto de tipo Cuota.
        
        ConsultarCliente ConsultaCliente = new ConsultarCliente(); //Se crea una instancia de la clase ConsultarCliente
        String nombre = ConsultaCliente.consultarCliente(CedulaCliente);  /*Se ejecuta su método consultarCliente, pasándole como parámetro la cedula del cliente. 
        Este devuelve un nombre, que se almacena en una variable de tipo String*/


        //Se establecen los textos de los labels utilizando el nombre obtenido anteriormente, y los atributos del objeto de tipo Cuota, también creado con anterioridad.
        LabelNomCliente.setText(nombre.toUpperCase()); 
        LabelEstadoCuota.setText(CuotaCliente.getEstado().toUpperCase()); 
        LabelFechaPago.setText("Fecha: " + CuotaCliente.getFechaCuota()); 
        LabelNumeroCuota.setText("Cuota: " + CuotaCliente.getNumeroCuota());
        LabelValorCuota.setText("$" + CuotaCliente.getValor());

       
        if (LabelEstadoCuota.getText().equals("PROXIMA A VENCER")){ //Si el texto de LabelEstadoCuota es proxima a vencer
            PanelCuotaCliente.setBackground(new java.awt.Color(0, 102, 0)); //El color de fondo del panel será verde
        } //De lo contrario, la cuota está vencida
        else{
            PanelCuotaCliente.setBackground(new java.awt.Color(150, 0, 0)); //El color de fondo del panel será rojo

        }
      
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">   


    /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/                       
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
        setTitle("SGPU - Información de Cuota");
        setResizable(false);

        PanelPrincipalCC.setBackground(new java.awt.Color(255, 255, 255));

        PanelCuotaCliente.setBackground(new java.awt.Color(153, 0, 0));
        PanelCuotaCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        EncabezadoCuota.setBackground(new java.awt.Color(51, 51, 51));

        LabelNomCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelNomCliente.setForeground(new java.awt.Color(255, 255, 255));
        LabelNomCliente.setText("Pierre Angelo Molina Motta");

        LabelCedCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
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

        LabelValorCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 60)); 
        LabelValorCuota.setForeground(new java.awt.Color(255, 255, 255));

        LabelEstadoCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); 
        LabelEstadoCuota.setForeground(new java.awt.Color(255, 255, 255));
        LabelEstadoCuota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        LabelFechaPago.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); 
        LabelFechaPago.setForeground(new java.awt.Color(255, 255, 255));
    
        LabelNumeroCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); 
        LabelNumeroCuota.setForeground(new java.awt.Color(255, 255, 255));
    

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


        //Boton que redirige al asesor a la ventana de pago de la cuota.
        BotonPagarCuota.setBackground(new java.awt.Color(0, 51, 102));
        BotonPagarCuota.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonPagarCuota.setForeground(new java.awt.Color(255, 255, 255));
        BotonPagarCuota.setText("REGISTRAR PAGO");
        BotonPagarCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BotonPagarCuota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPagarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPagarCuotaActionPerformed(evt);
            }
        });

        LabelTituloCC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 60)); 
        LabelTituloCC.setText("INFORMACIÓN DE LA CUOTA");

        //Boton para regresar a la ventana anterior, en este caso, a la ventana de todas las cuotas de los clientes.
        BotonRegresarCC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); 
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
    }          

/*Al presionar el BotonPagarCuota, se crea una instancia de VentanaPagoCuota, pasandole como parametro, la cuota a pagar, que es una atributo de la clase.
Se se desecha la ventana actual y se hace visible la nueva ventana.*/
    private void BotonPagarCuotaActionPerformed(java.awt.event.ActionEvent evt) {    
        VentanaPagoCuota VentanaPago = new VentanaPagoCuota(this.CuotaAPagar);
        this.dispose();
        VentanaPago.setVisible(true);

    }                                               

//Al hacer clic en el botón regresar, se crea una nueva instancia de VentanaCuotas, se desecha la ventana actual y se hace visible la nueva ventana. 
    private void BotonRegresarCCActionPerformed(java.awt.event.ActionEvent evt) {                                                
       VentanaCuotas VentanaCuotas = new VentanaCuotas();
       this.dispose();
       VentanaCuotas.setVisible(true);

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
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCuotaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

     // Declaración de Variables                
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
     // Fin de la declaración de Variables               
}
