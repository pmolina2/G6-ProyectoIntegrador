
package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class InicioSesion extends javax.swing.JFrame {

   
    FondoPanel fondo = new FondoPanel();
    
    public InicioSesion() {
        this.setContentPane(fondo);
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage());
        initComponents();
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), 0));
        labelImagen.setIcon(miIcono);
        LabelInicioSesion.setOpaque(true);
        LabelInicioSesion.setBackground(Color.WHITE);
   
     
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        setTitle("Urbaniza - Inicio de Sesión");
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
        CampoContraseña.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoContraseñaActionPerformed(evt);
            }
        });

        CampoCedula.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        CampoCedula.setForeground(new java.awt.Color(102, 102, 102));
        CampoCedula.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        CampoCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CampoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCedulaActionPerformed(evt);
            }
        });

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
                .addGroup(PanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabelCedula)
                        .addComponent(CampoContraseña)
                        .addComponent(LabelContraseña)
                        .addComponent(CampoCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                    .addComponent(BotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelInicioSesionLayout.setVerticalGroup(
            PanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                .addGroup(PanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(LabelCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(LabelContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(BotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInicioSesionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(PanelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(LabelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(PanelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoContraseñaActionPerformed

    private void CampoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCedulaActionPerformed

    
    
    private void BotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntrarActionPerformed
     String cedulaUsuario = CampoCedula.getText();
        String contraseñaUsuario = CampoContraseña.getText();
        if (cedulaUsuario.equals("admin") && contraseñaUsuario.equals("admin")) {
            VentanaInicioAdmin VentanaAdmin = new VentanaInicioAdmin();
            this.dispose();
            VentanaAdmin.setVisible(true);   }
        else if(cedulaUsuario.equals("asesor") && contraseñaUsuario.equals("asesor")){
            VentanaInicioAsesor VentanaAsesor = new VentanaInicioAsesor();
            this.dispose();
            VentanaAsesor.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Cédula o contraseña incorrectas, \nintente nuevamente", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_BotonEntrarActionPerformed

   
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
        
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables

    
    class FondoPanel extends JPanel
{
    private Image imagen;
   
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/Iconos/Plantilla.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
        
        setOpaque(false);
        
        super.paint(g);
        
        
    } 
    
}
}


    


