package MODELO;
import java.sql.*;
import java.text.ParseException; 
import java.text.SimpleDateFormat;

public class VentaBd extends ConexionBd{
    
    public String registrarVenta(String id, String precio, int numCuotas, int intereses, String cedulaAsesor, String matricula, String cedulaCliente, String fechaEscritura){

        Connection conexion = this.getConnection();

        String sentencia = """
                INSERT INTO VENTA
                VALUES(venta_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?)
                """;
        
        try {
            
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, precio);
            statement.setInt(2, numCuotas);
            statement.setInt(3, intereses);
            statement.setString(4, cedulaAsesor);
            statement.setString(5, matricula);

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaUtil; 
            java.sql.Date fechaSql = null;

            try{
                fechaUtil = formato.parse(fechaEscritura);
                fechaSql = new Date(fechaUtil.getTime());
            } catch(ParseException e){
                System.out.println("Error "+e.getMessage());
            }

            statement.setString(6, cedulaCliente);
            statement.setDate(7, fechaSql);
            statement.executeQuery();

         
            statement.close();
            closeConnection();
            return "Venta registrada exitosamente";

        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }

        return "";
    
    }

}
