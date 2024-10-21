/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

/**
 *
 * @author gutie
 */

public class Proyecto {
    @SuppressWarnings("unused")
    private String id, nombre, direccion;
    @SuppressWarnings("unused")
    private int numTorres;

    public Proyecto(String id, String nombre, String direccion, int numTorres) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTorres = numTorres;
    }

}