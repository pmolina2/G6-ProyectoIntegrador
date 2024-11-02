package Dominio;

public class Apartamento{
    
    private String matricula, numApto, tipoUnidad, area, valorApto;

    public Apartamento(String matricula, String numApto, String tipoUnidad, String area, String valorApto) {
        this.matricula = matricula;
        this.numApto = numApto;
        this.tipoUnidad = tipoUnidad;
        this.area = area;
        this.valorApto = valorApto;
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

    public String getValorApto() {
        return valorApto;
    }

    

}
