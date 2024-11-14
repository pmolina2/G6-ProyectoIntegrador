package Dominio;

//Clase entidad que guarda la informacion de los apartamentos.
public class Apartamento{
    
    //atributos necesarios para almacenar la info.
    private String matricula, numApto, tipoUnidad, area, valorApto;

    //Constructor para darle valores a los atributos.
    public Apartamento(String matricula, String numApto, String tipoUnidad, String area, String valorApto) {
        this.matricula = matricula;
        this.numApto = numApto;
        this.tipoUnidad = tipoUnidad;
        this.area = area;
        this.valorApto = valorApto;
    }

    //getters para obtener los datos de los atributos.
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
