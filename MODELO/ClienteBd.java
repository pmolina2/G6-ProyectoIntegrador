package MODELO;

import java.sql.*;
import java.util.ArrayList;

public class ClienteBd extends ConexionBd{
    
    public ArrayList<String> consultarCliente(String ced){

        Connection conexion = this.getConnection("asesor", "asesor");
        ArrayList<String> datosCliente = new ArrayList<>();

        String sentencia = """
                SELECT *
                FROM proyectoIntegrador.cliente
                WHERE cedula = ?
                """;
        
        try {
            
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, ced);
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

            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        closeConnection();
        return datosCliente;

    }

}
