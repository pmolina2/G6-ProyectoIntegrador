package MODELO;

import java.sql.*;
import java.util.ArrayList;

public class ClienteBd extends ConexionBd{
    
    /*  método principal de la clase que sirve para devolver un arraylist de tipo String 
        con los datos del cliente cuya cédula sea la pasada en el parámetro
    */
    public ArrayList<String> consultarCliente(String ced){

        // se crea la conexión con el usuario asesorg6 y la contraseña asesor
        Connection conexion = this.getConnection("asesorg6", "asesor");
        ArrayList<String> datosCliente = new ArrayList<>();

        // sentencia a ejecutar
        String sentencia = """
                SELECT *
                FROM proyectoIntegradorg6.cliente
                WHERE cedula = ?
                """;
        
        try (PreparedStatement statement = conexion.prepareStatement(sentencia)){
            
            // creación del parámetro de la PreparedStatement para reemplazar el simbolo ? con las variables en la sentencia
            statement.setString(1, ced);

            /*  el resultset es un tipo de dato de la libreria de SQL para almacenar los datos obtenidos de una consulta.
                En este caso se almacenan los datos del cliente en el resultset, provocando que tengamos que hacer un ciclo sobre este
                hasta que no hayan más registros, los datos obtenidos los almacenamos en la lista anteriormente creada y la retornamos.
            */
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                datosCliente.add(resultSet.getString("cedula"));
                datosCliente.add(resultSet.getString("nombreCompleto"));
                datosCliente.add(resultSet.getString("sisben"));
                datosCliente.add(resultSet.getString("subsidio"));
                datosCliente.add(resultSet.getString("direccion"));
                datosCliente.add(resultSet.getString("telefono"));
                datosCliente.add(resultSet.getString("correoElectronico"));

            }

            // cierre del statement y del resultset
            statement.close();
            resultSet.close();

        //Prevención de errores SQL,  en caso de que ocurra algo inesperado saltará el código dentro de las llaves
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        // cierre de la conexión y retorno de la lista
        closeConnection();
        return datosCliente;

    }

}
