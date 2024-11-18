package Vista;

//En esta ventana se muestran todas las torres que pertenecen a un proyecto específico.


//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador y las clases que contiene el package dominio. 
import CONTROLADOR.*;
import Dominio.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class VentanaTorresAdmin extends javax.swing.JFrame {


    //Se establecen como atributos un objeto del tipo "FondoPanel" y un ArrayList de objetos del tipo "Torre"
    private FondoPanel fondo = new FondoPanel();
    private ArrayList<Torre> Torres;
    
   
   /*Método constructor de la clase. Primero, se utiliza el método setContentPane, pasandole como parámetro el objeto "fondo", para establecer el fondo del componente 
   principal del Jframe. Se inicializan los componentes, se establece el icono del Jframe, utilizando la imagen "Logo Ventana" que se encuentra en la carpeta Iconos. 
   Se crea un objeto del tipo ConsultarTorre, y se llama a su método "devolverTorres", pasándole como parámetro el id del proyecto contenido en el atributo "ProyectoActual" 
   de la Sesión y el nombre y contraseña del usuario de la base de datos, que en este caso es adming6 y admin respectivamente. 
   Este método retorna un ArrayList de objetos del tipo Torre, el cual se asigna al atributo "Torres" de la clase. 
   Luego, se establece el texto de cada uno de los botones de las torres, tomando en cuenta
   la torre correspondiente de la lista. Por ejemplo, para el BotonTorre1as se establece el número de la torre en la posición 0 de la lista.*/
   
    public VentanaTorresAdmin() {
        this.setContentPane(fondo);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        LabelNombreProyecto.setText(Sesion.getProyectoActual().getNombre().toUpperCase());
        ConsultarTorre ConsultaTorre = new ConsultarTorre();
        this.Torres = ConsultaTorre.devolverTorres(Sesion.getProyectoActual().getId(), "adming6", "admin");
        BotonTorre1as.setText("TORRE " + Torres.get(0).getNumTorre().toUpperCase());
        BotonTorre2as.setText("TORRE " + Torres.get(1).getNumTorre().toUpperCase());
        BotonTorre3as.setText("TORRE " + Torres.get(2).getNumTorre().toUpperCase());
        BotonTorre4as.setText("TORRE " + Torres.get(3).getNumTorre().toUpperCase());
        
    }

   
    /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/                       
    private void initComponents() {

        LabelNombreProyecto = new javax.swing.JLabel();
        BotonTorre1as = new javax.swing.JButton();
        BotonTorre2as = new javax.swing.JButton();
        BotonTorre4as = new javax.swing.JButton();
        BotonTorre3as = new javax.swing.JButton();
        BotonRegresar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Torres");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        LabelNombreProyecto.setBackground(new java.awt.Color(250, 250, 250));
        LabelNombreProyecto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelNombreProyecto.setForeground(new java.awt.Color(102, 102, 102));
        LabelNombreProyecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNombreProyecto.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        BotonTorre1as.setBackground(new java.awt.Color(170, 170, 170));
        BotonTorre1as.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30));
        BotonTorre1as.setForeground(new java.awt.Color(102, 102, 102));
        BotonTorre1as.setBorder(null);
        BotonTorre1as.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonTorre1as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTorre1asActionPerformed(evt);
            }
        });

        BotonTorre2as.setBackground(new java.awt.Color(170, 170, 170));
        BotonTorre2as.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30));
        BotonTorre2as.setForeground(new java.awt.Color(102, 102, 102));
        BotonTorre2as.setBorder(null);
        BotonTorre2as.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonTorre2as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTorre2asActionPerformed(evt);
            }
        });

        BotonTorre3as.setBackground(new java.awt.Color(170, 170, 170));
        BotonTorre3as.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); 
        BotonTorre3as.setForeground(new java.awt.Color(102, 102, 102));
        BotonTorre3as.setBorder(null);
        BotonTorre3as.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonTorre3as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTorre3asActionPerformed(evt);
            }
        });

        BotonTorre4as.setBackground(new java.awt.Color(170, 170, 170));
        BotonTorre4as.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30));
        BotonTorre4as.setForeground(new java.awt.Color(102, 102, 102));
        BotonTorre4as.setBorder(null);
        BotonTorre4as.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonTorre4as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTorre4asActionPerformed(evt);
            }
        });

        //Boton para poder regresar a la ventana anterior, que en este caso es la ventana de inicio del administrador.
        BotonRegresar3.setBackground(new java.awt.Color(240, 240, 240));
        BotonRegresar3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); 
        BotonRegresar3.setText("← Regresar");
        BotonRegresar3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonRegresar3.setContentAreaFilled(false);
        BotonRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(LabelNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotonTorre3as, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonTorre1as, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonTorre2as, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonTorre4as, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(BotonRegresar3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(LabelNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonTorre2as, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonTorre1as, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonTorre3as, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonTorre4as, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(BotonRegresar3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }


    /*Al presionar alguno de los botones que representan una torre, se cierra la ventana actual, luego, se crea un objeto del tipo Torre, al cual se le asigna la torre
     correspondiente del ArrayList "Torres", que es un atributo de la clase, posteriormente, se crea la ventana de Apartamentos para el administrador, pasándole como 
     parámetro el objeto de tipo Torre creado previamente, para finalmente hacer visible esta nueva ventana*/                    

    private void BotonTorre1asActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
        Torre torreSeleccionada = Torres.get(0); 
        VerAptosAdmin AptosAdmin = new VerAptosAdmin(torreSeleccionada); 
        AptosAdmin.setVisible(true); 
    }                                             

    private void BotonTorre2asActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
        Torre torreSeleccionada = Torres.get(1); 
        VerAptosAdmin AptosAdmin = new VerAptosAdmin(torreSeleccionada); 
        AptosAdmin.setVisible(true); 

    }                                             

    private void BotonTorre4asActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
        Torre torreSeleccionada = Torres.get(3); 
        VerAptosAdmin AptosAdmin = new VerAptosAdmin(torreSeleccionada); 
        AptosAdmin.setVisible(true); 
    }                                             

    private void BotonTorre3asActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
        Torre torreSeleccionada = Torres.get(2); 
        VerAptosAdmin AptosAdmin = new VerAptosAdmin(torreSeleccionada); 
        AptosAdmin.setVisible(true); 
    }                                             


   //Al presionar el botón regresar, se crea una nueva instancia de VentanaInicioAdmin, se desecha la ventana actual y se hace visible la nueva ventana.
    private void BotonRegresar3ActionPerformed(java.awt.event.ActionEvent evt) {     
        VentanaInicioAdmin VentanaAdmin = new VentanaInicioAdmin();
        this.dispose();
        VentanaAdmin.setVisible(true);
    }                                              


    //Método main definido por defecto por Netbeans
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaTorresAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTorresAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTorresAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTorresAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


    // Declaración de variables                 
    private javax.swing.JButton BotonRegresar3;
    private javax.swing.JButton BotonTorre1as;
    private javax.swing.JButton BotonTorre2as;
    private javax.swing.JButton BotonTorre3as;
    private javax.swing.JButton BotonTorre4as;
    private javax.swing.JLabel LabelNombreProyecto;
    // Fin de la declaración de variables
}