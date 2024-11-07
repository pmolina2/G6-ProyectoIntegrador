package Vista;

//Se importan las librerías necesarias, así como las clases que contiene el package controlador.
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
import CONTROLADOR.*;
import Dominio.*;



public class VerAptosAdmin extends javax.swing.JFrame {




//Se definen como atributos, un objeto del tipo ButtonGroup, y un ArrayList de objetos del tipo Apartamento. 
     private ButtonGroup buttonGroup;
     ArrayList <Apartamento> Apartamentos;

     FondoPanel2 fondo2 = new FondoPanel2();


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
    
    // Configurar el panel de fondo
    FondoPanel2 fondo2 = new FondoPanel2();
    fondo2.setLayout(new BorderLayout());
    
    // Agregar el panel principal al panel de fondo
    fondo2.add(PanelPrincipalAptos);  // Asegúrate que este sea el nombre de tu panel principal
    this.setContentPane(fondo2);
    
    // Hacer el panel principal transparente
    PanelPrincipalAptos.setOpaque(false);
    
    // Resto de las inicializaciones
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

        PanelPrincipalAptos = new javax.swing.JPanel();
        LabelApartamentos = new javax.swing.JLabel();
        LabelTorre = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        LabelInfo = new javax.swing.JLabel();
        LabelArea = new javax.swing.JLabel();
        LabelValor = new javax.swing.JLabel();
        LabelTipoUnidad = new javax.swing.JLabel();
        BotonRegresar1 = new javax.swing.JButton();
        BotonApto3 = new javax.swing.JToggleButton();
        BotonApto5 = new javax.swing.JToggleButton();
        BotonApto2 = new javax.swing.JToggleButton();
        BotonApto4 = new javax.swing.JToggleButton();
        BotonApto1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Visualizacion Aptos");
        setResizable(false);

        PanelPrincipalAptos.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalAptos.setPreferredSize(new java.awt.Dimension(1400, 800));

        LabelApartamentos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 35)); // NOI18N
        LabelApartamentos.setText("  APARTAMENTOS");

        LabelTorre.setBackground(new java.awt.Color(240, 240, 240));
        LabelTorre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelTorre.setText("TORRE: ");
        LabelTorre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        PanelInfo.setBackground(new java.awt.Color(238, 238, 238));
        PanelInfo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        LabelInfo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 29)); // NOI18N
        LabelInfo.setText("ⓘ INFORMACIÓN DE LOS APTOS");

        LabelArea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelArea.setText("AREA: ");

        LabelValor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelValor.setText("VALOR: ");

        LabelTipoUnidad.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        LabelTipoUnidad.setText("TIPO DE UNIDAD: ");

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTipoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(LabelInfo)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(LabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LabelTipoUnidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        BotonRegresar1.setBackground(new java.awt.Color(240, 240, 240));
        BotonRegresar1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonRegresar1.setText("← Regresar");
        BotonRegresar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonRegresar1.setContentAreaFilled(false);
        BotonRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresar1ActionPerformed(evt);
            }
        });

        BotonApto3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto3ActionPerformed(evt);
            }
        });

        BotonApto5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto5ActionPerformed(evt);
            }
        });

        BotonApto2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto2ActionPerformed(evt);
            }
        });

        BotonApto4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto4ActionPerformed(evt);
            }
        });

        BotonApto1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BotonApto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonApto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonApto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalAptosLayout = new javax.swing.GroupLayout(PanelPrincipalAptos);
        PanelPrincipalAptos.setLayout(PanelPrincipalAptosLayout);
        PanelPrincipalAptosLayout.setHorizontalGroup(
            PanelPrincipalAptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalAptosLayout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(PanelPrincipalAptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonApto2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonApto5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(201, 201, 201)
                .addGroup(PanelPrincipalAptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTorre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(PanelPrincipalAptosLayout.createSequentialGroup()
                .addGroup(PanelPrincipalAptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAptosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BotonRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalAptosLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(LabelApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalAptosLayout.setVerticalGroup(
            PanelPrincipalAptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalAptosLayout.createSequentialGroup()
                .addGroup(PanelPrincipalAptosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalAptosLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(LabelTorre, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(BotonRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalAptosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(LabelApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonApto5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalAptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalAptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }


    private void BotonRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {      

    

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
    private javax.swing.JButton BotonRegresar1;
    private javax.swing.JLabel LabelApartamentos;
    private javax.swing.JLabel LabelArea;
    private javax.swing.JLabel LabelInfo;
    private javax.swing.JLabel LabelTipoUnidad;
    private javax.swing.JLabel LabelTorre;
    private javax.swing.JLabel LabelValor;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelPrincipalAptos;
    // Fin de declaración de Variables


class FondoPanel2 extends JPanel {
    private Image imagen;
    
    public FondoPanel2() {
        imagen = new ImageIcon(getClass().getResource("/Iconos/Plantilla.png")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
}





