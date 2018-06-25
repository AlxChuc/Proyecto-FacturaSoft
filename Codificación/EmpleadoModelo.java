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
public class EmpleadoModelo {
    /**
     * ID del empleado.
     */
    private String ID;
    /**
     * Nombre completo del empleado.
     */
    private String nombre;
    /**
     * Edad del empleado.
     */
    private int edad;
    /**
     * Contraseña del empleado.
     */
    private String contrasenia;
    /**
     * Salario del empleado.
     */
    private double salario;
    /**
     * Constructor de la clase Empleado.
     * @param ID contiene la clave unica del empleado.
     * @param nombre contiene el nombre completo del empleado.
     * @param edad contiene la edad del empleado.
     * @param contrasenia contiene la contraseña para acceder a su cuenta.
     */
    public EmpleadoModelo(String ID, String nombre, int edad, String contrasenia){
        this.ID = ID;
        this.nombre = nombre;
        this.edad = edad;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
