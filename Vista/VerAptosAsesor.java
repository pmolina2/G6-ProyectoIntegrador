
package Vista;


//Se importan las librerías necesarias, así como las clases que contiene el package controlador.
import java.awt.Color;
import javax.swing.ImageIcon;
import CONTROLADOR.*;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class VerAptosAsesor extends javax.swing.JFrame {

//Se definen como atributos, un objeto del tipo ButtonGroup, y un ArrayList de objetos del tipo Apartamento. 
    private ButtonGroup buttonGroup;
    ArrayList <Apartamento> Apartamentos;


/*Método que inicializa la clase. Primero se inicializan los componentes, luego se establece el icono del Jframe, utilizando el método SetIconImage y la imagen "Logo Ventana" que 
se encuentra en la carpeta Iconos. Posteriormente se establece que LabelTorreAs sea opaco, y su texto sea el número de la torre pasada como parámetro. Luego se crea un objeto
de la clase ButtonGroup, y se añaden todos los botones que representan apartamentos, esto con el fin de hacer que solo se pueda presionar un botón a la vez. Después, se crea un
un objeto del tipo "ConsultarApartamento" y se ejecuta su método devolverApartamentos pasándole como parámetro el id de la torre pasada como parámetro. Este devuelve un ArrayList 
de objetos del tipo apartamento, que se asigna al atributo "Apartamentos" de la clase. 
Por último, se establece el texto de los botones de los apartamentos, usando el número del Apartamento correspondiente de la lista. Por ejemplo, Para el 
BotonApto1As, se asigna el número del apartamento en la posición 0. 
*/

    public VerAptosAsesor(Torre torre) {
        initComponents();
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
        this.Apartamentos = ConsultaApto.devolverApartamentos(torre.getId());
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
        BotonVender.repaint(); //Se "refresca" la apariencia gráfica del botón. 
    }



 /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.  */
       private void initComponents() {

        PanelPrincipalVenta = new javax.swing.JPanel();
        LabelApartamentosAs = new javax.swing.JLabel();
        LabelTorreAs = new javax.swing.JLabel();
        PanelInfoAs = new javax.swing.JPanel();
        LabelInfoAs = new javax.swing.JLabel();
        LabelAreaAs = new javax.swing.JLabel();
        LabelValorAs = new javax.swing.JLabel();
        LabelTipoUnidadAs = new javax.swing.JLabel();
        BotonVender = new javax.swing.JButton();
        BotonApto1As = new javax.swing.JToggleButton();
        BotonApto4As = new javax.swing.JToggleButton();
        BotonApto2As = new javax.swing.JToggleButton();
        BotonApto5As = new javax.swing.JToggleButton();
        BotonApto3As = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Visualizacion Aptos");
        setResizable(false);

        PanelPrincipalVenta.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalVenta.setPreferredSize(new java.awt.Dimension(1400, 800));

        LabelApartamentosAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); // NOI18N
        LabelApartamentosAs.setText("  APARTAMENTOS");

        LabelTorreAs.setBackground(new java.awt.Color(240, 240, 240));
        LabelTorreAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 22)); // NOI18N
        LabelTorreAs.setText("TORRE: ");
        LabelTorreAs.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        PanelInfoAs.setBackground(new java.awt.Color(238, 238, 238));
        PanelInfoAs.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        LabelInfoAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 29)); // NOI18N
        LabelInfoAs.setText("ⓘ INFORMACIÓN DE LOS APTOS");

        LabelAreaAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelAreaAs.setText("AREA: ");

        LabelValorAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelValorAs.setText("VALOR: ");

        LabelTipoUnidadAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelTipoUnidadAs.setText("TIPO DE UNIDAD: ");

        javax.swing.GroupLayout PanelInfoAsLayout = new javax.swing.GroupLayout(PanelInfoAs);
        PanelInfoAs.setLayout(PanelInfoAsLayout);
        PanelInfoAsLayout.setHorizontalGroup(
            PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoAsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelInfoAs)
                    .addComponent(LabelTipoUnidadAs, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelValorAs, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelAreaAs, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        PanelInfoAsLayout.setVerticalGroup(
            PanelInfoAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoAsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelInfoAs, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(LabelValorAs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LabelTipoUnidadAs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelAreaAs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        BotonVender.setBackground(new java.awt.Color(0, 51, 102));
        BotonVender.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
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


        BotonApto1As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto1As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto1As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto1AsActionPerformed(evt);
            }
        });

        BotonApto4As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto4As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto4As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto4AsActionPerformed(evt);
            }
        });

        BotonApto2As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto2As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto2As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto2AsActionPerformed(evt);
            }
        });

        BotonApto5As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto5As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto5As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto5AsActionPerformed(evt);
            }
        });

        BotonApto3As.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto3As.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto3As.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto3AsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalVentaLayout = new javax.swing.GroupLayout(PanelPrincipalVenta);
        PanelPrincipalVenta.setLayout(PanelPrincipalVentaLayout);
        PanelPrincipalVentaLayout.setHorizontalGroup(
            PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalVentaLayout.createSequentialGroup()
                .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(LabelApartamentosAs, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonApto4As, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto1As, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto2As, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto5As, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto3As, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelInfoAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalVentaLayout.createSequentialGroup()
                        .addComponent(BotonVender, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addComponent(LabelTorreAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalVentaLayout.setVerticalGroup(
            PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(LabelApartamentosAs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addComponent(LabelTorreAs, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(PanelInfoAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(BotonVender, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGap(40, 40, 40))
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addComponent(BotonApto1As, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto2As, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto3As, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto4As, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto5As, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }                      


//Este método unicamente sirve para habilitar el "BotonVender", y actualizar su apariencia.
    private void habilitarBotonVender() {
    BotonVender.setEnabled(true);
    ActualizarAparienciaBoton();
}                               

/*Al dar clic en el "BotonVender", se abre una ventana emergente con un mensaje, que le indica al usuario que esta ventana todavía no está habilitada. (Esto debido a que no se 
implementó para esta segunda entrega).*/
   private void BotonVenderActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "Lo sentimos, esta ventana esta en construcción","Mensaje de Información", JOptionPane.INFORMATION_MESSAGE);
    }


/*Al presionar cualquiera de los botones, se muestra la información del Apartamento que representan. Se establece el texto de LabelAreaAs, usando el método "getArea" del objeto
    del tipo "Apartamento", luego, se establece el texto de LabelValorAs, utilizando el método getValorApto de este mismo objeto, y por último el tipo de unidad, siguiendo el 
    mismo proceso. El objeto Apartamento del cual se obtienen estos datos cambia dependiendo del botón, por ejemplo, en el caso de BotonApto1As, se usan los datos del primer
    apartamento en el ArrayList "Apartamentos", que es un atributo de la clase.*/

    private void BotonApto1AsActionPerformed(java.awt.event.ActionEvent evt) {    
        habilitarBotonVender();                                     
        LabelAreaAs.setText("AREA: " + Apartamentos.get(0).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(0).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(0).getTipoUnidad()); 
    }                                            

    
    private void BotonApto2AsActionPerformed(java.awt.event.ActionEvent evt) {  
        habilitarBotonVender();                                             
        LabelAreaAs.setText("AREA: " + Apartamentos.get(1).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(1).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(1).getTipoUnidad());
    }   

      private void BotonApto3AsActionPerformed(java.awt.event.ActionEvent evt) {   
        habilitarBotonVender();                                            
        LabelAreaAs.setText("AREA: " + Apartamentos.get(2).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(2).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(2).getTipoUnidad());
    }   

    private void BotonApto4AsActionPerformed(java.awt.event.ActionEvent evt) {      
         habilitarBotonVender();                                         
        LabelAreaAs.setText("AREA: " + Apartamentos.get(3).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(3).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(3).getTipoUnidad());
    }                                            
                                         

    private void BotonApto5AsActionPerformed(java.awt.event.ActionEvent evt) { 
        habilitarBotonVender();                                              
        LabelAreaAs.setText("AREA: " + Apartamentos.get(4).getArea() + "m2");
        LabelValorAs.setText("VALOR: $" + String.valueOf(Apartamentos.get(4).getValorApto()).toUpperCase());
        LabelTipoUnidadAs.setText("TIPO UNIDAD: " + Apartamentos.get(4).getTipoUnidad());
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
    private javax.swing.JButton BotonVender;
    private javax.swing.JLabel LabelApartamentosAs;
    private javax.swing.JLabel LabelAreaAs;
    private javax.swing.JLabel LabelInfoAs;
    private javax.swing.JLabel LabelTipoUnidadAs;
    private javax.swing.JLabel LabelTorreAs;
    private javax.swing.JLabel LabelValorAs;
    private javax.swing.JPanel PanelInfoAs;
    private javax.swing.JPanel PanelPrincipalVenta;
    // Fin de Declaración de Variables.                 
}
