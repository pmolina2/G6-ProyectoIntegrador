<<<<<<< Updated upstream:CONTROLADOR/Torre.java
package CONTROLADOR;

// Clase entidad para manejar la informacion de las torres., incluyendo su constructor, sus getters y sus setters.

public class Torre {
    @SuppressWarnings("unused")
    private String id, numTorre, numApartamento, idProyecto;

    public Torre(String id, String numTorre, String numApartamento, String idProyecto) {
        this.id = id;
        this.numTorre = numTorre;
        this.numApartamento = numApartamento;
        this.idProyecto = idProyecto;
    }
=======
package Dominio;

// Clase entidad para manejar la informacion de las torres., incluyendo su constructor, sus getters y sus setters.

public class Torre {
    private String id, numTorre, numApartamento, idProyecto;

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

    
    
>>>>>>> Stashed changes:Dominio/Torre.java
}