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
public class ClienteModelo {
    /**
     * ID del cliente.
     */
    private String ID;
    /**
     * Nombre del cliente.
     */
    private String nombre;
    /**
     * Direccion del cliente.
     */
    private String direccion;
    /**
     * Telefono del cliente.
     */
    private int telefono;
    /**
     * Edad del cliente.
     */
    private int edad;
    /**
     * Contraseña del cliente.
     */
    private String contrasenia;
    /**
     * Constructor de la clase Cliente.
     * @param ID contiene el clave unica del cliente.
     * @param nombre contiene el nombre completo del cliente.
     * @param direccion contiene la direccion del cliente.
     * @param telefono contiene el numero telefonico del cliente.
     * @param edad contiene la edad del cliente.
     * @param contrasenia contiene la contraseña de su cuenta.
     */
    public ClienteModelo(String ID, String nombre, String direccion, int telefono, int edad, String contrasenia){
        this.ID = ID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.contrasenia = contrasenia;
    }
    /**
     * Metodos get y set de las variables
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
