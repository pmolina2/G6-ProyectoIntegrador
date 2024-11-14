package CONTROLADOR;

import Dominio.*;
import MODELO.*;

//Clase encargada de enviar la info de la venta al package modelo, con el fin de almacenarlo en la BD
public class CrearVenta extends ConexionControladorBd {

    // Metodo encargado de recibir la informacion proveniente del package vista, y
    // prepararla para enviarla a BD
    public String GuardarVenta(String cedulaCliente, String cedulaAsesor, int numCuotas, int intereses,
            String fechaEscritura, Apartamento apartamento) {
        // Inicio de la conexion a BD con la clase VentaBd.
        VentaBd venta = new VentaBd();
        // Preparamos los valores para que BD los pueda recibir sin errores.
        String precio = apartamento.getValorApto();
        String matricula = apartamento.getMatricula();

        // Enviamos las variables al metodo encargado del insert en BD
        String verificacion = venta.registrarVenta(precio, numCuotas, intereses, cedulaAsesor, matricula, cedulaCliente, fechaEscritura);
        
        // El metodo registrarVenta nos devuelve un string señalando que el insert fue
        // exitoso, lo retornamos a vista para que lo muestre.
        return verificacion;
    }

}
