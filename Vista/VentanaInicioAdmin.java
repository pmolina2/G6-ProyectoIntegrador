/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import CONTROLADOR.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Alejandro
 */
public class VentanaInicioAdmin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicioAdmin
     */
    public VentanaInicioAdmin(Admin AdminActual) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/Logo Ventana.png")).getImage());
        Icon miIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Iconos/IconoSinFondo.png")).getImage()
                .getScaledInstance(LabelImagen2.getWidth(), LabelImagen2.getHeight(), 0));
        LabelImagen2.setIcon(miIcono);
        LabelNombre.setOpaque(true);
        String NombreAdmin = AdminActual.getNombreCompleto().toUpperCase();
        LabelNombre.setText(NombreAdmin);
        LabelRol.setOpaque(true);
        LabelRol.setText("ADMINISTRADOR");

        // creacion de objetos para mostrar la lista de proyectos
        ConsultarProyecto ConsultaProyectos = new ConsultarProyecto();
        ArrayList<Proyecto> proyectos = ConsultaProyectos.devolverProyectos();

        MostrarProyectos(proyectos);

    }

    public void MostrarProyectos(ArrayList<Proyecto> proyectos) {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));

        for (Proyecto proyecto : proyectos) {
            JButton botonProyecto = new JButton("Proyecto"); // Texto igual para todos
            botonProyecto.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            botonProyecto.setForeground(new Color(102, 102, 102));
            botonProyecto.setBorder(null);
            botonProyecto.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Aquí podrías utilizar el ActionListener para diferenciar qué proyecto
            // corresponde
            botonProyecto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    // Manejar el evento del botón
                    JOptionPane.showMessageDialog(VentanaInicioAdmin.this, "Seleccionaste: " + proyecto.getNombre());
                }
            });

            panelBotones.add(botonProyecto);
        }

        PanelPrincipalA.add(panelBotones);
        PanelPrincipalA.revalidate();
        PanelPrincipalA.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipalA = new javax.swing.JPanel();
        PanelLateralA = new javax.swing.JPanel();
        LabelImagen2 = new javax.swing.JLabel();
        BotonGenerarReporte = new javax.swing.JButton();
        BotonCerrarSesionAdm = new javax.swing.JButton();
        LabelRol = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelProyectos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urbaniza - Inicio");
        setResizable(false);

        PanelPrincipalA.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipalA.setPreferredSize(new java.awt.Dimension(1400, 800));

        PanelLateralA.setBackground(new java.awt.Color(240, 240, 240));
        PanelLateralA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        BotonGenerarReporte.setBackground(new java.awt.Color(0, 51, 102));
        BotonGenerarReporte.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        BotonGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        BotonGenerarReporte.setText("GENERAR REPORTE");
        BotonGenerarReporte.setBorder(null);
        BotonGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonCerrarSesionAdm.setBackground(new java.awt.Color(240, 240, 240));
        BotonCerrarSesionAdm.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        BotonCerrarSesionAdm.setText("Cerrar Sesión");
        BotonCerrarSesionAdm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BotonCerrarSesionAdm.setContentAreaFilled(false);
        BotonCerrarSesionAdm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCerrarSesionAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarSesionAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralALayout = new javax.swing.GroupLayout(PanelLateralA);
        PanelLateralA.setLayout(PanelLateralALayout);
        PanelLateralALayout.setHorizontalGroup(
                PanelLateralALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                .addGroup(PanelLateralALayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(LabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(BotonGenerarReporte,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 214,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                PanelLateralALayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BotonCerrarSesionAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)));
        PanelLateralALayout.setVerticalGroup(
                PanelLateralALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLateralALayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(LabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(BotonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261,
                                        Short.MAX_VALUE)
                                .addComponent(BotonCerrarSesionAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)));

        LabelRol.setBackground(new java.awt.Color(240, 240, 240));
        LabelRol.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelRol.setForeground(new java.awt.Color(102, 102, 102));
        LabelRol.setBorder(javax.swing.BorderFactory.createCompoundBorder(null,
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)),
                        javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1))));

        LabelNombre.setBackground(new java.awt.Color(240, 240, 240));
        LabelNombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(102, 102, 102));
        LabelNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)),
                javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1)));

        LabelProyectos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        LabelProyectos.setText("PROYECTOS DISPONIBLES");

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
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalALayout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        385, Short.MAX_VALUE)
                                                .addComponent(LabelProyectos, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(349, 349, 349)))));
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
                                                .addGap(66, 66, 66)
                                                .addComponent(LabelProyectos)))
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
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCerrarSesionAdmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BotonCerrarSesionAdmActionPerformed
        JOptionPane.showMessageDialog(this, "Sesion cerrada correctamente", "Mensaje Informativo",
                JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        InicioSesion InicioSes = new InicioSesion();
        InicioSes.setVisible(true);
    }// GEN-LAST:event_BotonCerrarSesionAdmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrarSesionAdm;
    private javax.swing.JButton BotonGenerarReporte;
    private javax.swing.JLabel LabelImagen2;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelProyectos;
    private javax.swing.JLabel LabelRol;
    private javax.swing.JPanel PanelLateralA;
    private javax.swing.JPanel PanelPrincipalA;
    // End of variables declaration//GEN-END:variables
}
