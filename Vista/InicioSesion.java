package Vista;

//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador. 
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Dominio.*;
import CONTROLADOR.*;

public class InicioSesion extends javax.swing.JFrame {

    //Se crea un objeto del tipo FondoPanel
    FondoPanel fondo = new FondoPanel();

    /*Método constructor de la clase. En este, se utiliza el método setContentPane, pasandole como parámetro el objeto creado, para establecer el 
    fondo del componente principal del Jframe. Además, se establece el icono del Jframe, utilizando la imagen "Logo Ventana" que se encuentra en la carpeta Iconos.
    Luego se coloca una imagen, con ayuda de la interfaz Icon, y el LabelImagen. Por último se establece que el LabelInicioSesion sea opaco, y su fondo sea de color blanco.
    */
    public InicioSesion() {
        this.setContentPane(fondo); 
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        initComponents();
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage()
                .getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), 0));
        labelImagen.setIcon(miIcono);
        LabelInicioSesion.setOpaque(true);
        LabelInicioSesion.setBackground(Color.WHITE);

    }

    /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.  */
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        LabelInicioSesion = new javax.swing.JLabel();
        PanelInicioSesion = new javax.swing.JPanel();
        LabelContraseña = new javax.swing.JLabel();
        LabelCedula = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        CampoContraseña = new javax.swing.JPasswordField();
        CampoCedula = new javax.swing.JTextField();
        BotonEntrar = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Inicio de Sesión");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        LabelInicioSesion.setBackground(new java.awt.Color(255, 255, 255));
        LabelInicioSesion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 32)); // NOI18N
        LabelInicioSesion.setText("   INICIAR SESIÓN");
        LabelInicioSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PanelInicioSesion.setBackground(new java.awt.Color(255, 255, 255));
        PanelInicioSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        LabelContraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 22)); // NOI18N
        LabelContraseña.setText("Contraseña");

        LabelCedula.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 22)); // NOI18N
        LabelCedula.setText("Cédula");

        CampoContraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        CampoContraseña.setForeground(new java.awt.Color(102, 102, 102));
        CampoContraseña.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)),
                javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        CampoCedula.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        CampoCedula.setForeground(new java.awt.Color(102, 102, 102));
        CampoCedula.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)),
                javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        BotonEntrar.setBackground(new java.awt.Color(0, 51, 102));
        BotonEntrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonEntrar.setText("ENTRAR");
        BotonEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BotonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInicioSesionLayout = new javax.swing.GroupLayout(PanelInicioSesion);
        PanelInicioSesion.setLayout(PanelInicioSesionLayout);
        PanelInicioSesionLayout.setHorizontalGroup(
                PanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(PanelInicioSesionLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelInicioSesionLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(LabelCedula)
                                                .addComponent(CampoContraseña)
                                                .addComponent(LabelContraseña)
                                                .addComponent(CampoCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 500,
                                                        Short.MAX_VALUE))
                                        .addComponent(BotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addContainerGap()));
        PanelInicioSesionLayout.setVerticalGroup(
                PanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                                .addGroup(PanelInicioSesionLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(LabelCedula)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(LabelContraseña)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(BotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 395,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(197, 197, 197)
                                                .addComponent(PanelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(532, 532, 532)
                                                .addComponent(LabelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(249, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(LabelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(PanelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(158, Short.MAX_VALUE)));

        pack();
    }

    /*Método que establece las acciones que se van a realizar cuando el botón "Entrar" sea presionado. Se obtienen los valores introducidos en los Campos de texto y 
    se guardan en variables, luego, sea crea un objeto del tipo "InicioSesionC", "ConsultarAsesor", "ConsultarAdmin" y "ConsultarProyecto". Posterioromente se 
    guarda en un ArrayList de strings, el ArrayList que devuelve el método "verificacionInicio" del objeto del tipo "InicioSesionC"*/

    private void BotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BotonEntrarActionPerformed
        String cedulaUsuario = CampoCedula.getText();
        String contraseñaUsuario = CampoContraseña.getText();
        InicioSesionC inicio = new InicioSesionC();
        ConsultarAsesor ConsultaAsesor = new ConsultarAsesor();
        ConsultarAdmin ConsultaAdmin = new ConsultarAdmin();
        ConsultarProyecto ConsultarProyectos = new ConsultarProyecto();

        ArrayList<String> datos = inicio.verificacionInicio(cedulaUsuario, contraseñaUsuario);


        /*Condicional que maneja el inicio de Sesión. Si la Lista no está vacía, quiere decir que se encontró a algún usuario con las credenciales ingresadas, entonces, en
        la posición 0, se encontraría su cedula, en la 1, su contraseña, y en la 2, su rol.
        Si los datos concuerdan, y el rol es administrador, se guarda en un objeto del tipo Admin, el objeto que retorna el método "devolverAdmin" de la clase
        "ConsultaAdmin" al pasarle como parámetro la cedula del usuario, luego en un ArrayList de objetos del tipo Proyecto, se guarda el ArrayList que devuelve 
        el método "devolverProyectos" de la clase "ConsultarProyectos". Ahora, se inicializa la ventana del Adminstrador, pasandole como parámetros el AdminActual, 
        y la lista de proyectos. Se cierra la ventana actual y se muestra la nueva ventana. Este mismo proceso se realiza cuando el rol es asesor, solo que se abre
        la ventana del asesor.*/
        
        if (datos.size() != 0) {

            if (datos.get(0).equals(cedulaUsuario) && datos.get(1).equals(contraseñaUsuario) && datos.get(2).equals("administrador")) {
                Admin AdminActual = ConsultaAdmin.devolverAdmin(cedulaUsuario);
                ArrayList<Proyecto> Proyectos = ConsultarProyectos.devolverProyectos("admin", "admin");
                
                @SuppressWarnings("unused")
                Sesion SesionActual = new Sesion(AdminActual.getCedula(), AdminActual.getNombreCompleto(), Proyectos);
        
                VentanaInicioAdmin VentanaAdmin = new VentanaInicioAdmin();
                this.dispose();
                VentanaAdmin.setVisible(true);

            } else if (datos.get(0).equals(cedulaUsuario) && datos.get(1).equals(contraseñaUsuario) && datos.get(2).equals("asesor")) {
                Asesor AsesorActual = ConsultaAsesor.devolverAsesor(cedulaUsuario);
                ArrayList<Proyecto> Proyectos = ConsultarProyectos.devolverProyectos("asesor","asesor");
               
                @SuppressWarnings("unused")
                Sesion SesionActual = new Sesion(AsesorActual.getCedula(), AsesorActual.getNombreCompleto(), Proyectos);

                VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
                this.dispose();
                VentanaAsesor.setVisible(true);
            } 
        } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta, \nintente nuevamente", //Si la lista está vacía, se le indica al usuario que no se 
                "Mensaje de Error", JOptionPane.ERROR_MESSAGE);       //encontró ninguna persona en la base de datos con esas credenciales                                                 
        }

    }

    //Método Main definido por defecto al utilizar Java Swing con Netbeans.
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });

    }

    // Declaración de Variables
    private javax.swing.JButton BotonEntrar;
    private javax.swing.JTextField CampoCedula;
    private javax.swing.JPasswordField CampoContraseña;
    private javax.swing.JLabel LabelCedula;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelInicioSesion;
    private javax.swing.JPanel PanelInicioSesion;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagen;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // Fin de la declaración de Variables

}
