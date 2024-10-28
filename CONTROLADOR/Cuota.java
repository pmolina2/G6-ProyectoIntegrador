package CONTROLADOR;
import java.util.Date;

//Clase entidad para manejar la información de las cuotas, incluyendo su constructor y sus getters y setters.

public class Cuota {
    private int id, valor, numeroCuota;
    private String estado, cedulaCliente;
    private Date fechaCuota;

    public Cuota(int id, int valor, int numeroCuota, String estado, String cedulaCliente, Date fechaCuota) {
        this.id = id;
        this.valor = valor;
        this.numeroCuota = numeroCuota;
        this.estado = estado;
        this.cedulaCliente = cedulaCliente;
        this.fechaCuota = fechaCuota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Date getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(Date fechaCuota) {
        this.fechaCuota = fechaCuota;
    }
    
    
    
}
