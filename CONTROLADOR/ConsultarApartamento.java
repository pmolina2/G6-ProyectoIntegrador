package CONTROLADOR;
import Dominio.*;
import MODELO.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class ConsultarApartamento extends ConexionControladorBd{
    
    public ArrayList<Apartamento> devolverApartamentos(String idTorre){

        ArrayList<Apartamento> listaApartamentos = new ArrayList<>();

        try {
            ApartamentoBd apartamentoBd = new ApartamentoBd();
            Hashtable<String, ArrayList<String>> apartamento = apartamentoBd.consultarAptoTorre(idTorre);
            apartamento.forEach((key, values) -> {
            
            String matricula = key;
            String numApto = values.get(0);
            String tipoUnidad = values.get(1);
            String area = values.get(2);
            String valorApto = values.get(3);

            Apartamento pApartamento = new Apartamento(matricula, numApto, tipoUnidad, area, valorApto);
            listaApartamentos.add(pApartamento);
        });

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return listaApartamentos;

    }
    
    

}
