package CONTROLADOR;

import java.util.*;
import Dominio.*;
import MODELO.*;

public class ConsultarCuotas extends ConexionControladorBd {

    public ArrayList<Cuota> devolverCuotas() {

        ArrayList<Cuota> listaCuotas = new ArrayList<>();

        try {
            CuotasBd cuota = new CuotasBd();
            Hashtable<String, ArrayList<String>> cuotas = cuota.consultarCuotas();

            cuotas.forEach((key, values) -> {

                String id = key;
                String valor = values.get(0);
                String numeroCuota = values.get(1);
                String estado = values.get(2);
                String cedulaCliente = values.get(3);
                String fechaCuota = values.get(4);

                Cuota pCuotas = new Cuota(id, valor, numeroCuota, estado, cedulaCliente, fechaCuota);
                listaCuotas.add(pCuotas);
            });

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        
        return listaCuotas;
    }

}
