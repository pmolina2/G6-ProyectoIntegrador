package CONTROLADOR;
import MODELO.*;

//Clase encargada de obtener la info para hacer una venta. Extendida a la clase abstracta ConexionControladorBd
//para facilitar la conexion a BD.
public class ConsultarInfoVenta extends ConexionControladorBd {
    
    //Metodo encargado de retornar el numero de la torre a la que pertenece el apartamento.
    //recibiendo como parametro la matricula del apartamento.
    public String devolverNumTorre(String matricula){
        //Inicio de la conexion a Bd con la clase NumeroTorreBd
        NumeroTorreBd numTorreBd = new NumeroTorreBd();
        //Variable donde se almacenará el numero de la torre del apartamento.
        String numTorre = null;

        try {
            //Ejecucion del metodo encargado de devolver el numero de torre en el package modelo.
            numTorre = numTorreBd.consultarNumTorre(matricula);
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        //Retorno de la variable con el numero de la torre ya almacenado.
        return numTorre;
    }


    //Metodo encargado de retornar el nombre del proyecto al que pertenece el apartamento.
    //recibiendo como parametro la matricula del apartamento.
    public String devolverNombreProyecto(String matricula){
         //Inicio de la conexion a Bd con la clase NombreProyectoBd
        NombreProyectoBd nomProyectoBd = new NombreProyectoBd();
        //Variable donde se almacenará el nombre del proyecto del apartamento.
        String nombreProyecto = null;

        try {
            //Ejecucion del metodo encargado de devolver el nombre del proyecto en el package modelo.
            nombreProyecto = nomProyectoBd.consultarNombreProyecto(matricula);
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        //Retorno de la variable con el nombre del proyecto ya almacenado.
        return nombreProyecto;

    }

}
