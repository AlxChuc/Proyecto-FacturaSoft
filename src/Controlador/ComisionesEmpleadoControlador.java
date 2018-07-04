/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.ComisionesEmpleadoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class ComisionesEmpleadoControlador implements ActionListener{
    /**
     * Vista de la comision del empleado
     */
    ComisionesEmpleadoVista cEV;
    /**Ajusta la vista recibida  y agrega los valores iniciales de los elementos
     * @param cEV ComisionesEmpleadoVista
     * @param empleado EmpleadoModelo
     */
    public ComisionesEmpleadoControlador(ComisionesEmpleadoVista cEV,EmpleadoModelo empleado) {
        this.cEV = cEV;
        cEV.setLocationRelativeTo(null);
        cEV.getBtnSalir().addActionListener(this);
        
        cEV.getjTable1().setModel(table(empleado.getNotas()));
        cEV.getjTable1().setAutoCreateRowSorter(true);
        
        cEV.setTitle("Comisiones por venta");
        cEV.setVisible(true);
    }
    
    /**
     *Selecciona que accion se realizo, en otras palabras, que fue lo que se
     * presiono, para invocar una accion.
     * @param aE ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent aE){
        if(cEV.getBtnSalir() == aE.getSource()){
            cEV.dispose();
        }
    }
    /**Recibe un ArrayList que descompone y acomoda en una DefaultTableModel
     * @param notas ArrayList de tipo NotaModelo
     * @return DefaultTableModel con los datos del arreglo
     */
    private DefaultTableModel table(ArrayList<NotaModelo> notas){
        DefaultTableModel aux = (DefaultTableModel)cEV.getjTable1().getModel();
        for (int i = 0; i < notas.size(); i++) {
            int id = notas.get(i).getNumNota();
            Date dat = notas.get(i).getFecha();
            double sub = 0;
            for (ProductoModelo producto : notas.get(i).getProductos()) {
                sub += producto.getCantidad() * producto.getPrecioUnitario();
            }
            double prix = sub*0.05;
            aux.addRow(new Object[]{id,dat,sub,prix});
        }
        return aux;
    }
}
