package Dominio;

// Clase entidad para manejar la informacion de las ventas, incluyendo su constructor, sus getters y sus setters.

public class Venta {
    private int precioTotal, numeroCuotas, intereses;
    private String cedulaCliente, cedulaAsesor;

    public Venta(int precioTotal, int numeroCuotas, int intereses, String cedulaCliente, String cedulaAsesor) {
        this.precioTotal = precioTotal;
        this.numeroCuotas = numeroCuotas;
        this.intereses = intereses;
        this.cedulaCliente = cedulaCliente;
        this.cedulaAsesor = cedulaAsesor;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public int getIntereses() {
        return intereses;
    }

    public void setIntereses(int intereses) {
        this.intereses = intereses;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
 
    public String getcedulaAsesor(){
        return cedulaAsesor;
    }

    public void setcedulaAsesor(String cedulaAsesor){
        this.cedulaAsesor = cedulaAsesor;
    }
    
}
