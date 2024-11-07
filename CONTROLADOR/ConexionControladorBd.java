package CONTROLADOR;
import MODELO.*;

//Creacion de clase abstracta, esto con el fin de agilizar el proceso de conexion a Base de datos desde
//las clases de controlador.

abstract class ConexionControladorBd {
    
    ConexionBd conexion = new ConexionBd();
    
}
