package CONTROLADOR;

import java.util.Date;
import java.sql.*;
import java.util.ArrayList;

public class ConsultarApartamento implements ConexionControladorBd{
    
    public ArrayList<Apartamento> devolverApartamentos(String idTorre){

        ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
        try {

            ResultSet apartamento = conexion.consultarBdSentencia("SELECT * FROM apartamento WHERE idTorre = "+ idTorre);
            while (apartamento.next()) {
                String matricula = apartamento.getString("matricula");
                String numApto = apartamento.getString("numApto");
                String tipoUnidad = apartamento.getString("tipoUnidad");
                String area = apartamento.getString("area");
                long valorApto = apartamento.getLong("valorApto");
                Date fechaEscritura = apartamento.getDate("fechaEscritura");
                Apartamento a = new Apartamento(matricula, numApto,tipoUnidad,area,valorApto,fechaEscritura );

                listaApartamentos.add(a);
            }
            return listaApartamentos;

        } catch (SQLException sqlx) {
            System.out.println("Error " + sqlx.getMessage());
        }

        return null;

    }
    
    

}
