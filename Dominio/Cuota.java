package Dominio;
//Clase entidad para manejar la información de las cuotas, incluyendo su constructor y sus getters y setters.

public class Cuota {
    private String id, valor, numeroCuota, estado, cedulaCliente, fechaCuota;

    public Cuota(String id, String valor, String numeroCuota, String estado, String cedulaCliente, String fechaCuota) {
        this.id = id;
        this.valor = valor;
        this.numeroCuota = numeroCuota;
        this.estado = estado;
        this.cedulaCliente = cedulaCliente;
        this.fechaCuota = fechaCuota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(String numeroCuota) {
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

    public String getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(String fechaCuota) {
        this.fechaCuota = fechaCuota;
    }
    
    
    
}
