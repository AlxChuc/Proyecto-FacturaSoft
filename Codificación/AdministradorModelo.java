/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ElenaMariel
 */
public class AdministradorModelo {
    /**
     * ID del administrador.
     */
    private String ID;
    /**
     * Nombre del administrador.
     */
    private String nombre;
    /**
     * Contrasenia del administrador.
     */
    private String contrasenia;
    /**
     * Constructos de la clase Administrador.
     * @param ID contiene la clave unica del administrador.
     * @param nombre contiene el nombre completo del administrador.
     * @param contrasenia contiene la contrasenia del administrador.
     */
    public AdministradorModelo(String ID, String nombre, String contrasenia){
        this.ID = ID;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
    /**
     * Metodos get y set de las variables.
     */
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
