/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ConexionBd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pierr
 */

// Clase para el inicio de sesion
public class InicioSesionC {

    ConexionBd conexion = new ConexionBd();
    
    //método para verificar el inicio de sesión
    public ArrayList<String> verificacionInicio(String cedula, String contraseña){
        
        ArrayList<String> datos = new ArrayList<>();
        
        try {
            ResultSet asesor = conexion.consultarBd("asesor");
            ResultSet administrador = conexion.consultarBd("administrador");
            
            while(asesor.next()){
                String cedAsesor = asesor.getString("cedula");
                String contraAsesor = asesor.getString("contrasenna");
                
                if (cedAsesor.equals(cedula) && contraAsesor.equals(contraseña)){
                    datos.add(cedula);
                    datos.add(contraseña);
                    datos.add("asesor");
                    
                    
                    return datos;
                }
                
            }
            
            while(administrador.next()){
                String cedAdmin = administrador.getString("cedula");
                String contraAdmin = administrador.getString("contrasenna");
                
                if(cedAdmin.equals(cedula) && contraAdmin.equals(contraseña)){
                    datos.add(cedula);
                    datos.add(contraseña);
                    datos.add("administrador");
                    
                    return datos;
                } else {
                    return null;
                }
               
            }            
        } catch(SQLException sqlx){
            System.out.println("Error "+sqlx.getMessage());
        }
        return null;
    }
   
    // metodo para obtener la informacion del asesor
}
