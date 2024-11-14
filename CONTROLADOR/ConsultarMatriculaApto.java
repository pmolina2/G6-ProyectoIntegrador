package CONTROLADOR;
import MODELO.ConsultarMatriculaAptoBd;

//Clase encargada de verifica si la matricula del apartamento ya fue registrada como vendida, extendemos la clase abstracta para hacer mas facil la conexion.

public class ConsultarMatriculaApto extends ConexionControladorBd{

    //Metodo donde haremos la conexion y enviaremos los parametros para la consulta en bd, teniendo matricula como parametro.

    public boolean consultarMatricula(String matricula){
        //Creamos un objeto de la clase encargada de la consulta en modelo.
        ConsultarMatriculaAptoBd matriculaBd = new ConsultarMatriculaAptoBd();
        //creamos una variable de tipo boolean donde se recibe el retorno del metodo de modelo.
        boolean Respuesta = matriculaBd.consultarMatriculaBd(matricula);
        //retornamos la respuesta recibida por modelo.
        return Respuesta;
    }
}