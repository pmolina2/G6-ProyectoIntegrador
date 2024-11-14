package Dominio;
//Clase entidad que guarda la informacion de los asesores.
public class Cuota {
    //atributos necesarios para almacenar la info.
    private String id, valor, numeroCuota, estado, cedulaCliente, fechaCuota;

    //Constructor para darle valores a los atributos.
    public Cuota(String id, String valor, String numeroCuota, String estado, String cedulaCliente, String fechaCuota) {
        this.id = id;
        this.valor = valor;
        this.numeroCuota = numeroCuota;
        this.estado = estado;
        this.cedulaCliente = cedulaCliente;
        this.fechaCuota = fechaCuota;
    }

    //getters para obtener los datos de los atributos y setters para modificar sus datos.
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
