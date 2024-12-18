package Dominio;

//Clase entidad que guarda la informacion de los asesores.
public class Torre {

    //atributos necesarios para almacenar la info.
    @SuppressWarnings("unused")
    private String id, numTorre, numApartamento, idProyecto;

    //Constructor para darle valores a los atributos.
    public Torre(String id, String numTorre, String numApartamento, String idProyecto) {
        this.id = id;
        this.numTorre = numTorre;
        this.numApartamento = numApartamento;
        this.idProyecto = idProyecto;
    }

    public String getId() {
        return id;
    }

    public String getNumTorre() {
        return numTorre;
    }

    public String getNumApartamento() {
        return numApartamento;
    }

    public String getIdProyecto() {
        return idProyecto;
    }
}