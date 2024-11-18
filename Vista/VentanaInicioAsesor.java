
package Vista;

/*Esta es la ventana principal del usuario Asesor. Aquí, se muestran en el encabezado su nombre y rol, además de dos botontes, uno lo dirige a la ventana de las cuotas
y el otro lo dirige a la ventana de registro de clientes*/

//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador. 
import CONTROLADOR.*;
import Dominio.*;
import javax.swing.*;


public class VentanaInicioAsesor extends javax.swing.JFrame {

/*Método constructor de la clase. Primero se inicializan los componentes del Jframe, y se establece el icono de este, como la imagen "Logo Ventana" ubicada en la carpeta 
Iconos. Luego se coloca una imagen con la ayuda de la interfaz Icon, y el LabelImagen3. Se establece que el LabelNombre2 sea opaco y que su texto
sea el valor del campo "Nombre" de la clase sesión (En mayúsculas). Luego, se establece el labelRol2 sea opaco, y su texto sea la palabra "ASESOR".*/

    public VentanaInicioAsesor() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage()
                .getScaledInstance(LabelImagen3.getWidth(), LabelImagen3.getHeight(), 0));
        LabelImagen3.setIcon(miIcono);
        LabelNombre2.setOpaque(true);
        LabelNombre2.setText(Sesion.getNombre().toUpperCase());
        LabelRol2.setOpaque(true);
        LabelRol2.setText("ASESOR");
    }

 /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.  */
     private void initComponents() {

        PanelPrincipalAs = new javax.swing.JPanel();
        PanelLateralAs = new javax.swing.JPanel();
        LabelImagen3 = new javax.swing.JLabel();
        BotonConsultarCuotas = new javax.swing.JButton();
        BotonCerrarSesionAs = new javax.swing.JButton();
        BotonRegistrarCliente = new javax.swing.JButton();
        LabelRol2 = new javax.swing.JLabel();
        LabelNombre2 = new javax.swing.JLabel();
        LabelProyectos2 = new javax.swing.JLabel();
        BotonProyecto7 = new javax.swing.JButton();
        BotonProyecto8 = new javax.swing.JButton();
        BotonProyecto6 = new javax.swing.JButton();
        BotonProyecto5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Inicio");
        setResizable(false);

        PanelPrincipalAs.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalAs.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelLateralAs.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralAs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));


        //Se crea el botón que redirige al asesor a la ventana de cuotas
        BotonConsultarCuotas.setBackground(new java.awt.Color(0, 51, 102));
        BotonConsultarCuotas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonConsultarCuotas.setForeground(new java.awt.Color(255, 255, 255));
        BotonConsultarCuotas.setText("CONSULTAR CUOTAS");
        BotonConsultarCuotas.setBorder(null);
        BotonConsultarCuotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonConsultarCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConsultarCuotasActionPerformed(evt);
            }
        });

        //Se crea un botón para cerrar la sesión, que regresa al usuario al inicio de sesion
        BotonCerrarSesionAs.setBackground(new java.awt.Color(240, 240, 240));
        BotonCerrarSesionAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonCerrarSesionAs.setText("Cerrar Sesion");
        BotonCerrarSesionAs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonCerrarSesionAs.setContentAreaFilled(false);
        BotonCerrarSesionAs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCerrarSesionAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarSesionAsActionPerformed(evt);
            }
        });

        //Se crea el botón que redirige al asesor a la ventana de registro de clientes.
        BotonRegistrarCliente.setBackground(new java.awt.Color(0, 51, 102));
        BotonRegistrarCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistrarCliente.setText("REGISTRAR CLIENTE");
        BotonRegistrarCliente.setBorder(null);
        BotonRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralAsLayout = new javax.swing.GroupLayout(PanelLateralAs);
        PanelLateralAs.setLayout(PanelLateralAsLayout);
        PanelLateralAsLayout.setHorizontalGroup(
            PanelLateralAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralAsLayout.createSequentialGroup()
                .addGroup(PanelLateralAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLateralAsLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(LabelImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLateralAsLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(BotonCerrarSesionAs, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLateralAsLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(PanelLateralAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonConsultarCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelLateralAsLayout.setVerticalGroup(
            PanelLateralAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralAsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(BotonConsultarCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(BotonCerrarSesionAs, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        LabelRol2.setBackground(new java.awt.Color(240, 240, 240));
        LabelRol2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelRol2.setForeground(new java.awt.Color(51, 51, 51));
        LabelRol2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        LabelNombre2.setBackground(new java.awt.Color(240, 240, 240));
        LabelNombre2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelNombre2.setForeground(new java.awt.Color(51, 51, 51));
        LabelNombre2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        LabelProyectos2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelProyectos2.setText("PROYECTOS DISPONIBLES");


        /*En la parte de la declaración de los botones, además de establecer sus propiedades, se establece su texto, dependiendo de que
        proyecto representen, por ejemplo, el BotonProyecto5 en este caso representa el primer proyecto encontrado en la Base de Datos, 
        por lo tanto, se establece su texto como el nombre del proyecto en la posicion 0 del ArrayList "proyectos" que es un atributo de la clase sesión
        Además, a cada botón se le agrega un actionListener que define que acción se va a realizar cuando el botón sea presionado. 
        En cada caso, se ejecuta el método abrirVentanaTorres pasándole como parámetro el
        proyecto correspondiente (por ejemplo, en el caso de BotonProyecto5 sería el primer proyecto del arraylist proyectos)*/


        BotonProyecto5.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonProyecto5.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto5.setBorder(null);
        BotonProyecto5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto5.setText(Sesion.getListaProyectos().get(0).getNombre().toUpperCase());
        BotonProyecto5.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(0)));

        BotonProyecto6.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonProyecto6.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto6.setBorder(null);
        BotonProyecto6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto6.setText(Sesion.getListaProyectos().get(1).getNombre().toUpperCase());
        BotonProyecto6.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(1)));

        BotonProyecto7.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonProyecto7.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto7.setBorder(null);
        BotonProyecto7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto7.setText(Sesion.getListaProyectos().get(2).getNombre().toUpperCase());
        BotonProyecto7.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(2)));

        BotonProyecto8.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20));
        BotonProyecto8.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto8.setBorder(null);
        BotonProyecto8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto8.setText(Sesion.getListaProyectos().get(3).getNombre().toUpperCase());
        BotonProyecto8.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(3)));

     
        

        javax.swing.GroupLayout PanelPrincipalAsLayout = new javax.swing.GroupLayout(PanelPrincipalAs);
        PanelPrincipalAs.setLayout(PanelPrincipalAsLayout);
        PanelPrincipalAsLayout.setHorizontalGroup(
            PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(PanelLateralAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelRol2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalAsLayout.createSequentialGroup()
                                .addComponent(LabelProyectos2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(352, 352, 352))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalAsLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotonProyecto5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonProyecto7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonProyecto8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonProyecto6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(141, 141, 141))))))
        );
        PanelPrincipalAsLayout.setVerticalGroup(
            PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                        .addComponent(LabelNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LabelRol2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(LabelProyectos2)
                        .addGap(66, 66, 66)
                        .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonProyecto5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonProyecto6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonProyecto7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonProyecto8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PanelLateralAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }



    //Al presionar el botón consultar cuotas, se crea una instancia de VentanaCuotas, se desecha la ventana actual y se hace visible la nueva ventana.
    private void BotonConsultarCuotasActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaCuotas VentanaCuotas = new VentanaCuotas();
        this.dispose();
        VentanaCuotas.setVisible(true);
    }


    //Al presionar el botón registrar cliente, se crea una instancia de VentanaRegistroCliente, se desecha la ventana actual y se hace visible la nueva ventana.
    private void BotonRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        VentanaRegistroCliente VentanaCliente = new VentanaRegistroCliente();
        this.dispose();
        VentanaCliente.setVisible(true);
    }    

/*Al presionar el Boton CerrarSesion, se le muestra al usuario un mensaje confirmándole su acción, se cierra la ventana actual, se crea una nueva ventana de inicio de Sesion
y se hace visible*/
    private void BotonCerrarSesionAsActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Sesion cerrada correctamente", "Mensaje Informativo",
                JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        InicioSesion InicioSes = new InicioSesion();
        InicioSes.setVisible(true);
    }


/*Metodo para abrir la ventana de las torres del proyecto seleccionado.
Se establece que el valor del campo proyecto de la sesión sea el proyecto que se le pasa como parámetro, luego se crea una instancia de VentanaTorresAsesor, 
se desecha la ventana actual, y se hace visible la nueva ventana*/
    private void abrirVentanaTorres(Proyecto proyecto) {
        Sesion.setProyecto(proyecto);
        VentanaTorresAsesor VentanaTorresAsesor = new VentanaTorresAsesor();
        this.dispose();
        VentanaTorresAsesor.setVisible(true);
    }


    // Declaración de Variables
    private javax.swing.JButton BotonConsultarCuotas;
    private javax.swing.JButton BotonProyecto5;
    private javax.swing.JButton BotonProyecto6;
    private javax.swing.JButton BotonProyecto7;
    private javax.swing.JButton BotonProyecto8;
    private javax.swing.JButton BotonCerrarSesionAs;
    private javax.swing.JButton BotonRegistrarCliente;
    private javax.swing.JLabel LabelImagen3;
    private javax.swing.JLabel LabelNombre2;  
    private javax.swing.JLabel LabelProyectos2;
    private javax.swing.JLabel LabelRol2;
    private javax.swing.JPanel PanelLateralAs;
    private javax.swing.JPanel PanelPrincipalAs;
    // Fin de Declaración de Variables
}
