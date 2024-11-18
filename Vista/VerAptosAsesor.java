package Vista;

/*En esta ventana se pueden visualizar todos los apartamentos de una torre específica seleccionada previamente. Se pueden además ver las características de cada uno
e incluso seleccionarlo para la venta si así se desea.*/


//Se importan todas las librerías necesarias, además de las clases que contiene el package controlador y la clases que contiene el package dominio. 
import CONTROLADOR.*;
import Dominio.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class VerAptosAsesor extends javax.swing.JFrame {

//Se definen como atributos, un objeto del tipo ButtonGroup, un ArrayList de objetos del tipo Apartamento, y un objeto del tipo Apartamento.
    private ButtonGroup buttonGroup;
    ArrayList <Apartamento> Apartamentos;
    Apartamento AptoElegido;


/*Método que inicializa la clase. Primero se inicializan los componentes, 
luego se crea una instancia del tipo FondoPanel, y se establece su layout, luego a este panel se le agrega el panel principal del jframe, y usando
setContentPane hacemos que el fondo sea el fondo3. Posteriormente se establece que PanelPrincipalAptosAs sea transparente.
Después se establece el icono del Jframe, utilizando el método SetIconImage y la imagen "Logo Ventana" que 
se encuentra en la carpeta Iconos. Posteriormente se establece que LabelTorreAs sea opaco, y su texto sea el número de la torre pasada como parámetro. Luego se crea un objeto
de la clase ButtonGroup, y se le añaden todos los botones que representan apartamentos, esto con el fin de hacer que solo se pueda presionar un botón a la vez. Luego se llama
al método ActualizarAparienciaBoton(), y se crea un objeto del tipo "ConsultarApartamento" para ejecutar su método devolverApartamentos pasándole como parámetro 
el id de la torre, así como el nombre y contraseña del usuario de la base de datos, que en este aso es "asesorg6" y "asesor" respectivamente. 
Este devuelve un ArrayList de objetos del tipo apartamento, que se asigna al atributo "Apartamentos" de la clase. 
Por último, se establece el texto de los botones de los apartamentos, usando el número del Apartamento correspondiente de la lista. Por ejemplo, Para el 
BotonApto1As, se asigna el número del apartamento en la posición 0. 
*/

    public VerAptosAsesor(Torre torre) {
        initComponents();

        FondoPanel fondo3 = new FondoPanel();
        fondo3.setLayout(new BorderLayout());

         // Agregar el panel principal al panel de fondo
        fondo3.add(PanelPrincipalAptosAs);  
        this.setContentPane(fondo3);

        PanelPrincipalAptosAs.setOpaque(false);

        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        LabelTorreAs.setOpaque(true); 
        LabelTorreAs.setText("TORRE: " + torre.getNumTorre().toUpperCase());
        buttonGroup = new ButtonGroup();
        buttonGroup.add(BotonApto1As);
        buttonGroup.add(BotonApto2As);
        buttonGroup.add(BotonApto3As);
        buttonGroup.add(BotonApto4As);
        buttonGroup.add(BotonApto5As);
        ActualizarAparienciaBoton();
        ConsultarApartamento ConsultaApto = new ConsultarApartamento();
        this.Apartamentos = ConsultaApto.devolverApartamentos(torre.getId(), "asesorg6", "asesor");
        BotonApto1As.setText(Apartamentos.get(0).getNumApto());
        BotonApto2As.setText(Apartamentos.get(1).getNumApto());
        BotonApto3As.setText(Apartamentos.get(2).getNumApto());
        BotonApto4As.setText(Apartamentos.get(3).getNumApto());
        BotonApto5As.setText(Apartamentos.get(4).getNumApto());
    }


//Este método se usa para actualizar la apariencia de "BotonVender", dependiendo de si está o no habilitado.
    private void ActualizarAparienciaBoton() {
        if (!BotonVender.isEnabled()) {  //Si el botón está inhabilitado, el color de fondo será gris, y el color del texto negro.
            BotonVender.setBackground(Color.GRAY); 
            BotonVender.setForeground(new Color(100,100,100)); 
        } else {
            BotonVender.setBackground(new Color(0, 51, 102)); //Si el botón está habilitado, el color de fondo será azul, y el color del texto blanco.
            BotonVender.setForeground(Color.WHITE); 
        }
        BotonVender.repaint(); //Al final, se "refresca" la apariencia gráfica del botón. 
    }



 /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/
       private void initComponents() {

        PanelPrincipalAptosAs = new javax.swing.JPanel();
        LabelApartamentosAs = new javax.swing.JLabel();
        LabelTorreAs = new javax.swing.JLabel();
        PanelInfoAs = new javax.swing.JPanel();
        LabelInfoAs = new javax.swing.JLabel();
        LabelAreaAs = new javax.swing.JLabel();
        LabelValorAs = new javax.swing.JLabel();
        LabelTipoUnidadAs = new javax.swing.JLabel();
        BotonVender = new javax.swing.JButton();
        BotonRegresar2 = new javax.swing.JButton();
        BotonApto3As = new javax.swing.JToggleButton();
        BotonApto5As = new javax.swing.JToggleButton();
        BotonApto2As = new javax.swing.JToggleButton();
        BotonApto4As = new javax.swing.JToggleButton();
        BotonApto1As = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPU - Apartamentos");
        setResizable(false);

        PanelPrincipalAptosAs.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalAptosAs.setPreferredSize(new java.awt.Dimension(1400, 800));

        LabelApartamentosAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); // NOI18N
        LabelApartamentosAs.setText("  APARTAMENTOS");

        LabelTorreAs.setBackground(new java.awt.Color(240, 240, 240));
        LabelTorreAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelTorreAs.setText("TORRE: ");
        LabelTorreAs.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        PanelInfoAs.setBackground(new java.awt.Color(238, 238, 238));
        PanelInfoAs.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        LabelInfoAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelInfoAs.setText("ⓘ INFORMACIÓN DE LOS APTOS");

        LabelAreaAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelAreaAs.setText("AREA: ");

        LabelValorAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelValorAs.setText("VALOR: ");

        LabelTipoUnidadAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelTipoUnidadAs.setText("TIPO DE UNIDAD: ");

        javax.swing.GroupLayout PanelInfoAsLayout = new javax.swing.GroupLayout(PanelInfoAs);
        PanelInfoAs.setLayout(PanelInfoAsLayout);
        PanelInfoAsLayout.setHorizontalGroup(
            PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoAsLayout.createSequentialGroup()
                .addGroup(PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfoAsLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTipoUnidadAs, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelValorAs, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelAreaAs, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelInfoAsLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(LabelInfoAs)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        PanelInfoAsLayout.setVerticalGroup(
            PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoAsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LabelInfoAs, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(LabelValorAs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LabelTipoUnidadAs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelAreaAs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        //Boton que redirige al asesor a la ventana de registrar una venta
        BotonVender.setBackground(new java.awt.Color(0, 51, 102));
        BotonVender.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 21)); 
        BotonVender.setForeground(new java.awt.Color(255, 255, 255));
        BotonVender.setText("VENDER ESTE APARTAMENTO");
        BotonVender.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        BotonVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonVender.setEnabled(false);
        BotonVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVenderActionPerformed(evt);
            }
        });

        //Boton para regresar a la ventana anterior, que en este caso sería la ventana de las torres para el asesor.
        BotonRegresar2.setBackground(new java.awt.Color(240, 240, 240));
        BotonRegresar2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); 
        BotonRegresar2.setText("← Regresar");
        BotonRegresar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonRegresar2.setContentAreaFilled(false);
        BotonRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresar2ActionPerformed(evt);
            }
        });

        BotonApto3As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); 
        BotonApto3As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto3As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto3AsActionPerformed(evt);
            }
        });

        BotonApto5As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto5As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto5As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto5AsActionPerformed(evt);
            }
        });

        BotonApto2As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto2As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto2As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto2AsActionPerformed(evt);
            }
        });

        BotonApto4As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto4As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto4As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto4AsActionPerformed(evt);
            }
        });

        BotonApto1As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto1As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto1As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto1AsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalAptosAsLayout = new javax.swing.GroupLayout(PanelPrincipalAptosAs);
        PanelPrincipalAptosAs.setLayout(PanelPrincipalAptosAsLayout);
        PanelPrincipalAptosAsLayout.setHorizontalGroup(
            PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalAptosAsLayout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addGroup(PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonApto2As, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto1As, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto3As, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto4As, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto5As, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelInfoAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTorreAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalAptosAsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonVender, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))))
            .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                .addGroup(PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BotonRegresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(LabelApartamentosAs, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalAptosAsLayout.setVerticalGroup(
            PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                .addGroup(PanelPrincipalAptosAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(LabelTorreAs, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelInfoAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(BotonVender, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(BotonRegresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalAptosAsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(LabelApartamentosAs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto1As, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto2As, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto3As, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto4As, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto5As, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalAptosAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalAptosAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }                     


    //Este método unicamente sirve para habilitar el "BotonVender", y actualizar su apariencia.
    private void habilitarBotonVender() {
        BotonVender.setEnabled(true);
        ActualizarAparienciaBoton();
    }                               


/*Al dar clic en el "BotonVender", se crea una instancia de la clase ConsultarMatriculaApto, luego, se valida si al ejecutar su método consultarMatricula, pasándole como
parámetro la matrícula del apartamento elegido, si retorna algún valor quiere decir que se encontró la matrícula de dicho apartamento en una venta, por lo tanto
se abre una ventana emergente que informa al usuario que este apartamento ya se vendió. Si por el contrario, retorna "false", entonces se crea una instancia de
VentanaRegistroVenta, pasándole como parámetro el apartamento elegido, se desecha la ventana actual y se hace visible la nueva ventana.*/

    private void BotonVenderActionPerformed(java.awt.event.ActionEvent evt) {

        ConsultarMatriculaApto ConsultaMatricula = new ConsultarMatriculaApto();
      
        if (ConsultaMatricula.consultarMatricula(AptoElegido.getMatricula())) { 
            JOptionPane.showMessageDialog(this, "Error: Este apartamento ya se vendió, \nintente con otro distinto", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }else{
            VentanaRegistroVenta VentanaVenta = new VentanaRegistroVenta(AptoElegido);
            this.dispose();
            VentanaVenta.setVisible(true);
        }
    }


//Al presionar el botón regresar, se crea una nueva instancia de VentanaTorresAsesor, se desecha la ventana actual y se hace visible la nueva ventana.
    private void BotonRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {   
        VentanaTorresAsesor VentanaTorresAs = new VentanaTorresAsesor();
        this.dispose();
        VentanaTorresAs.setVisible(true);

    }      


/*Al presionar cualquiera de los botones, se muestra la información del Apartamento que representan. Se establece el texto de LabelAreaAs, usando el método "getArea" del objeto
del tipo "Apartamento", luego, se establece el texto de LabelValorAs, utilizando el método getValorApto de este mismo objeto, y por último el tipo de unidad, siguiendo el 
mismo proceso. El objeto Apartamento del cual se obtienen estos datos cambia dependiendo del botón, por ejemplo, en el caso de BotonApto1As, se usan los datos del primer
apartamento en el ArrayList "Apartamentos", que es un atributo de la clase. Luego, se establece el valor del atributo "AptoElegido" teniendo en cuenta también cual botón
fue el que se presionó*/
    private void BotonApto1AsActionPerformed(java.awt.event.ActionEvent evt) {    
        habilitarBotonVender();                                     
        LabelAreaAs.setText("AREA: " + Apartamentos.get(0).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(0).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(0).getTipoUnidad()); 
        AptoElegido = Apartamentos.get(0);
    }                                            

    
    private void BotonApto2AsActionPerformed(java.awt.event.ActionEvent evt) {  
        habilitarBotonVender();                                             
        LabelAreaAs.setText("AREA: " + Apartamentos.get(1).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(1).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(1).getTipoUnidad());
        AptoElegido = Apartamentos.get(1);
    }   

      private void BotonApto3AsActionPerformed(java.awt.event.ActionEvent evt) {   
        habilitarBotonVender();                                            
        LabelAreaAs.setText("AREA: " + Apartamentos.get(2).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(2).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(2).getTipoUnidad());
        AptoElegido = Apartamentos.get(2);
    }   

    private void BotonApto4AsActionPerformed(java.awt.event.ActionEvent evt) {      
         habilitarBotonVender();                                         
        LabelAreaAs.setText("AREA: " + Apartamentos.get(3).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(3).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(3).getTipoUnidad());
        AptoElegido = Apartamentos.get(3);
    }                                            
                                         

    private void BotonApto5AsActionPerformed(java.awt.event.ActionEvent evt) { 
        habilitarBotonVender();                                              
        LabelAreaAs.setText("AREA: " + Apartamentos.get(4).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(4).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(4).getTipoUnidad());
        AptoElegido = Apartamentos.get(4);
    }                                            

                                           

//Método main definido por defecto por NetBeans.
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerAptosAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAptosAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAptosAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAptosAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Declaración de Variables                    
     private javax.swing.JToggleButton BotonApto1As;
    private javax.swing.JToggleButton BotonApto2As;
    private javax.swing.JToggleButton BotonApto3As;
    private javax.swing.JToggleButton BotonApto4As;
    private javax.swing.JToggleButton BotonApto5As;
    private javax.swing.JButton BotonRegresar2;
    private javax.swing.JButton BotonVender;
    private javax.swing.JLabel LabelApartamentosAs;
    private javax.swing.JLabel LabelAreaAs;
    private javax.swing.JLabel LabelInfoAs;
    private javax.swing.JLabel LabelTipoUnidadAs;
    private javax.swing.JLabel LabelTorreAs;
    private javax.swing.JLabel LabelValorAs;
    private javax.swing.JPanel PanelInfoAs;
    private javax.swing.JPanel PanelPrincipalAptosAs;
    // Fin de Declaración de Variables.    

}
