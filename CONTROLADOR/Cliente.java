package CONTROLADOR;

//Clase para manejar la informacion de cliente, incluyendo su constructor, getters y setters.

public class Cliente {
    private String cedula, nombre, apellido, direccion, correoElectronico, sisben;
    private int telefono;
    private boolean subsidio;

    public Cliente(String cedula, String nombre, String apellido, String direccion, String correoElectronico, String sisben, int telefono, boolean subsidio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.sisben = sisben;
        this.telefono = telefono;
        this.subsidio = subsidio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSisben() {
        return sisben;
    }

    public void setSisben(String sisben) {
        this.sisben = sisben;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isSubsidio() {
        return subsidio;
    }

    public void setSubsidio(boolean subsidio) {
        this.subsidio = subsidio;
    }
    
    
    
}
