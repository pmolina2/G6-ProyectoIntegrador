package MODELO;
import java.util.*;
import java.sql.*;


//CLASE APARTAMENTOBD ENCARGADA DE REALIZAR LA CONSULTA DE APARTAMENTOS
public class ApartamentoBd extends ConexionBd{
    

    //METODO consultarAptoTorre QUE PIDE COMO PARAMETRO EL ID DE LA TORRE EN LA VARIABLE idTorre
    public Hashtable<String, ArrayList<String>> consultarAptoTorre(String idTorre, String usuario, String contraseña) throws SQLException{
        
      
        //SE CREA LA CONEXION A LA BASE DE DATOS CON EL METODO getConnection DE LA CLASE PADRE
        Connection conexion = this.getConnection(usuario, contraseña);

        //SE INICIALIZAN EL HASHTABLE hashApartamentos PARA ALMACENAR LOS DATOS DEL RESULTSET
        //Y LA VARIABLE SENTENCIA QUE CONTIENE LA SENTENCIA SQL
        Hashtable<String, ArrayList<String>> hashApartamentos = new Hashtable<>();
        String sentencia = "SELECT * FROM proyectoIntegradorg6.apartamento where idTorre = ? ";

        //SE INICIALIZAN LOS OBJETOS DE LA LIBRERIA SQL PreparedStatement y ResultSet PARA REALIZAR LA CONSULTA
        PreparedStatement statement = conexion.prepareStatement(sentencia);

        //SE ASIGNA EL VALOR DE LA VARIABLE DEL PARAMETRO A LA SENTENCIA MEDIANTE EL METODO setString
        statement.setString(1, idTorre);
        ResultSet resultset = statement.executeQuery();

        //SE EJECUTA EL CODIGO HASTA QUE EL RESULTSET NO TENGA UN RESULTADO.
        while(resultset.next()){
            
            //SE CREA UNA LISTA DENTRO DEL WHILE PARA QUE SE LIMPIE EN C/ ITERACION
            ArrayList<String> datosApartamento = new ArrayList<>();

            //ASIGNAMOS LOS DATOS OBTENIDOS EN LA CONSULTA A LA LISTA datosApartamento
            String matricula = resultset.getString("matricula");
            String numApto = resultset.getString("numApto");
            String tipoUnidad = resultset.getString("tipoUnidad");
            String area = resultset.getString("area");
            String valorApto = resultset.getString("valorApto");
            datosApartamento.add(numApto);
            datosApartamento.add(tipoUnidad);
            datosApartamento.add(area);
            datosApartamento.add(valorApto);

            //AGREGAMOS LA MATRICULA COMO KEY Y LA LISTA COMO VALUES EN EL HASHTABLE POR C/ APARTAMENTO
            hashApartamentos.put(matricula, datosApartamento);
           
        }

        //USAMOS LOS METODOS .close() EN CADA OBJETO PARA CERRAR LA CONEXION CORRECTAMENTE
        statement.close();
        resultset.close();
        closeConnection();

        //RETORNAMOS EL HASHTABLE
        return hashApartamentos;

    }

}
