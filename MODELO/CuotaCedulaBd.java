package MODELO;
import java.sql.*;
import java.util.*;

//CLASE CuotaCedulaBd QUE EXTIENDE LA CLASE ConexionBd PARA REALIZAR LA CONEXION A LA BD
public class CuotaCedulaBd extends ConexionBd{
    
    //METODO DE LA CLASE consultarCuotaCedula, PIDE COMO PARAMETRO LA CEDULA DEL CLIENTE
    public ArrayList<String> consultarCuotaCedula(String cedulaCliente) throws SQLException{

        //SE INICIALIZA LA CONEXION Y LA LISTA DONDE SE GUARDARAN LOS DATOS DE LA CONSULTA.
        //SE USA UN ARRAYLIST DE TIPO STRING EN LUGAR DE UN RESULTSET PORQUE LA CONSULTA SOLO DEVOLVERA UN RESULTADO.
        Connection conexion = this.getConnection();
        ArrayList<String> datosCuota = new ArrayList<>();

        //SENTENCIA SQL
        String sentencia = """
                SELECT *
                FROM cuota
                WHERE cedulaCliente = ?
                """;

        //CREACION DE LOS OBJETOS DE LA LIBRERIA SQL PARA REALIZAR LA CONSULTA
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        //SE PASA COMO PARAMETRO AL METODO setString PARA AGREGAR LA VARIABLE A LA CONSULTA
        statement.setString(1, cedulaCliente);
        ResultSet resultset = statement.executeQuery();

        //SI SE OBTIENE AL MENOS UN RESULTADO SE EJECUTA EL CODIGO
        if(resultset.next()){

            //SE AGREGAN LOS DATOS EN ORDEN DE APARICION EN LA BD A LA LISTA
            datosCuota.add(resultset.getString("id"));
            datosCuota.add(String.valueOf(resultset.getString("valor")));
            datosCuota.add(resultset.getString("estado"));
            datosCuota.add(resultset.getString("fechaCuota"));
            datosCuota.add(resultset.getString("numeroCuota"));
            datosCuota.add(resultset.getString("cedulaCliente"));

        }

        //SE USA EL METODO close CON TODOS LOS OBJETOS
        statement.close();
        resultset.close();
        closeConnection();

        //SE RETORNA LA LISTA CON LOS DATOS
        return datosCuota;

    }

}
