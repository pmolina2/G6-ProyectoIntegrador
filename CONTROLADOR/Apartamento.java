package CONTROLADOR;

import java.util.Date;

public class Apartamento{
    
    private String matricula, numApto, tipoUnidad, area;
    private long valorApto;
    private Date fechaEscritura;

    public Apartamento(String matricula, String numApto, String tipoUnidad, String area, long valorApto, Date fechaEscritura) {
        this.matricula = matricula;
        this.numApto = numApto;
        this.tipoUnidad = tipoUnidad;
        this.area = area;
        this.valorApto = valorApto;
        this.fechaEscritura = fechaEscritura;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNumApto() {
        return numApto;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public String getArea() {
        return area;
    }

    public long getValorApto() {
        return valorApto;
    }

    public Date getFechaEscritura() {
        return fechaEscritura;
    }

    

}
