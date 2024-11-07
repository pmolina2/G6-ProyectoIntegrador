package MODELO;
import java.util.*;
import java.sql.*;

//CLASE InicioSesionBd QUE EXTIENDE LA CLASE ConexionBd PARA REALIZAR LAS CONSULTAS
public class InicioSesionBd extends ConexionBd{

    /*METODO DE LA CLASE PARA HACER LA CONSULTAR EN LA BD E INICIAR SESION DEPENDIENDO DEL USUARIO
     *SE LE PASA COMO PARAMETRO EL NOMBRE DE LA TABLA EN LA QUE SE QUIERE HACER LA CONSULTA, ADEMAS DE LA CEDULA Y 
     LA CONTRASEÑA. EL METODO DEVUELVE UN ARRAYLIST DE TIPO STRING CON LOS DATOS DEL USUARIO QUE INGRESÓ.
    */
    public ArrayList<String> consultarInicioSesion(String nombreTabla, String cedula, String contraseña) throws SQLException {

        //SE INICIALIZA LA CONEXION A LA BD Y EL ARRAYLIST listaDatos PARA ALMACENAR LOS DATOS DE LA CONSULTA
        Connection conexion = this.getConnection();   
        ArrayList<String> listaDatos = new ArrayList<>();    
        
        //SENTENCIA SQL
        String sentencia = String.format("""
                SELECT cedula, contrasenna
                FROM %s
                WHERE cedula = ? 
                AND contrasenna = ?
                """, nombreTabla);
        
        //PREPARACION DE LA CONSULTA
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        //SE USA EL METODO setString PARA REEMPLAZAR LAS VARIABLES EN LA CONSULTA
        statement.setString(1, cedula);
        statement.setString(2, contraseña);
        ResultSet resultset = statement.executeQuery();

        //SI EL RESULTSET DEVUELVE AL MENOS UN VALOR, EJECUTAR EL CODIGO
        if(resultset.next()){

            //SE AGREGAN LOS DATOS DE LA CONSULTA EN EL ARRAYLIST listaDatos
            listaDatos.add(resultset.getString("cedula"));
            listaDatos.add(resultset.getString("contrasenna"));
        }
        
        //SE USA EL METODO close PARA LOS OBJETOS 

        statement.close();
        resultset.close();
        closeConnection();

        //SE RETORNA EL ARRAYLIST listaDatos
        return listaDatos;
        
    }

}
