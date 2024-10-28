package Vista;

//Se importan las librerías necesarias, así como las clases que contiene el package controlador.
import javax.swing.ImageIcon;
import CONTROLADOR.*;
import java.util.ArrayList;
import javax.swing.ButtonGroup;



public class VerAptosAdmin extends javax.swing.JFrame {

//Se definen como atributos, un objeto del tipo ButtonGroup, y un ArrayList de objetos del tipo Apartamento. 
     private ButtonGroup buttonGroup;
     ArrayList <Apartamento> Apartamentos;


/*Método que inicializa la clase. Primero se inicializan los componentes, luego se establece el icono del Jframe, utilizando el método SetIconImage y la imagen "Logo Ventana" que 
se encuentra en la carpeta Iconos. Posteriormente se establece que LabelTorre sea opaco, y su texto sea el número de la torre pasada como parámetro. Luego se crea un objeto
de la clase ButtonGroup, y se añaden todos los botones que representan apartamentos, esto con el fin de hacer que solo se pueda presionar un botón a la vez. Después, se crea un
un objeto del tipo "ConsultarApartamento" y se ejecuta su método devolverApartamentos pasándole como parámetro el id de la torre pasada como parámetro. Este devuelve un ArrayList 
de objetos del tipo apartamento, que se asigna al atributo "Apartamentos" de la clase. 
Por último, se establece el texto de los botones de los apartamentos, usando el número del Apartamento correspondiente de la lista. Por ejemplo, Para el 
BotonApto1, se asigna el número del apartamento en la posición 0. 
*/

    public VerAptosAdmin(Torre torre) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        LabelTorre.setOpaque(true); 
        LabelTorre.setText("TORRE: " + torre.getNumTorre().toUpperCase());
        buttonGroup = new ButtonGroup();
        buttonGroup.add(BotonApto1);
        buttonGroup.add(BotonApto2);
        buttonGroup.add(BotonApto3);
        buttonGroup.add(BotonApto4);
        buttonGroup.add(BotonApto5);
        ConsultarApartamento ConsultaApto = new ConsultarApartamento();
        this.Apartamentos = ConsultaApto.devolverApartamentos(torre.getId());
        BotonApto1.setText(Apartamentos.get(0).getNumApto());
        BotonApto2.setText(Apartamentos.get(1).getNumApto());
        BotonApto3.setText(Apartamentos.get(2).getNumApto());
        BotonApto4.setText(Apartamentos.get(3).getNumApto());
        BotonApto5.setText(Apartamentos.get(4).getNumApto());

    }


 /* Método que inicializa todos los componentes que va a contener el Jframe, como los labels, botones, campos de texto, entre otros.*/
    private void initComponents() {

        PanelPrincipalVenta = new javax.swing.JPanel();
        LabelApartamentos = new javax.swing.JLabel();
        LabelTorre = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        LabelInfo = new javax.swing.JLabel();
        LabelArea = new javax.swing.JLabel();
        LabelValor = new javax.swing.JLabel();
        LabelTipoUnidad = new javax.swing.JLabel();
        BotonApto1 = new javax.swing.JToggleButton();
        BotonApto4 = new javax.swing.JToggleButton();
        BotonApto2 = new javax.swing.JToggleButton();
        BotonApto5 = new javax.swing.JToggleButton();
        BotonApto3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Visualización de Aptos");
        setResizable(false);

        PanelPrincipalVenta.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalVenta.setPreferredSize(new java.awt.Dimension(1400, 800));

        LabelApartamentos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); // NOI18N
        LabelApartamentos.setText("  APARTAMENTOS");

        LabelTorre.setBackground(new java.awt.Color(240, 240, 240));
        LabelTorre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 22)); // NOI18N
        LabelTorre.setText("TORRE: ");
        LabelTorre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        PanelInfo.setBackground(new java.awt.Color(238, 238, 238));
        PanelInfo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        LabelInfo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 29)); // NOI18N
        LabelInfo.setText("ⓘ INFORMACIÓN DE LOS APTOS");

        LabelArea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelArea.setText("AREA: ");

        LabelValor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelValor.setText("VALOR: ");

        LabelTipoUnidad.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        LabelTipoUnidad.setText("TIPO DE UNIDAD: ");

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelInfo)
                    .addComponent(LabelTipoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(LabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LabelTipoUnidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );


        BotonApto1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto1ActionPerformed(evt);
            }
        });

        BotonApto4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto4ActionPerformed(evt);
            }
        });

        BotonApto2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto2ActionPerformed(evt);
            }
        });

        BotonApto5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto5ActionPerformed(evt);
            }
        });

        BotonApto3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto3ActionPerformed(evt);
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
                        .addComponent(LabelApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonApto4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonApto3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTorre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalVentaLayout.setVerticalGroup(
            PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(LabelApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addComponent(LabelTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(PanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addGap(40, 40, 40))
                    .addGroup(PanelPrincipalVentaLayout.createSequentialGroup()
                        .addComponent(BotonApto1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
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


    /*Al presionar cualquiera de los botones, se muestra la información del Apartamento que representan. Se establece el texto de LabelArea, usando el método "getArea" del objeto
    del tipo "Apartamento", luego, se establece el texto de LabelValor, utilizando el método getValorApto de este mismo objeto, y por último el tipo de unidad, siguiendo el mismo
    proceso. El objeto Apartamento del cual se obtienen estos datos cambia dependiendo del botón, por ejemplo, en el caso de BotonApto1, se usan los datos del primer
    apartamento en el ArrayList "Apartamentos", que es un atributo de la clase.*/

    private void BotonApto1ActionPerformed(java.awt.event.ActionEvent evt) {  
        LabelArea.setText("AREA: " + Apartamentos.get(0).getArea() + "m2");
        LabelValor.setText("VALOR: $" + String.valueOf(Apartamentos.get(0).getValorApto()).toUpperCase());
        LabelTipoUnidad.setText("TIPO UNIDAD: " + Apartamentos.get(0).getTipoUnidad());
    }                                           

    private void BotonApto2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        LabelArea.setText("AREA: " + Apartamentos.get(1).getArea() + "m2");
        LabelValor.setText("VALOR: $" + String.valueOf(Apartamentos.get(1).getValorApto()).toUpperCase());
        LabelTipoUnidad.setText("TIPO UNIDAD: " + Apartamentos.get(1).getTipoUnidad());
    
    }

    private void BotonApto3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        LabelArea.setText("AREA: " + Apartamentos.get(2).getArea() + "m2");
        LabelValor.setText("VALOR: $" + String.valueOf(Apartamentos.get(2).getValorApto()).toUpperCase());
        LabelTipoUnidad.setText("TIPO UNIDAD: " + Apartamentos.get(2).getTipoUnidad());
    }                                           

    private void BotonApto4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        LabelArea.setText("AREA: " + Apartamentos.get(3).getArea() + "m2");
        LabelValor.setText("VALOR: $" + String.valueOf(Apartamentos.get(3).getValorApto()).toUpperCase());
        LabelTipoUnidad.setText("TIPO UNIDAD: " + Apartamentos.get(3).getTipoUnidad());
    }

    private void BotonApto5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        LabelArea.setText("AREA: " + Apartamentos.get(4).getArea() + "m2");
        LabelValor.setText("VALOR: $" + String.valueOf(Apartamentos.get(4).getValorApto()).toUpperCase());
        LabelTipoUnidad.setText("TIPO UNIDAD: " + Apartamentos.get(4).getTipoUnidad());
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
            java.util.logging.Logger.getLogger(VerAptosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAptosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAptosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAptosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }
    // Declaración de Variables
    private javax.swing.JToggleButton BotonApto1;
    private javax.swing.JToggleButton BotonApto2;
    private javax.swing.JToggleButton BotonApto3;
    private javax.swing.JToggleButton BotonApto4;
    private javax.swing.JToggleButton BotonApto5;

    private javax.swing.JLabel LabelApartamentos;
    private javax.swing.JLabel LabelArea;
    private javax.swing.JLabel LabelInfo;
    private javax.swing.JLabel LabelTipoUnidad;
    private javax.swing.JLabel LabelTorre;
    private javax.swing.JLabel LabelValor;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelPrincipalVenta;
    // Fin de declaración de Variables
}
