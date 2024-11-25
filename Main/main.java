package Main;

import Vista.InicioSesion;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class main {

    public static void main(String[] args) {
        
        // Configurar el Look and Feel antes de crear la interfaz
        try {
            // Opción 1: Establecer Nimbus si está disponible
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            // Nota: Si Nimbus no es el Look and Feel que deseas, prueba otros disponibles
            // Por ejemplo:
            // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace(); // Imprime cualquier error al establecer el Look and Feel
        }
        
        // Crear una instancia de la clase InicioSesion y configurarla
        InicioSesion app = new InicioSesion();
        app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
