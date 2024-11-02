package CONTROLADOR;

import Dominio.*;
import java.util.Random;
import MODELO.*;

public class CrearVenta extends ConexionControladorBd{

    public String GuardarVenta(String cedulaCliente, String cedulaAsesor, int numCuotas, int intereses, String fechaEscritura, Apartamento apartamento){
        VentaBd venta = new VentaBd();
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String precio = apartamento.getValorApto();
        String matricula = apartamento.getMatricula();
        
        

        String verificacion = venta.registrarVenta(id, precio, numCuotas, intereses, cedulaAsesor, matricula, cedulaCliente, fechaEscritura);
        return verificacion;
    }

}