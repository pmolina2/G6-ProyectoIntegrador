/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class VentanaInicioAsesor extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicioAsesor
     * 
     * @param asesorActual
     */
    public VentanaInicioAsesor(Asesor asesorActual) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage()
                .getScaledInstance(LabelImagen3.getWidth(), LabelImagen3.getHeight(), 0));
        LabelImagen3.setIcon(miIcono);
        LabelNombre2.setOpaque(true);
        String NombreAsesor = asesorActual.getNombreCompleto().toUpperCase();
        LabelNombre2.setText(NombreAsesor);
        LabelRol2.setOpaque(true);
<<<<<<< Updated upstream
=======
        LabelRol2.setText("ASESOR");
>>>>>>> Stashed changes
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNombre = new javax.swing.JLabel();
        PanelPrincipalAs = new javax.swing.JPanel();
        PanelLateralAs = new javax.swing.JPanel();
        LabelImagen3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BotonRegresarVIAs = new javax.swing.JButton();
        LabelRol2 = new javax.swing.JLabel();
        LabelNombre2 = new javax.swing.JLabel();
        LabelProyectos2 = new javax.swing.JLabel();

        LabelNombre.setBackground(new java.awt.Color(240, 240, 240));
        LabelNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        LabelNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Inicio");
        setResizable(false);

        PanelPrincipalAs.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalAs.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelLateralAs.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralAs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CONSULTAR CUOTAS");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BotonRegresarVIAs.setBackground(new java.awt.Color(240, 240, 240));
        BotonRegresarVIAs.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonRegresarVIAs.setText("Cerrar Sesion");
        BotonRegresarVIAs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonRegresarVIAs.setContentAreaFilled(false);
        BotonRegresarVIAs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresarVIAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarVIAsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralAsLayout = new javax.swing.GroupLayout(PanelLateralAs);
        PanelLateralAs.setLayout(PanelLateralAsLayout);
        PanelLateralAsLayout.setHorizontalGroup(
                PanelLateralAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLateralAsLayout.createSequentialGroup()
                                .addGroup(PanelLateralAsLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelLateralAsLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(LabelImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLateralAsLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLateralAsLayout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(BotonRegresarVIAs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE)));
        PanelLateralAsLayout.setVerticalGroup(
                PanelLateralAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLateralAsLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(LabelImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261,
                                        Short.MAX_VALUE)
                                .addComponent(BotonRegresarVIAs, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)));

        LabelRol2.setBackground(new java.awt.Color(240, 240, 240));
        LabelRol2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelRol2.setForeground(new java.awt.Color(51, 51, 51));
        LabelRol2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)),
                javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        LabelNombre2.setBackground(new java.awt.Color(240, 240, 240));
        LabelNombre2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelNombre2.setForeground(new java.awt.Color(51, 51, 51));
        LabelNombre2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)),
                javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        LabelProyectos2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelProyectos2.setText("PROYECTOS DISPONIBLES");

        javax.swing.GroupLayout PanelPrincipalAsLayout = new javax.swing.GroupLayout(PanelPrincipalAs);
        PanelPrincipalAs.setLayout(PanelPrincipalAsLayout);
        PanelPrincipalAsLayout.setHorizontalGroup(
                PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(PanelLateralAs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelPrincipalAsLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(PanelPrincipalAsLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LabelNombre2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 535,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LabelRol2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalAsLayout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        380, Short.MAX_VALUE)
                                                .addComponent(LabelProyectos2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(352, 352, 352)))));
        PanelPrincipalAsLayout.setVerticalGroup(
                PanelPrincipalAsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(PanelPrincipalAsLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPrincipalAsLayout.createSequentialGroup()
                                                .addComponent(LabelNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(LabelRol2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(LabelProyectos2))
                                        .addComponent(PanelLateralAs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(48, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelPrincipalAs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelPrincipalAs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        VentanaListaCuotas VentanaCuotas = new VentanaListaCuotas();
        VentanaCuotas.setVisible(true);
    }// GEN-LAST:event_jButton1ActionPerformed

    private void BotonRegresarVIAsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BotonRegresarVIAsActionPerformed
        JOptionPane.showMessageDialog(this, "Sesion cerrada correctamente", "Mensaje Informativo",
                JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        InicioSesion InicioSes = new InicioSesion();
        InicioSes.setVisible(true);
    }// GEN-LAST:event_BotonRegresarVIAsActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegresarVIAs;
    private javax.swing.JLabel LabelImagen3;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelNombre2;
    private javax.swing.JLabel LabelProyectos2;
    private javax.swing.JLabel LabelRol2;
    private javax.swing.JPanel PanelLateralAs;
    private javax.swing.JPanel PanelPrincipalAs;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
