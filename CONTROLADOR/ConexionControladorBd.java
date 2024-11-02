package CONTROLADOR;
import MODELO.*;

//Interfaz creada para hacer mas ágil la conexion a base de datos desde las clases.

abstract class ConexionControladorBd {
    
    ConexionBd conexion = new ConexionBd();
    
}
