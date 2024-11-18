package Vista;

/*Esta es la ventana principal del usuario Administrador. Aquí, se muestran en el encabezado su nombre y rol, además de un botón que le dirige a otra ventana
donde podrá generar los reportes*/

//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador. 
import CONTROLADOR.*;
import Dominio.*;
import javax.swing.*;

public class VentanaInicioAdmin extends javax.swing.JFrame {


    /*Método constructor de la clase. Primero, se inicializan los componentes del Jframe, y se establece el icono de este, como la imagen "Logo Ventana" ubicada en la carpeta 
    Iconos. Luego, se coloca una imagen con la ayuda de la interfaz Icon, y el LabelImagen2. Se establece que el LabelNombre sea opaco y que su texto
    sea el valor del campo "Nombre" de la clase sesión (En mayúsculas).
    Luego, se establece el labelRol sea opaco, y su texto sea la palabra "ADMINISTRADOR".*/

    public VentanaInicioAdmin() {

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage()
                .getScaledInstance(LabelImagen2.getWidth(), LabelImagen2.getHeight(), 0));
        LabelImagen2.setIcon(miIcono);
        LabelNombre.setOpaque(true);
        LabelNombre.setText(Sesion.getNombre().toUpperCase());
        LabelRol.setOpaque(true);
        LabelRol.setText("ADMINISTRADOR");
    }

 
     /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/
    private void initComponents() {

        PanelPrincipalA = new javax.swing.JPanel();
        PanelLateralA = new javax.swing.JPanel();
        LabelImagen2 = new javax.swing.JLabel();
        BotonCerrarSesionAdm = new javax.swing.JButton();
        BotonGenerarReporte = new javax.swing.JButton();
        LabelRol = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelProyectos = new javax.swing.JLabel();
        BotonProyecto1 = new javax.swing.JButton();
        BotonProyecto3 = new javax.swing.JButton();
        BotonProyecto2 = new javax.swing.JButton();
        BotonProyecto4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Inicio");
        setResizable(false);

        PanelPrincipalA.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalA.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelLateralA.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));


        //Se crea un botón para cerrar la sesión, que regresa al usuario al inicio de sesion
        BotonCerrarSesionAdm.setBackground(new java.awt.Color(240, 240, 240));
        BotonCerrarSesionAdm.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); 
        BotonCerrarSesionAdm.setText("Cerrar Sesión");
        BotonCerrarSesionAdm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonCerrarSesionAdm.setContentAreaFilled(false);
        BotonCerrarSesionAdm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCerrarSesionAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarSesionAdmActionPerformed(evt);
            }
        });

        //Se crea el botón que lo redirige a la ventana de reportes
        BotonGenerarReporte.setBackground(new java.awt.Color(0, 51, 102));
        BotonGenerarReporte.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); 
        BotonGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        BotonGenerarReporte.setText("GENERAR REPORTE");
        BotonGenerarReporte.setBorder(null);
        BotonGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralALayout = new javax.swing.GroupLayout(PanelLateralA);
        PanelLateralA.setLayout(PanelLateralALayout);
        PanelLateralALayout.setHorizontalGroup(
                PanelLateralALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                PanelLateralALayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BotonCerrarSesionAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96))
                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                .addGroup(PanelLateralALayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(LabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(BotonGenerarReporte,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 214,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE)));
        PanelLateralALayout.setVerticalGroup(
                PanelLateralALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(LabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BotonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272,
                                        Short.MAX_VALUE)
                                .addComponent(BotonCerrarSesionAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)));

        LabelRol.setBackground(new java.awt.Color(240, 240, 240));
        LabelRol.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelRol.setForeground(new java.awt.Color(102, 102, 102));
        LabelRol.setBorder(javax.swing.BorderFactory.createCompoundBorder(null,
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)),
                        javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1))));

        LabelNombre.setBackground(new java.awt.Color(240, 240, 240));
        LabelNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelNombre.setForeground(new java.awt.Color(102, 102, 102));
        LabelNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)),
                javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        LabelProyectos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); 
        LabelProyectos.setText("PROYECTOS DISPONIBLES");


        /*En la parte de la declaración de los botones, además de establecer sus propiedades, se establece su texto, dependiendo de que
        proyecto representen, por ejemplo, el BotonProyecto1 representa el primer proyecto encontrado en la Base de Datos, por lo tanto, se establece su texto
        como el nombre del proyecto en la posicion 0 del ArrayList "proyectos" que es un atributo de la clase sesión
        Además, a cada botón se le agrega un actionListener
        que define que acción se va a realizar cuando el botón sea presionado. En cada caso, se ejecuta el método abrirVentanaTorres pasándole como parámetro el
        proyecto correspondiente (por ejemplo, en el caso de BotonProyecto1 sería el primer proyecto del arraylist proyectos)*/


        BotonProyecto1.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonProyecto1.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto1.setBorder(null);
        BotonProyecto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto1.setText(Sesion.getListaProyectos().get(0).getNombre().toUpperCase());
        BotonProyecto1.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(0)));

        BotonProyecto2.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20));
        BotonProyecto2.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto2.setBorder(null);
        BotonProyecto2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto2.setText(Sesion.getListaProyectos().get(1).getNombre().toUpperCase());
        BotonProyecto2.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(1)));

        BotonProyecto3.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20));
        BotonProyecto3.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto3.setBorder(null);
        BotonProyecto3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto3.setText(Sesion.getListaProyectos().get(2).getNombre().toUpperCase());
        BotonProyecto3.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(2)));

        BotonProyecto4.setBackground(new java.awt.Color(170, 170, 170));
        BotonProyecto4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonProyecto4.setForeground(new java.awt.Color(102, 102, 102));
        BotonProyecto4.setBorder(null);
        BotonProyecto4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProyecto4.setText(Sesion.getListaProyectos().get(3).getNombre().toUpperCase());
        BotonProyecto4.addActionListener(e -> abrirVentanaTorres(Sesion.getListaProyectos().get(3)));

        javax.swing.GroupLayout PanelPrincipalALayout = new javax.swing.GroupLayout(PanelPrincipalA);
        PanelPrincipalA.setLayout(PanelPrincipalALayout);
        PanelPrincipalALayout.setHorizontalGroup(
                PanelPrincipalALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPrincipalALayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(PanelLateralA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelPrincipalALayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPrincipalALayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(PanelPrincipalALayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LabelNombre,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 535,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(457, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalALayout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(PanelPrincipalALayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                PanelPrincipalALayout.createSequentialGroup()
                                                                        .addComponent(LabelProyectos,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                301,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(354, 354, 354))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                PanelPrincipalALayout.createSequentialGroup()
                                                                        .addGroup(PanelPrincipalALayout
                                                                                .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(BotonProyecto1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        338,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(BotonProyecto3,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        338,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(70, 70, 70)
                                                                        .addGroup(PanelPrincipalALayout
                                                                                .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(BotonProyecto4,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        338,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(BotonProyecto2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        338,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(137, 137, 137)))))));
        PanelPrincipalALayout.setVerticalGroup(
                PanelPrincipalALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPrincipalALayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(PanelPrincipalALayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelLateralA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PanelPrincipalALayout.createSequentialGroup()
                                                .addComponent(LabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(LabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70)
                                                .addComponent(LabelProyectos)
                                                .addGap(61, 61, 61)
                                                .addGroup(PanelPrincipalALayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BotonProyecto1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonProyecto2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(60, 60, 60)
                                                .addGroup(PanelPrincipalALayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BotonProyecto3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonProyecto4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(47, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelPrincipalA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelPrincipalA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }


/*Al presionar el Boton CerrarSesion, se le muestra al usuario un mensaje confirmándole su acción, se cierra la ventana actual, se crea una nueva ventana de inicio de Sesion
y se hace visible*/
    private void BotonCerrarSesionAdmActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Sesion cerrada correctamente", "Mensaje Informativo",
                JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        InicioSesion InicioSes = new InicioSesion();
        InicioSes.setVisible(true);
    }


//Al presionar el botón GenerarReporte, Se crea una instancia de VentanaReportes, se desecha la ventana actual, y la ventana de reportes se hace visible. 
    private void BotonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaReportes ventanaReportes = new VentanaReportes();
        this.dispose();
        ventanaReportes.setVisible(true);
    }


/*Metodo para abrir la ventana de las torres del proyecto seleccionado. 
Se establece que el valor del campo proyecto de la sesión sea el proyecto que se le pasa como parámetro, luego se crea una instancia de VentanaTorresAdmin, 
se desecha la ventana actual, y se hace visible la nueva ventana*/
    private void abrirVentanaTorres(Proyecto proyecto) {
        Sesion.setProyecto(proyecto);
        VentanaTorresAdmin VentanaTorres = new VentanaTorresAdmin();
        this.dispose();
        VentanaTorres.setVisible(true);
    }

    // Declaración de Variables
    private javax.swing.JButton BotonCerrarSesionAdm;
    private javax.swing.JButton BotonGenerarReporte;
    private javax.swing.JButton BotonProyecto1;
    private javax.swing.JButton BotonProyecto2;
    private javax.swing.JButton BotonProyecto3;
    private javax.swing.JButton BotonProyecto4;
    private javax.swing.JLabel LabelImagen2;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelProyectos;
    private javax.swing.JLabel LabelRol;
    private javax.swing.JPanel PanelLateralA;
    private javax.swing.JPanel PanelPrincipalA;
    // Fin de Declaración de Variables

}
