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
    private  int numNota;
    private static int staticValue;
    private ArrayList<ProductoModelo> productos;
    private Date fecha;
    private EmpleadoModelo empleado;
    
    public NotaModelo(ArrayList<ProductoModelo> vendidos, EmpleadoModelo empleado) {
        this.numNota = staticValue;
        this.empleado = empleado;
        this.productos = vendidos;
        this.fecha = Calendar.getInstance().getTime();
    }

    public int getNumNota() {
        return numNota;
    }

    public ArrayList<ProductoModelo> getProductos() {
        return productos;
    }

    public void masUno(){
        staticValue++;
    }

    public EmpleadoModelo getEmpleado() {
        return empleado;
    }

    public Date getFecha() {
        return fecha;
    }
}
