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
}