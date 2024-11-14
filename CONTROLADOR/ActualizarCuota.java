package CONTROLADOR;

import MODELO.*;

public class ActualizarCuota extends ConexionControladorBd {
    
    public void actualizarCuota(String idCuota){
        ActualizarCuotaBd cuota = new ActualizarCuotaBd();

        cuota.actualizarCuotaBd(idCuota);
    }
}
