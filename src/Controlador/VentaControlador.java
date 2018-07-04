/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.NotaVista;
import Vista.VentaVista;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class VentaControlador implements ActionListener, MouseListener, KeyListener {

    /**
     *La vista de la venta
     */
    VentaVista vV;
    /**
     *La tabla del carrito de compras
     */
    private DefaultTableModel mode;
    /**
     *El empleado que hace la venta
     */
    EmpleadoModelo empleadoM;

    /**
     *Inicializa las variables, ajusta la vista y 
     * agrega los objetos a sus eventos
     * @param vV VentaVista
     * @param empleado EmpleadoModelo
     */
    public VentaControlador(VentaVista vV, EmpleadoModelo empleado) {
        this.vV = vV;
        this.empleadoM = empleado;
        this.mode = (DefaultTableModel) vV.getTbCarrito().getModel();
        
        vV.getTbProductos().setAutoCreateRowSorter(true);
        vV.getTbCarrito().setAutoCreateRowSorter(true);
        vV.getTxtTotal().setText(null);
        vV.getBtnNota().setEnabled(false);
        vV.setLocationRelativeTo(null);
        
        vV.getBtnNota().addActionListener(this);
        vV.getBtnCancelar().addActionListener(this);
        vV.getBtnRemover().addActionListener(this);
        vV.getTxtTotal().addActionListener(this);

        vV.getTbProductos().addMouseListener(this);
        vV.getTbCarrito().addMouseListener(this);
        vV.getTbCarrito().addKeyListener(this);

        vV.setTitle("Venta");
        vV.setVisible(true);
        vV.getTxtID().setText(empleado.getID());
    }

    /**
     * Selecciona que accion se realizo, en otras palabras, que fue lo que se
     * presiono, para invocar una accion.
     *
     * @param ae ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vV.getBtnNota() == ae.getSource()) {
            ArrayList<ProductoModelo> p = getProductos(mode);
//            NotaModelo nota = ;
            new NotaControlador(new NotaVista(), new NotaModelo(p, empleadoM));
        } else {
            if (vV.getBtnCancelar() == ae.getSource()) {
                vV.dispose();
            } else {
                if (vV.getBtnRemover() == ae.getSource()) {

                    if (vV.getTbCarrito().getSelectedRow() > -1) {
                        mode.removeRow(vV.getTbCarrito().getSelectedRow());
                        total();
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila");
                    }
                }
            }
        }
    }

    /**
     * Se activa cuando el mouse es cliqueado
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (vV.getTbProductos() == me.getSource()) {
//Solo era una prueba
            /*ProductoModelo n = new ProductoModelo("00", "a", 300, 20, 11);
            ProductoModelo n1 = new ProductoModelo("1", "b", 100, 30, 12);
            ProductoModelo n2 = new ProductoModelo("2", "c", 200, 10, 13);
            ArrayList<ProductoModelo> arr = new ArrayList<>();
            arr.add(n);
            arr.add(n1);
            arr.add(n2);
            addProductos(arr);*/
            pasarFila();
        } else {
            if (vV.getTbCarrito() == me.getSource()) {
                precioXcantidad();
                total();
            }
        }
    }

    /*El total hacerlo una función aparte y se lo paso al MOUSECLICKED y KEYRELEASED*/
    /**
     * Se activa cuando el mouse es presionado
     *
     * @param me MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent me) {
    }

    /**
     * Se activa cuando el mouse es liberado
     *
     * @param me MouseEvent
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    }

    /**
     * Se activa cuando el mouse entra en el objeto
     *
     * @param me MouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    /**
     * Se activa si el mouse se sale del objeto
     *
     * @param me MouseEvent
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }

    /*KeyReleased*/
    /**
     * Se activa cuando una tecla es escrita
     *
     * @param ke KeyEvent
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /**
     * Se activa cuando una tecla es presionada
     *
     * @param ke KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent ke) {
    }

    /**
     * Se activa cuando una tecla es soltada/liberada, verifica si el evento
     * pertenece a los puestos en la función
     *
     * @param ke KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        if (vV.getTbCarrito() == ke.getSource()) {
            ponerSubcosto();
        }
    }

    /**
     * Agrega el subcosto del producto seleccionado
     */
    private void ponerSubcosto() {
        int fila = vV.getTbCarrito().getSelectedRow();
        int columna = vV.getTbCarrito().getSelectedColumn();
        try {

            int cantidad = Integer.parseInt((String) vV.getTbCarrito().getModel().getValueAt(fila, columna));
            double precioUni = Double.parseDouble((String) vV.getTbCarrito().getModel().getValueAt(fila, columna + 1));
            vV.getTbCarrito().getModel().setValueAt(cantidad * precioUni, fila, 4);

            total();

        } catch (NumberFormatException s) {
            JOptionPane.showMessageDialog(null, "Dato inválido");
            vV.getTbCarrito().editCellAt(fila, columna);
        } catch (NullPointerException | ClassCastException ex) {
        }
    }

    /**
     * Obtiene el subtotal de cada producto en el carrito de compras y los suma
     * para obtener el costo total del carrito de compras (las compras que
     * realiza el cliente) y lo pone en el textfield
     */
    private void total() {
        double totalCompra = 0;

        int filas = vV.getTbCarrito().getModel().getRowCount();
        for (int j = 0; j < filas; j++) {
            totalCompra += Double.parseDouble(String.valueOf(vV.getTbCarrito().getModel().getValueAt(j, 4)));
        }
        /*El total de costo de todos los productos  en el carrito*/
        if (totalCompra > 0) {
            vV.getTxtTotal().setText(String.valueOf(totalCompra));
            vV.getBtnNota().setEnabled(true);
        } else {
            vV.getTxtTotal().setText("");
            vV.getBtnNota().setEnabled(false);
        }
    }

    /**
     * Agrega los productos que contenga el ArrayList ingresado, a la jTabla de
     * productos
     *
     * @param products ArryList de tipo ProductoModelo, en donde se encuentran
     * los productos
     */
    private void addProductos(ArrayList<ProductoModelo> products) {
        DefaultTableModel tableModel = (DefaultTableModel) vV.getTbProductos().getModel();
        String id;
        String desc;
        double prix;
        int cant;
        for (int i = 0; i < products.size(); i++) {

            id = products.get(i).getIdProducto();
            desc = products.get(i).getDescripcion();
            prix = products.get(i).getPrecioUnitario();
            cant = products.get(i).getCantidad();
            tableModel.addRow(new Object[]{id, desc, prix, cant});
        }
        vV.getTbProductos().setModel(tableModel);
    }

    /**
     * Asigna el costo total de cada producto con base a la cantidad que se
     * desea. Es un método auxiliar, en caso de hacer un cambio en la tabla de
     * tabla de carrito de compras y no aplicar/presionar enter.
     */
    private void precioXcantidad() {
        for (int i = 0; i < vV.getTbCarrito().getRowCount(); i++) {
            try {
                int cantidad = Integer.parseInt((String) vV.getTbCarrito().getModel().getValueAt(i, 2));
                double precioUni = Double.parseDouble((String) vV.getTbCarrito().getModel().getValueAt(i, 3));
                vV.getTbCarrito().getModel().setValueAt(cantidad * precioUni, i, 4);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Dato inváido");
                vV.getTbCarrito().editCellAt(i, 2);
            }
        }

    }

    /**
     * Crea un arreglo de ProductoModelo pasandole una DefaultTableModel
     *
     * @param model tipo DefaultTableModel
     * @return ArrayList<ProdutoModelo> con la tabla pasada
     */
    private ArrayList<ProductoModelo> getProductos(DefaultTableModel model) {
        ArrayList<ProductoModelo> arrayProd = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {

            String id = String.valueOf(model.getValueAt(i, 0));
            String des = String.valueOf(model.getValueAt(i, 1));
            int can = Integer.parseInt(String.valueOf(model.getValueAt(i, 2)));
            double prix = Double.parseDouble(String.valueOf(model.getValueAt(i, 3)));
            double sub = Double.parseDouble(String.valueOf(model.getValueAt(i, 4)));
            ProductoModelo e = new ProductoModelo(id, des, can, prix, sub);
            arrayProd.add(e);
        }
        return arrayProd;
    }

    /**
     * Al seleccionar una fila del primer jTable y se pasa al segundo
     */
    private void pasarFila() {
        int fila = vV.getTbProductos().getSelectedRow();
        String id = String.valueOf(vV.getTbProductos().getModel().getValueAt(fila, 0));
        String nombre = String.valueOf(vV.getTbProductos().getModel().getValueAt(fila, 1));
        String precio = String.valueOf(vV.getTbProductos().getModel().getValueAt(fila, 2));

        Object[] newRow = {id, nombre, "1", precio, Double.parseDouble(precio)};
        mode.addRow(newRow);
        vV.getTbCarrito().setModel(mode);
        total();
    }
}
