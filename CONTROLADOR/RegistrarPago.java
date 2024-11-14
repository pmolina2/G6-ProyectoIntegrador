package CONTROLADOR;

import MODELO.GuardarPagoBd;

public class RegistrarPago extends ConexionControladorBd {
    
    public String registrarPago(String numeroReferencia, String metodoPago, String valorPago, String fecha, String cedulaCliente, String idCuota, String numeroCuota){

        GuardarPagoBd pago = new GuardarPagoBd();

        String mensaje = pago.guardarPagoBd(numeroReferencia, metodoPago, valorPago, fecha, cedulaCliente, idCuota, numeroCuota);
        return mensaje;
    }
}
