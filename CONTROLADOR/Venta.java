package CONTROLADOR;

// Clase entidad para manejar la informacion de las ventas, incluyendo su constructor, sus getters y sus setters.

public class Venta {
    private int precioTotal, numeroCuotas, intereses;
    private String cedulaCliente;

    public Venta(int precioTotal, int numeroCuotas, int intereses, String cedulaCliente) {
        this.precioTotal = precioTotal;
        this.numeroCuotas = numeroCuotas;
        this.intereses = intereses;
        this.cedulaCliente = cedulaCliente;
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
    
    
    
}
