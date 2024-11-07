package CONTROLADOR;


public class IdGenerator {
    
    private static int currentID = 0; // Comienza en 0 y asegúrate de que se ajuste a tu longitud máxima

    public static synchronized String getNextID() {
        currentID++;
        // Asegúrate de que el ID siempre tenga exactamente 4 caracteres
        return String.format("%4d", currentID);
    }
}

