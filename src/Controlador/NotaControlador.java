/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClienteModelo;
import Modelo.EmpleadoModelo;
import Modelo.NotaModelo;
import Modelo.ProductoModelo;
import Vista.NotaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alex
 */
public class NotaControlador implements ActionListener, ItemListener, KeyListener{
    private double total;
    private NotaVista nV;
    private EmpleadoModelo empleadoM;
    private NotaModelo nota;
//    java.util.Date n = new java.util.Date();

    public NotaControlador(NotaVista nV, NotaModelo nota) {
        this.empleadoM = nota.getEmpleado();
        this.nota = nota;
        this.total = 0;
        this.nV = nV;
        nV.getTxtVendedor().setText(nota.getEmpleado().getNombre());
        nV.getTxtFecha().setValue(nota.getFecha());
        nV.getTxtNumFact().setText(String.valueOf(nota.getNumNota()));
        
        nV.getBtnCancelar().addActionListener(this);
        nV.getBtnBuscar().addActionListener(this);
        nV.getComBoxPago().addItemListener(this);
        nV.getTxtCantidad().addKeyListener(this);
        nV.getBtnPagar().addActionListener(this);
        nV.getBtnFactura().addActionListener(this);
        
        nV.getjTable1().setModel(defTableModel(nota.getProductos()));
        
        total();
//        nV.getTxtTotal().setText(String);
        nV.setLocationRelativeTo(null);
        nV.getjTable1().setEnabled(false);
        nV.getjTable1().setAutoCreateRowSorter(true);
        nV.setTitle("Nota");
        nV.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (nV.getBtnCancelar() == ae.getSource()) {
            nV.dispose();
        }else{
            if(nV.getComBoxPago() == ae.getSource()){
                nV.getTxtCantidad().setEnabled(false);
            }else{
                if(nV.getBtnBuscar() == ae.getSource()){
                    Object[] os = {"alec","dos","tres","cuatro"};
                    Modelo.EmpleadoModelo an = new Modelo.EmpleadoModelo("0", "al", "pass",20);
                    Modelo.EmpleadoModelo ann = new Modelo.EmpleadoModelo("1", "car", "pass",19);
                    
                    ClienteModelo an1 = new ClienteModelo("0", "al", "pass","Calle 36",9992,20);
                    ClienteModelo ann2 = new ClienteModelo("1", "car", "pass","c 45",9887,19);
                    java.util.List<Modelo.ClienteModelo> lista = new java.util.ArrayList<>();
                    
                    
                    
                    lista.add(an1);
                    lista.add(ann2);
                    Object[] nul = lista.toArray();
//                    javax.swing.JFrame frame = new javax.swing.JFrame();
                    Object s = JOptionPane.showInputDialog(null, "Escoja", "Clientes", JOptionPane.QUESTION_MESSAGE, null, nul, null);
                    if(s != null){
                        addDatosCliente((ClienteModelo)s);
                    }
//                    System.out.println((Modelo.EmpleadoModelo)s);
                }else{
                    if(nV.getBtnPagar() == ae.getSource()){
                        //Código para agregarselo a empleado y cliente
                        /*Cuando le de pagar se va a buscar el producto que tiene con 
                        el original por ID, cuando lo encuentre, se tiene que restar 
                        la cantidad en stock con la que compró el cliente y se actualiza la tabla*/
                        nota.getEmpleado().getNotas().add(nota);
                        nota.masUno();
                        JOptionPane.showMessageDialog(null, "Pago exitoso");
                        nV.getBtnPagar().setEnabled(false);
//                        nV.dispose();
//                        new Modelo.NotaModelo(new java.util.ArrayList<>()).masUno();
                    }
                }
            }
        }
    }

    private void total() {

        int filas = nV.getjTable1().getModel().getRowCount();
        for (int j = 0; j < filas; j++) {
            total += Double.parseDouble(String.valueOf(nV.getjTable1().getModel().getValueAt(j, 4)));
        }
        nV.getTxtTotal().setText(String.valueOf(total));
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
//        System.out.print(nV.getComBoxPago().getSelectedIndex());
        if(nV.getComBoxPago().getSelectedIndex() == 1){
            nV.getTxtCantidad().setEnabled(false);
            nV.getTxtCantidad().setText(String.valueOf(total));
            nV.getTxtCambio().setText("0.0");
//            System.out.print(" Tarjeta");
        }else{
            nV.getTxtCantidad().setEnabled(true);
            
//            System.out.print(" Efectivo");
            
        }
//        System.out.println("");
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(nV.getTxtCantidad() == ke.getSource()){
            //CATCH Por si no entra un número
            try{
                double dinero = Double.parseDouble(nV.getTxtCantidad().getText());
            double cambio = dinero-total;
            if(cambio >= 0){
                nV.getTxtCambio().setText(String.valueOf(cambio));
            }else{
                nV.getTxtCambio().setText("");
            }
            }catch(NumberFormatException e){
                nV.getTxtCambio().setText("");
            }
        }
    }
    
    private void addDatosCliente(ClienteModelo cliente){
        nV.getTxtCodigo().setText(cliente.getID());
        nV.getTxtNombre().setText(cliente.getNombre());
        nV.getTxtTelefono().setText(String.valueOf(cliente.getTelefono()));
        nV.getTxtDireccion().setText(cliente.getDireccion());
    }
    
    private DefaultTableModel defTableModel(ArrayList<ProductoModelo> s){
        DefaultTableModel aux = (DefaultTableModel)nV.getjTable1().getModel();
        for (int i = 0; i < s.size(); i++) {
            String id = s.get(i).getIdProducto();
            String des = s.get(i).getDescripcion();
            int can = s.get(i).getCantidad();
            double prix = s.get(i).getPrecioUnitario();
            double sub = s.get(i).getImporte();
            aux.addRow(new Object[]{id,des,can,prix,sub});
        }
        return aux;
    }
}
