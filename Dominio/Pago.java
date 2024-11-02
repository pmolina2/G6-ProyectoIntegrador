package Dominio;
import java.util.Date;

// Clase entidad para manejar la informacion de pagos, incluyendo su constructor, sus getters y sus setters.

public class Pago {
    private int numPago, valorPago;
    private String cedulaCliente, cedulaAsesor;
    private Date fecha;

    public Pago(int numPago, int valorPago, String cedulaCliente, String cedulaAsesor, Date fecha) {
        this.numPago = numPago;
        this.valorPago = valorPago;
        this.cedulaCliente = cedulaCliente;
        this.cedulaAsesor = cedulaAsesor;
        this.fecha = fecha;
    }

    public int getNumPago() {
        return numPago;
    }

    public void setNumPago(int numPago) {
        this.numPago = numPago;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCedulaAsesor() {
        return cedulaAsesor;
    }

    public void setCedulaAsesor(String cedulaAsesor) {
        this.cedulaAsesor = cedulaAsesor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
