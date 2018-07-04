/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.EmpleadoModelo;
import Modelo.NotaModelo;
import Modelo.ProductoModelo;
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
    ComisionesEmpleadoVista cEV;
    
    public ComisionesEmpleadoControlador(ComisionesEmpleadoVista cEV,EmpleadoModelo empleado) {
        this.cEV = cEV;
        cEV.setLocationRelativeTo(null);
        cEV.getBtnSalir().addActionListener(this);
        
        cEV.getjTable1().setModel(table(empleado.getNotas()));
        cEV.getjTable1().setAutoCreateRowSorter(true);
//        empleado.get
//        cEV.getjTable1();
//        cEV.getjTable1().getSelectedRow();
        
        cEV.setTitle("Comisiones por venta");
        cEV.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent aE){
        if(cEV.getBtnSalir() == aE.getSource()){
            cEV.dispose();
        }else{
            
        }
    }
    
    private DefaultTableModel table(ArrayList<NotaModelo> notas){
        DefaultTableModel aux = (DefaultTableModel)cEV.getjTable1().getModel();
        for (int i = 0; i < notas.size(); i++) {
            int id = notas.get(i).getNumNota();
            Date dat = notas.get(i).getFecha();
            double sub = 0;
            for (ProductoModelo producto : notas.get(i).getProductos()) {
                sub += producto.getImporte();
            }
//            double can = sub;
            double prix = sub*0.05;
//            double sub = notas.get(i).getImporte();
            aux.addRow(new Object[]{id,dat,sub,prix});
        }
        return aux;
    }
}
