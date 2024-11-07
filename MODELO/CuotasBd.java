package MODELO;
import java.util.*;
import java.sql.*;

//CLASE CuotasBd QUE EXTIENDE LA CLASE ConexionBd PARA REALIZAR LAS CONSULTAS
public class CuotasBd extends ConexionBd{

    //METODO DE LA CLASE ENCARGADO DE CONSULTAR TODAS LAS CUOTAS ALMACENADAS EN LA BD
    public Hashtable<String, ArrayList<String>> consultarCuotas() throws SQLException{
     
        //SE INICIALIZA LA CONEXION Y EL HASH DONDE SE GUARDARAN LOS DATOS DE LA CONSULTA
        Connection conexion = this.getConnection();
        Hashtable<String, ArrayList<String>> hashCuotas = new Hashtable<>();

        //SENTENCIA SQL
        String sentencia = """
                SELECT *
                FROM CUOTA
                """;
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        ResultSet resultset = statement.executeQuery();
        
        //EJECUTAR EL CODIGO HASTA QUE EL RESULTSET NO DEVUELVA NADA
        while(resultset.next()){

            //SE INICIALIZA LA LISTA DE datosCuota POR CADA OBJETO EN EL RESULTSET PARA PODER SEPARARLOS DENTRO DEL HASHTABLE
            ArrayList<String> datosCuota = new ArrayList<>();
            datosCuota.add(resultset.getString("valor"));
            datosCuota.add(resultset.getString("estado"));
            datosCuota.add(resultset.getString("fechaCuota"));
            datosCuota.add(resultset.getString("numeroCuota"));
            datosCuota.add(resultset.getString("cedulaCliente"));

            //SE AGREGAN LOS DATOS AL HASH TOMANDO EL ID COMO KEY Y LA LISTA datosCuota COMO VALUE
            hashCuotas.put(resultset.getString("id"), datosCuota);

        }

        //SE USA EL METODO close PARA LOS OBJETOS
        statement.close();
        resultset.close();
        closeConnection();

        //SE RETORNA EL HASHTABLE
        return hashCuotas;

    }
    
}
