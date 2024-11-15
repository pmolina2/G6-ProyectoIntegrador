package Dominio;
import java.util.Date;

//Clase entidad que guarda la informacion de los asesores.
public class Pago {
    //atributos necesarios para almacenar la info.
    private String numTransferencia, metodoPago, valorPago, cedulaCliente, idCuota, cuotaPagada;
    private Date fecha;

    //Constructor para darle valores a los atributos.

    public Pago(String numTransferencia, String metodoPago, String valorPago, Date fecha, String cedulaCliente, String idCuota, String cuotaPagada) {
        this.numTransferencia = numTransferencia;
        this.metodoPago = metodoPago;
        this.valorPago = valorPago;
        this.cedulaCliente = cedulaCliente;
        this.idCuota = idCuota;
        this.cuotaPagada = cuotaPagada;
        this.fecha = fecha;
    }

    public String getNumTransferencia() {
        return numTransferencia;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getValorPago() {
        return valorPago;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getIdCuota() {
        return idCuota;
    }

    public String getCuotaPagada() {
        return cuotaPagada;
    }

    public Date getFecha() {
        return fecha;
    }
    
    
    
    
}
