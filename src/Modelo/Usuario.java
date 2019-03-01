/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase que contiene los atributos del generales de todos los usuarios del
 * sistema.
 *
 * @author sam33
 */
public abstract class Usuario {
    /**
     * ID del cliente.
     */
    public String ID;
    /**
     * Nombre del cliente.
     */
    public String nombre;
    /**
     * Contrasenia del administrador.
     */
    public String contrasenia;
    
    public Usuario(){
        
    }
    /**
     * Constructor de la clase Usuario.
     *
     * @param ID contiene la clave unica del usuario.
     * @param nombre contiene el nombre del usuario.
     * @param contrasenia contiene la contraseña para acceder a la cuenta.
     */
    public Usuario(String ID, String nombre, String contrasenia) {
        this.ID = ID;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
    //Metodos get y set
    /**
     * Metodo para obtener el ID del usuario.
     *
     * @return ID con la clave del uauario.
     */
    public String getID() {
        return ID;
    }
    /**
     * Metodo para establecer el ID del usuario.
     *
     * @param ID contiene un string.
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * Metodo para obtener el nombre del usuario.
     *
     * @return nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para establecer el nombre del usuario.
     *
     * @param nombre contiene un string.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para obtener la contrasenia del usuario.
     * @return contrasenia contiene un string.
     */
    public String getContrasenia() {
        return contrasenia;
    }
    /**
     * Metodo para establecer la contrasenia del usuario.
     * @param contrasenia contiene una cadena ingresada por el usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
