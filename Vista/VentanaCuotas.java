
package Vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;  // Para usar Swing components like JLabel and JTextField
import java.awt.*;

public class VentanaCuotas extends javax.swing.JFrame {

 
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
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoLupa.png")).getImage().getScaledInstance(LabelLupa.getWidth(), LabelLupa.getHeight(), 0));
        LabelLupa.setIcon(miIcono);
        PanelCuotas.setLayout(new javax.swing.BoxLayout(PanelCuotas, javax.swing.BoxLayout.Y_AXIS));
        agregarPanelesCuota(10);
        
        
        //Mover esta parte al initcomponents
        LabelLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    
    private void agregarPanelesCuota(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
        JPanel nuevoPanel = crearPanelCuota("Pierre Angelo Molina Motta " + (i + 1), "CC " + (1097493167 + i), "VENCIDA");
        PanelCuotas.add(nuevoPanel);
        // Añadir un strut para el espacio entre paneles
        PanelCuotas.add(Box.createRigidArea(new Dimension(0, 10))); // 10 píxeles de separación vertical
    }
    // Actualiza el tamaño del PanelCuotas para que incluya todos los paneles
    PanelCuotas.revalidate();
    PanelCuotas.repaint();
}
    


private JPanel crearPanelCuota(String nombreCliente, String cedulaCliente, String estado) {
        JPanel panelCuota = new JPanel();
        panelCuota.setBackground(new java.awt.Color(255, 255, 255));
        panelCuota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175)));
        panelCuota.setPreferredSize(new java.awt.Dimension(900, 150));
        
        // Cambiar a BoxLayout en vertical para el panel
        panelCuota.setLayout(new javax.swing.BoxLayout(panelCuota, javax.swing.BoxLayout.Y_AXIS));
        
        // Añadir espacio vertical para centrar los elementos
        panelCuota.add(Box.createVerticalGlue());

        JPanel contenidoPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 70, 0)); // centrar horizontalmente
        contenidoPanel.setOpaque(false); // hacer que el panel sea transparente para mantener el fondo del panel principal

        JLabel labelNomCliente = new JLabel(nombreCliente);
        labelNomCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25));
        labelNomCliente.setForeground(new java.awt.Color(102, 102, 102));
        labelNomCliente.setPreferredSize(new Dimension(350, 40));

        JLabel labelCedCliente = new JLabel(cedulaCliente);
        labelCedCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25));
        labelCedCliente.setForeground(new java.awt.Color(102, 102, 102));
        labelCedCliente.setPreferredSize(new Dimension(200, 40));

        JLabel labelEstado = new JLabel(estado);
        labelEstado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25));
        labelEstado.setForeground(new java.awt.Color(102, 102, 102));
        labelEstado.setPreferredSize(new Dimension(120, 40));
        labelEstado.setForeground(Color.RED);

        // Agregar etiquetas al panel de contenido con espacio entre ellas
        contenidoPanel.add(labelNomCliente);
        contenidoPanel.add(labelCedCliente);
        contenidoPanel.add(labelEstado);

        // Agregar el panel de contenido a panelCuota
        panelCuota.add(contenidoPanel);

        // Añadir espacio vertical para centrar los elementos
        panelCuota.add(Box.createVerticalGlue());
        
        panelCuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Agregar un MouseListener para detectar clics
        panelCuota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VentanaCuotaCliente CuotaCliente = new VentanaCuotaCliente();
                dispose();
                CuotaCliente.setVisible(true);
               
            }
        });

        return panelCuota;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelPrincipalCuotas = new javax.swing.JPanel();
        LabelEstadoCuotas = new javax.swing.JLabel();
        BarraBusqueda = new javax.swing.JTextField();
        LabelLupa = new javax.swing.JLabel();
        ScrollPaneCuotas = new javax.swing.JScrollPane();
        PanelCuotas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Estado de Cuotas");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PanelPrincipalCuotas.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalCuotas.setPreferredSize(new java.awt.Dimension(1400, 800));

        LabelEstadoCuotas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        LabelEstadoCuotas.setText("ESTADO DE CUOTAS");

        BarraBusqueda.setBackground(new java.awt.Color(245, 245, 245));
        BarraBusqueda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
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

        javax.swing.GroupLayout PanelPrincipalCuotasLayout = new javax.swing.GroupLayout(PanelPrincipalCuotas);
        PanelPrincipalCuotas.setLayout(PanelPrincipalCuotasLayout);
        PanelPrincipalCuotasLayout.setHorizontalGroup(
            PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(47, 47, 47)
                .addComponent(LabelEstadoCuotas)
                .addGap(71, 71, 71)
                .addGroup(PanelPrincipalCuotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ScrollPaneCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void BarraBusquedaMouseClicked(java.awt.event.MouseEvent evt) {                                           
        BarraBusqueda.setText("");
    }                                          

    
/*. (punto): Este símbolo representa cualquier carácter excepto un salto de línea.
* (asterisco): Este símbolo significa que el carácter anterior (en este caso el punto) puede aparecer cero o más veces. Así que .* significa "cualquier carácter, cero o más veces".
[a-zA-Z]: Este conjunto de caracteres se utiliza para representar cualquier letra del alfabeto.
a-z significa cualquier letra minúscula de la 'a' a la 'z'.
A-Z significa cualquier letra mayúscula de la 'A' a la 'Z'.
Entonces, [a-zA-Z] cubre todas las letras del alfabeto en ambos casos.
+ (más): Este símbolo significa que el carácter anterior (en este caso, el conjunto de letras) debe aparecer una o más veces. Así que [a-zA-Z]+ significa "una o más letras".
.* (de nuevo): Similar a lo mencionado antes, esta parte indica que después de encontrar al menos una letra, puede haber cualquier carácter, cero o más veces.*/
    
    
    private void LabelLupaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        if (BarraBusqueda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha ingresado ninguna cédula \nIntente nuevamente", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } else if(BarraBusqueda.getText().matches(".*[a-zA-Z]+.*")){ 
            JOptionPane.showMessageDialog(this, "La cédula ingresada contiene letras \nIntente nuevamente", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }  
             else{
            VentanaCuotaCliente CuotaCliente = new VentanaCuotaCliente();
            dispose();
            CuotaCliente.setVisible(true);            
        }
    }                                      

 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCuotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField BarraBusqueda;
    private javax.swing.JLabel LabelEstadoCuotas;
    private javax.swing.JLabel LabelLupa;
    private javax.swing.JPanel PanelCuotas;
    private javax.swing.JPanel PanelPrincipalCuotas;
    private javax.swing.JScrollPane ScrollPaneCuotas;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration                   

}


