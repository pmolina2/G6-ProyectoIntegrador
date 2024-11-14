package Dominio;
import java.util.Date;

//Clase entidad que guarda la informacion de los asesores.
public class Pago {
    //atributos necesarios para almacenar la info.
    private int numPago, valorPago;
    private String cedulaCliente, cedulaAsesor;
    private Date fecha;

    //Constructor para darle valores a los atributos.
    public Pago(int numPago, int valorPago, String cedulaCliente, String cedulaAsesor, Date fecha) {
        this.numPago = numPago;
        this.valorPago = valorPago;
        this.cedulaCliente = cedulaCliente;
        this.cedulaAsesor = cedulaAsesor;
        this.fecha = fecha;
    }

    //getters para obtener los datos de los atributos y setters para modificar sus datos.
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
