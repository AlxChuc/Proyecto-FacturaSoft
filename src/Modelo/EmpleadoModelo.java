/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
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
    
    private ArrayList<NotaModelo> notas;
    
    public EmpleadoModelo(String ID, String nombre, String contrasenia, int edad) {
        super(ID, nombre, contrasenia);
        this.edad = edad;
        this.salario = 1000;
        this.notas = new ArrayList<>();
    }
    //Metodos get y set

    /**
     *Obtiene la edad del empleado
     * @return tipo int edad del empleado
     */
    public int getEdad() {
        return edad;
    }

    /**
     *Establece la edad del empleado
     * @param edad int, la edad del empleado
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *Obtiene el salario del empleado
     * @return double, salario del empleado
     */
    public double getSalario() {
        return salario;
    }
/**
 * Establece el salario del empleado
 * @param salario double, el salario del empleado
 */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     *Devuelve un arreglo con las notas(lo que ha vendido) del empleado
     * @return ArrayList de las notas del Empleado
     */
    public ArrayList<NotaModelo> getNotas() {
        return notas;
    }
    
//    @Override
//    public void setContrasenia(String contrasenia) {
//        super.setContrasenia(contrasenia);
//    }
//
//    @Override
//    public String getContrasenia() {
//        return super.getContrasenia();
//    }
//
//    @Override
//    public void setNombre(String nombre) {
//        super.setNombre(nombre);
//    }
//
//    @Override
//    public String getNombre() {
//        return super.getNombre();
//    }
//
//    @Override
//    public void setID(String ID) {
//        super.setID(ID);
//    }

    @Override
    public String getID() {
        return "B" + super.getID();
    } 

    @Override
    public String toString() {
        return "EmpleadoModelo(" + "ID: "+ ID +", Nombre "+ nombre + ", Edad: " + edad + ')';
    }
    
    
}
