/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class NotaModelo {
    /**
     * El numero de la nota
     */
    private  int numNota;
    /**
     * actualizacion del numero de la nota
     */
    private static int staticValue;
    /**
     * arreglo de productos
     */
    private ArrayList<ProductoModelo> productos;
    /**
     * la fecha (para poner la de hoy)
     */
    private Date fecha;
    /**
     * empleado a quien pertenece la nota
     */
    private EmpleadoModelo empleado;
    
    public NotaModelo(ArrayList<ProductoModelo> vendidos, EmpleadoModelo empleado) {
        this.numNota = staticValue;
        this.empleado = empleado;
        this.productos = vendidos;
        this.fecha = Calendar.getInstance().getTime();
    }

    /**
     *obtiene el numero de la nota
     * @return int, numero de la nota
     */
    public int getNumNota() {
        return numNota;
    }

    /**
     *
     * @return
     */
    public ArrayList<ProductoModelo> getProductos() {
        return productos;
    }

    /**
     *aumenta el valor de la variable estatica
     */
    public void masUno(){
        staticValue++;
    }

    /**
     *obtiene el empleado de la nota
     * @return EmpleadoModelo, quien hizo la nota
     */
    public EmpleadoModelo getEmpleado() {
        return empleado;
    }

    /**
     *obtiene la fecha de hoy
     * @return Date, la fecha de hoy
     */
    public Date getFecha() {
        return fecha;
    }
}
