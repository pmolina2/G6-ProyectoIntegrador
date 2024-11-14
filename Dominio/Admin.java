package Dominio;

//Clase entidad que guarda la informacion de los administradores.
public class Admin {

    //atributos necesarios para almacenar la info.
    private String cedula, nombreCompleto, direccion, telefono, correoElectronico, contrasenna;

    //Constructor para darle valores a los atributos.
    public Admin(String cedula, String nombreCompleto, String direccion, String telefono, String correoElectronico,
            String contrasenna) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasenna = contrasenna;

    }

    //getters para obtener los datos de los atributos y setters para modificar sus datos.

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

}