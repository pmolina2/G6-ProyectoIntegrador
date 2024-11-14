package CONTROLADOR;

import MODELO.*;

public class ExistenciaCuotaCliente extends ConexionControladorBd {

    public boolean existenciaCuota(String cedula){

        ConsultarCuotaClienteBd consultaCuota = new ConsultarCuotaClienteBd();

        boolean respuesta = consultaCuota.consultaCedulaCuotaBd(cedula);

        return respuesta;
    }
    
}