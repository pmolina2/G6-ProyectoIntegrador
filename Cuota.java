/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import java.util.Date;

/**
 *
 * @author gutie
 */
public class Cuota {
    private int id, valor, numeroCuota;
    private String estado, cedullaCliente;
    private Date fechaCuota;

    public Cuota(int id, int valor, int numeroCuota, String estado, String cedullaCliente, Date fechaCuota) {
        this.id = id;
        this.valor = valor;
        this.numeroCuota = numeroCuota;
        this.estado = estado;
        this.cedullaCliente = cedullaCliente;
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

    public String getCedullaCliente() {
        return cedullaCliente;
    }

    public void setCedullaCliente(String cedullaCliente) {
        this.cedullaCliente = cedullaCliente;
    }

    public Date getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(Date fechaCuota) {
        this.fechaCuota = fechaCuota;
    }
    
    
    
}
