
package Vista;
/*En esta ventana se muestra la cuota de un cliente específico, pudiendo visualizar información más detallada de ella, e incluso registrar su pago.*/

//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador y las que contiene el package Dominio. 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;  
import java.awt.*;
import CONTROLADOR.*;
import Dominio.*;
import java.util.*;


public class VentanaCuotas extends javax.swing.JFrame {

 
 /*Método constructor de la clase. Primero Se inicializan sus componentes, luego se establece el fondo del panel principal del Jframe, posteriormente se establece el icono de la 
 ventana y también se asigna la imagen "LupaIcono" al LabelLupa, al cual además se le asigna un hand cursor. Después, se establece el Layout del PanelCuotas, se crea una instancia
 de la clase ConsultarCuotas, que al ejecutar su método devolverCuotas, retorna un arraylist de objetos del tipo Cuota, que se almacena en una variable, y finalmente se le pasa
 como parámetro dicho arraylist al método agregarPanelesCuota. */
    public VentanaCuotas() {
       
        initComponents();
        
        FondoPanel fondo = new FondoPanel();
        fondo.setLayout(new BorderLayout());
    
        // Agregar el panel principal al panel de fondo
        fondo.add(PanelPrincipalCuotas);  
        this.setContentPane(fondo);
    
        // Hacer el panel principal transparente
        PanelPrincipalCuotas.setOpaque(false);

        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/LupaIcono.png")).getImage().getScaledInstance(LabelLupa.getWidth(), LabelLupa.getHeight(), 0));
        LabelLupa.setIcon(miIcono);
        LabelLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        PanelCuotas.setLayout(new javax.swing.BoxLayout(PanelCuotas, javax.swing.BoxLayout.Y_AXIS));
        
        ConsultarCuotas consultaCuotas = new ConsultarCuotas();
        ArrayList<Cuota> ListaCuotas = consultaCuotas.devolverCuotas();
        agregarPanelesCuota(ListaCuotas);
       
    }
    
    
    //Este método sirve para agregar los paneles de cuota, al panel grande de todas las cuotas que está dentro del Scroll pane.

    private void agregarPanelesCuota(ArrayList<Cuota> ListaCuotas) { //Recibe un Arraylist de objetos del tipo Cuota.
        int alturaTotal = 0; // Variable para calcular la altura total de los paneles. Inicialmente es cero.

        for (Cuota cuotaActual : ListaCuotas) { //Ciclo for each, que recorre cada objeto dentro del ArrayList.
            ConsultarCliente ConsultaCliente = new ConsultarCliente(); //Se crea una instancia de la clase ConsultarCliente.
            String NombreCliente = ConsultaCliente.consultarCliente(cuotaActual.getCedulaCliente()); /*Al pasarle la cedula del cliente de la cuota actual, al método consultarCliente,
            este retorna un nombre, que se guarda en una variable de tipo string*/
            JPanel nuevoPanel = crearPanelCuota(NombreCliente, cuotaActual.getCedulaCliente(), cuotaActual.getEstado()); /*Se ejecuta el método CrearPanelCuota, pasándole el nombre del cliente
            su cédula, y el estado de la cuotaActual. Este devuelve un objeto del tipo Jpanel*/
            
            //Se añade el nuevo panel al contenedor
            PanelCuotas.add(nuevoPanel);
            PanelCuotas.add(Box.createRigidArea(new Dimension(0, 10))); //Se establece el espacio entre cada panel

            // Se Aumenta la altura total
            alturaTotal += nuevoPanel.getPreferredSize().height + 10; //10 es el espacio entre paneles
        }

        // Se establece el tamaño preferido del PanelCuotas según la cantidad de paneles
        PanelCuotas.setPreferredSize(new java.awt.Dimension(PanelCuotas.getWidth(), alturaTotal));

        //Se actualiza la visualización del PanelCuotas, 
        PanelCuotas.revalidate();
        PanelCuotas.repaint();
    }

 
//Método para crear cada uno de los paneles individuales de las cuotas
private JPanel crearPanelCuota(String nombreCliente, String cedulaCliente, String estado) { //Recibe el nombre del cliente, su cédula, y el estado de la cuota.


        JPanel panelCuota = new JPanel(); //Se crea un nuevo panel y se establecen sus propiedades
        panelCuota.setBackground(new java.awt.Color(255, 255, 255));
        panelCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175)));
        panelCuota.setPreferredSize(new java.awt.Dimension(900, 150));
        
        //Se cambia a BoxLayout en vertical para el panel
        panelCuota.setLayout(new javax.swing.BoxLayout(panelCuota, javax.swing.BoxLayout.Y_AXIS));
         
        //Se Añade espacio vertical para centrar los elementos
        panelCuota.add(Box.createVerticalGlue());

        JPanel contenidoPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 0)); //Se centra horizontalmente el panel
        contenidoPanel.setOpaque(false); //Hacemos que el panel sea transparente para mantener el fondo del panel principal.

        JLabel labelNomCliente = new JLabel(nombreCliente);  //Se crea un jlabel pasándole el nombre del cliente. Y se establecen sus propiedades
        labelNomCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 23));
        labelNomCliente.setForeground(new java.awt.Color(102, 102, 102));
        labelNomCliente.setPreferredSize(new Dimension(350, 40));

        JLabel labelCedCliente = new JLabel(cedulaCliente);  //Se crea un jlabel pasándole la cedula del cliente. Y se establecen sus propiedades
        labelCedCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 23));
        labelCedCliente.setForeground(new java.awt.Color(102, 102, 102));
        labelCedCliente.setPreferredSize(new Dimension(160, 40));

        JLabel labelEstado = new JLabel(estado); //Se crea un jlabel pasándole el estado de la cuota. Y se establecen sus propiedades
        labelEstado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 23));
        labelEstado.setForeground(new java.awt.Color(102, 102, 102));
        labelEstado.setPreferredSize(new Dimension(190, 40));

        if (estado.equals("Proxima a vencer")){ //Si el estado de la cuota es proxima a vencer
            labelEstado.setForeground(Color.GREEN); //Se establece su color de fuente de color verde
        } //Si no, quiere decir que está vencida
        else{
            labelEstado.setForeground(Color.RED); //Se establece su color de fuente de color rojo.
        }

        //Se Agregan los labels al panel de contenido con espacio entre ellas
        contenidoPanel.add(labelNomCliente);
        contenidoPanel.add(labelCedCliente);
        contenidoPanel.add(labelEstado);

        //Se agrega el panel de contenido a panelCuota
        panelCuota.add(contenidoPanel);

        //Se añade espacio vertical para centrar los elementos
        panelCuota.add(Box.createVerticalGlue());
        
        panelCuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Se establece que el cursor sea hand cursor.

        //Se agrega un mouseListener para detectar clics
        panelCuota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                String CedulaCliente = labelCedCliente.getText(); //Al hacer clic en el panel de la cuota, se obtiene el texto del labelCedCliente y se almacena en una variable.
                VentanaCuotaCliente CuotaCliente = new VentanaCuotaCliente(CedulaCliente); //Se crea una instancia de VentanaCuotaCliente, pasandole esta variable como parametro.
                dispose(); //Se desecha la ventana actual
                CuotaCliente.setVisible(true); //Se hace visible la nueva ventana
               
            }
        });

        return panelCuota; //Se retorna el panelCuota
    }


 /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/                     
        private void initComponents() {

        PanelPrincipalCuotas = new javax.swing.JPanel();
        LabelEstadoCuotas = new javax.swing.JLabel();
        BarraBusqueda = new javax.swing.JTextField();
        LabelLupa = new javax.swing.JLabel();
        ScrollPaneCuotas = new javax.swing.JScrollPane();
        PanelCuotas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BotonRegresarEC = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Estado de Cuotas");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PanelPrincipalCuotas.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalCuotas.setPreferredSize(new java.awt.Dimension(1400, 800));

        LabelEstadoCuotas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); 
        LabelEstadoCuotas.setText("ESTADO DE CUOTAS");

        BarraBusqueda.setBackground(new java.awt.Color(245, 245, 245));
        BarraBusqueda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18));
        BarraBusqueda.setForeground(new java.awt.Color(102, 102, 102));
        BarraBusqueda.setText("Ingrese la cédula del cliente");
        BarraBusqueda.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        BarraBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarraBusquedaMouseClicked(evt);
            }
        });

        LabelLupa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelLupaMouseClicked(evt);
            }
        });

        ScrollPaneCuotas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175)));
        ScrollPaneCuotas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneCuotas.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPaneCuotas.setPreferredSize(new java.awt.Dimension(997, 500));

        PanelCuotas.setBackground(new java.awt.Color(245, 245, 245));
        PanelCuotas.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        PanelCuotas.setMaximumSize(new java.awt.Dimension(30000, 30000));
        PanelCuotas.setPreferredSize(new java.awt.Dimension(985, 1210));
        PanelCuotas.setRequestFocusEnabled(false);

        javax.swing.GroupLayout PanelCuotasLayout = new javax.swing.GroupLayout(PanelCuotas);
        PanelCuotas.setLayout(PanelCuotasLayout);
        PanelCuotasLayout.setHorizontalGroup(
            PanelCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        PanelCuotasLayout.setVerticalGroup(
            PanelCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );

        ScrollPaneCuotas.setViewportView(PanelCuotas);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );


        //Boton para regresar a la ventana de inicio del asesor.
        BotonRegresarEC.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        BotonRegresarEC.setText("← Regresar");
        BotonRegresarEC.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), null));
        BotonRegresarEC.setContentAreaFilled(false);
        BotonRegresarEC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresarEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarECActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalCuotasLayout = new javax.swing.GroupLayout(PanelPrincipalCuotas);
        PanelPrincipalCuotas.setLayout(PanelPrincipalCuotasLayout);
        PanelPrincipalCuotasLayout.setHorizontalGroup(
            PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalCuotasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonRegresarEC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                .addGroup(PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPaneCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                                .addComponent(LabelLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BarraBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(LabelEstadoCuotas)))
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                    .addGap(595, 595, 595)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(596, Short.MAX_VALUE)))
        );
        PanelPrincipalCuotasLayout.setVerticalGroup(
            PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(BotonRegresarEC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelEstadoCuotas)
                .addGap(71, 71, 71)
                .addGroup(PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ScrollPaneCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPrincipalCuotasLayout.createSequentialGroup()
                    .addGap(350, 350, 350)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalCuotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalCuotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                   

    //Al hacer clic en la barra de búsqueda se borra el texto que tiene por defecto.
    private void BarraBusquedaMouseClicked(java.awt.event.MouseEvent evt) {                                           
        BarraBusqueda.setText("");
    }                                          

//Al hacer clic en el botón regresar, se crea una nueva instancia de la clase VentanaInicioAsesor, se desecha la ventana actual y se hace visible la nueva ventana. 
    private void BotonRegresarECActionPerformed(java.awt.event.ActionEvent evt) {                                                
       VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
        this.dispose();
        VentanaAsesor.setVisible(true);
    }   


    /*Al hacer clic en la lupa, si el campo de texto "BarraBusqueda" está vacío, se abre una ventana emergente con un mensaje de error, lo mismo sucede en caso de que la cédula
    ingresada contenga alguna letra.*/
    private void LabelLupaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        if (BarraBusqueda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha ingresado ninguna cédula \nIntente nuevamente", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } else if(BarraBusqueda.getText().matches(".*[a-zA-Z]+.*")){ 
            JOptionPane.showMessageDialog(this, "La cédula ingresada contiene letras \nIntente nuevamente", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }  

        /*Si pasa estas dos verificaciones, entonces se crea una instancia de la clase ExistenciaCuotaCliente, y se ejecuta su método existenciaCuota, para verificar
        si existe alguna cuota relacionada a la cédula del cliente ingresada en la barra de búsqueda. De ser así, se crea una instancia de VentanaCuotaCliente pasándole la cédula 
        ingresada, se desecha la ventana actual y se hace visible la nueva ventana. De lo contrario, se abre una ventana emergente con un mensaje de error. */
            else{
                ExistenciaCuotaCliente ExistenciaCuota = new ExistenciaCuotaCliente();
                if (ExistenciaCuota.existenciaCuota(BarraBusqueda.getText())){
                VentanaCuotaCliente CuotaCliente = new VentanaCuotaCliente(BarraBusqueda.getText());
                dispose();
                CuotaCliente.setVisible(true);      
                }else{
                JOptionPane.showMessageDialog(this, "No se encontró al cliente de cédula " + BarraBusqueda.getText() + "\no este no tiene ninguna cuota","Mensaje de Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    }                                      

 
    //Metodo main definido por defecto por Netbeans
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCuotas().setVisible(true);
            }
        });
    }

    // Declaración de Variables                  
    private javax.swing.JTextField BarraBusqueda;
    private javax.swing.JLabel LabelEstadoCuotas;
    private javax.swing.JLabel LabelLupa;
    private javax.swing.JPanel PanelCuotas;
    private javax.swing.JPanel PanelPrincipalCuotas;
    private javax.swing.JScrollPane ScrollPaneCuotas;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton BotonRegresarEC;
    //Fin de la declaración de Variables             

}


