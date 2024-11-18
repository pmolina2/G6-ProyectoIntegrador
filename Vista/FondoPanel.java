/*Esta clase sirve para establecer el fondo de un jpanel, y se crearán instancias de ella en muchas de las demás clases del package vista 
para establecer un fondo personalizado para la ventana.*/

package Vista;

//Se importan las clases necesarias
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


//La clase FondoPanel hereda de JPanel, por lo que se comporta como un panel estándar de Java.
public class FondoPanel extends JPanel {
    private Image imagen; //Se define un variable de tipo "Image" llamada imagen

    //Se sobreescribe el método Paint
    @Override
    public void paint(Graphics g) {

        //La variable imagen, almacenará la imagen llamada plantilla.png de la carpeta "Iconos" dentro del proyecto
        imagen = new ImageIcon(getClass().getResource("/Iconos/Plantilla.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this); //Se dibuja la imagen sobre el panel, ajustándose a sus dimensiones
        setOpaque(false); //Se hace que el panel sea transparente 
        super.paint(g); //Se realiza para que todo lo que JPanel hace por defecto, siga ocurriendo después de añadir la personalización.
    }
}

