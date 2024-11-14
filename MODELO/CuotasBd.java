package MODELO;
import java.sql.*;
import java.util.*;

public class CuotasBd extends ConexionBd{

    //METODO DE LA CLASE ENCARGADO DE CONSULTAR TODAS LAS CUOTAS ALMACENADAS EN LA BD
    public Hashtable<String, ArrayList<String>> consultarCuotas() throws SQLException {
     
        //SE INICIALIZA LA CONEXION Y EL HASH DONDE SE GUARDARAN LOS DATOS DE LA CONSULTA
        Connection conexion = this.getConnection("asesor", "asesor");
        Hashtable<String, ArrayList<String>> hashCuotas = new Hashtable<>();

        //PREPARAR EL PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR LOS ESTADOS
        CallableStatement callableStatement = conexion.prepareCall("{call proyectointegrador.actualizarCuotasVencidas}");
        CallableStatement callableStatement2 = conexion.prepareCall("{call proyectointegrador.actualizarCuotasNoVencidas}");
        CallableStatement callableStatement3 = conexion.prepareCall("{call proyectointegrador.actualizarCuotasCompletadas}");

        try {
            callableStatement.execute();
            callableStatement2.execute();
            callableStatement3.execute();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            throw e; 
        } finally {
            callableStatement.close();
            callableStatement2.close();
            callableStatement3.close();
        }

        //SENTENCIA SQL PARA CONSULTAR LAS CUOTAS
        String sentencia = """
                SELECT *
                FROM proyectointegrador.CUOTA
                WHERE estado != 'Completada'
                """;
        PreparedStatement statement = conexion.prepareStatement(sentencia);
        ResultSet resultset = statement.executeQuery();
        
        //EJECUTAR EL CODIGO HASTA QUE EL RESULTSET NO DEVUELVA NADA
        while (resultset.next()) {

            //SE INICIALIZA LA LISTA DE datosCuota POR CADA OBJETO EN EL RESULTSET PARA PODER SEPARARLOS DENTRO DEL HASHTABLE
            ArrayList<String> datosCuota = new ArrayList<>();
            datosCuota.add(resultset.getString("valor"));
            datosCuota.add(resultset.getString("estado"));
            datosCuota.add(resultset.getString("fechaCuota"));
            datosCuota.add(resultset.getString("numeroCuota"));
            datosCuota.add(resultset.getString("cedulaCliente"));
            datosCuota.add(resultset.getString("idVenta"));

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
