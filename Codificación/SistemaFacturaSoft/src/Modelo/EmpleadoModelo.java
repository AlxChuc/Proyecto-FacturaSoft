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
public class EmpleadoModelo extends Usuario {

    /**
     * Edad del empleado.
     */
    public int edad;
    /**
     * Salario del empleado.
     */
    public double salario;

    public EmpleadoModelo(String ID, String nombre, String contrasenia, int edad, double salario) {
        super(ID, nombre, contrasenia);
        this.edad = edad;
        this.salario = 1000;
    }
    //Metodos get y set

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        return "B" + super.getID();
    }
}
