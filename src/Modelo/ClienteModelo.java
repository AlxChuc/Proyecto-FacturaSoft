/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Samantha Caamal.
 */
public class ClienteModelo extends Usuario {

    /**
     * Direccion del cliente.
     */
    public String direccion;
    /**
     * Telefono del cliente.
     */
    public int telefono;
    /**
     * Edad del cliente.
     */
    public int edad;
    /**
     * Contador para el ID.
     */
    public int contador = 1000;
    /**
     * Constructor de la clase.
     * @param nombre
     * @param contrasenia
     * @param direccion
     * @param telefono
     * @param edad 
     */
    public ClienteModelo(String ID, String nombre, String contrasenia, String direccion, int telefono, int edad) {
        super(ID, nombre, contrasenia);
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
    }
    //Metodos get y set

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
    //Metodos abstractos
    @Override
    public void setContrasenia(String contrasenia) {
        super.setContrasenia(contrasenia);
    }

    @Override
    public String getContrasenia() {
        return super.getContrasenia();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setID(String ID) {
        super.setID(ID);
    }

    @Override
    public String getID() {
        return "C" + super.getID();
    }
    @Override
    public String toString() {
        return "Cliente (" + "ID: "+ ID +", Nombre "+ nombre + ", Edad: " + edad + ')';
    }
    
}
