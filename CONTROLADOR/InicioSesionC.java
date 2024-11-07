package CONTROLADOR;

import java.util.ArrayList;
import MODELO.*;

// Clase encargada del inicio de sesion en la aplicacion, extiende la clase ConexionControladorBD
//para facilitar la conexion a BD.

public class InicioSesionC extends ConexionControladorBd{

    // Método encargado de la verificacion de las credenciales, recibe de vista la cedula y la contraseña del usuario.
    public ArrayList<String> verificacionInicio(String cedula, String contraseña) {

        //Creamos un arraylist donde se almacenara la informacion del usuario que inicio.
        ArrayList<String> datos = new ArrayList<>();

        try {
            //Inicio de la conexion a BD con la clase InicioSesionBd
            InicioSesionBd inicioSesion = new InicioSesionBd();
            //Obtenemos un arraylist de strings segun sea el caso del usuario que vaya iniciar,
            //se pasa el nombre de la tabla, la cedula y la contraseña, al hacer la consulta y encontrar el usuario
            //devuelve la informacion en el arraylist
            ArrayList<String> asesor = inicioSesion.consultarInicioSesion("asesor", cedula, contraseña);
            ArrayList<String> administrador = inicioSesion.consultarInicioSesion("administrador", cedula, contraseña);

            //Verificacion de que el arraylist tenga elementos y si la cedula y contraseña son iguales a las que obtuvimos de vista,
            if(!administrador.isEmpty() && administrador.get(0).equals(cedula) && administrador.get(1).equals(contraseña)){
                //Si verifica que todo este correcto, se agrega la info al arraylist creado al principio.
                datos.add(cedula);
                datos.add(contraseña);
                datos.add("administrador");

            }//Verificacion de que el arraylist tenga elementos y si la cedula y contraseña son iguales a las que obtuvimos de vista.
             else if (!asesor.isEmpty() && asesor.get(0).equals(cedula) && asesor.get(1).equals(contraseña)) {
                //Si verifica que todo este correcto, se agrega la info al arraylist creado al principio.
                datos.add(cedula);
                datos.add(contraseña);
                datos.add("asesor");


            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        //retorno del arraylist con la informacion que inicio sesion.
        return datos;
    }

}
