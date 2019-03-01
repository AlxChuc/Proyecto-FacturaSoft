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
public class ProductoModelo {
    public String idProducto;
    public String descripcion;
    public int cantidad;
    public double precioUnitario;
    public double importe;

    public ProductoModelo(String idProducto, String descripcion, int cantidad, double precioUnitario, double importe) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public ProductoModelo() {
        
    }
    
    //Metodos get y set
    public String getIdProducto() {
        return "P" + idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return this.idProducto + "/" + this.descripcion + "/" + this.cantidad + "/" + this.precioUnitario;
    }
    
    
    
}
