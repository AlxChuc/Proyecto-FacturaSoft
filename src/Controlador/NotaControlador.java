/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.NotaVista;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class NotaControlador implements ActionListener, ItemListener, KeyListener {

    /**
     * el total de la compra
     */
    private double total;
    /**
     * La vista de la nota
     */
    private NotaVista nV;

    /**
     * El modelo de la nota
     */
    private NotaModelo nota;

    /**
     * Ajusta la vista de la nota e inicializa los valores, además de que agrega
     * a los objetos sus eventos correspondientes
     *
     * @param nV NotaVista
     * @param nota NotaModelo
     */
    public NotaControlador(NotaVista nV, NotaModelo nota) {
        this.nV = nV;
        this.nota = nota;
        this.total = 0;

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

        nV.setLocationRelativeTo(null);
        nV.getjTable1().setEnabled(false);
        nV.getjTable1().setAutoCreateRowSorter(true);
        nV.setTitle("Nota");
        nV.setVisible(true);
    }

    /**
     * Selecciona que accion se realizo, en otras palabras, que fue lo que se
     * presiono, para invocar una accion.
     *
     * @param ae ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (nV.getBtnCancelar() == ae.getSource()) {
            nV.dispose();

        } else {
            if (nV.getComBoxPago() == ae.getSource()) {
                nV.getTxtCantidad().setEnabled(false);

            } else {
                if (nV.getBtnBuscar() == ae.getSource()) {
                    ClienteModelo c = buscarCliente(new ArrayList<>());
                    if (c != null) {
                        addDatosCliente((ClienteModelo) c);
                    }

                } else {
                    if (nV.getBtnPagar() == ae.getSource()) {
                        //Código para agregarselo a empleado y cliente
                        /*Cuando le de pagar se va a buscar el producto que tiene con 
                        el original por ID, cuando lo encuentre, se tiene que restar 
                        la cantidad en stock con la que compró el cliente y se actualiza la tabla*/
                        nota.getEmpleado().getNotas().add(nota);
                        nota.masUno();
                        JOptionPane.showMessageDialog(null, "Pago exitoso");
                        nV.getBtnPagar().setEnabled(false);
                    }
                }
            }
        }
    }

    /**
     * Busca el cliente a traves del id/nombre que se espeficique en el
     * textField de busqueda
     *
     * @param cliente ArrayList de tipo ClienteModelo
     * @return ClienteModelo que coincida con la busqueda
     */
    private ClienteModelo buscarCliente(ArrayList<ClienteModelo> cliente) {

        Object[] os = {"alec", "dos", "tres", "cuatro"};
        Modelo.EmpleadoModelo an = new Modelo.EmpleadoModelo("0", "al", "pass", 20);
        Modelo.EmpleadoModelo ann = new Modelo.EmpleadoModelo("1", "car", "pass", 19);

        ClienteModelo an1 = new ClienteModelo("0", "al", "pass", "Calle 36", 9992, 20);
        ClienteModelo ann2 = new ClienteModelo("1", "car", "pass", "c 45", 9887, 19);
        java.util.List<Modelo.ClienteModelo> lista = new java.util.ArrayList<>();

        lista.add(an1);
        lista.add(ann2);
        /*
        List<ClienteModelo> aux = new ArrayList<>();
        for(int i = 0; i <cliente.size(); i++){
            if(cliente.get(i).getID().equals(nV.getTxtBuscar().getText())){
              list.add(cliente.get(i));                  
        }
        }
         */
        Object[] nul = lista.toArray();

        Object s = JOptionPane.showInputDialog(null, "Escoja", "Clientes",
                JOptionPane.QUESTION_MESSAGE, null, nul, null);

        return (ClienteModelo) s;
    }

    /**
     * Verifica los subtotales de cada producto y los suma para agregarlo al
     * total, en un textField
     */
    private void total() {
        int filas = nV.getjTable1().getModel().getRowCount();
        for (int j = 0; j < filas; j++) {
            total += Double.parseDouble(String.valueOf(nV.getjTable1().getModel().getValueAt(j, 4)));
        }
        nV.getTxtTotal().setText(String.valueOf(total));
    }

    /**
     * Selecciona cual item esta actualmente puesto y con base en su indice se
     * determina que accion hacer, si es 1 se eligio la tarjeta, si es diferente
     * entonces fue el efectivo
     *
     * @param ie ItemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent ie) {

        if (nV.getComBoxPago().getSelectedIndex() == 1) {
            nV.getTxtCantidad().setEnabled(false);
            nV.getTxtCantidad().setText(String.valueOf(total));
            nV.getTxtCambio().setText("0.0");
        } else {
            nV.getTxtCantidad().setEnabled(true);
        }
    }

    /**
     * Se presiona cuando se escribe una tecla
     *
     * @param ke KeyEvent
     */
    @Override
    public void keyTyped(KeyEvent ke) {

    }

    /**
     * Se activa cuando se presiona una tecla
     *
     * @param ke KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent ke) {
    }

    /**
     * Se activa cuando se libera una tecla
     *
     * @param ke KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        if (nV.getTxtCantidad() == ke.getSource()) {
            cambio();
        }
    }

    /**
     * Captura el valor que se encuentra en el textField de Cantitdad y lo usa
     * para sacar el cambio del cliente
     */
    private void cambio() {
        //CATCH Por si no entra un número
        try {
            double dinero = Double.parseDouble(nV.getTxtCantidad().getText());
            double cambio = dinero - total;
            if (cambio >= 0) {
                nV.getTxtCambio().setText(String.valueOf(cambio));
            } else {
                nV.getTxtCambio().setText("");
            }
        } catch (NumberFormatException e) {
            nV.getTxtCambio().setText("");
        }
    }

    /**
     * Agrega los valores del cliente a la vista
     *
     * @param cliente ClienteModelo
     */
    private void addDatosCliente(ClienteModelo cliente) {
        nV.getTxtCodigo().setText(cliente.getID());
        nV.getTxtNombre().setText(cliente.getNombre());
        nV.getTxtTelefono().setText(String.valueOf(cliente.getTelefono()));
        nV.getTxtDireccion().setText(cliente.getDireccion());
    }

    /**
     * Recibe un arreglo que descompone y ajusta en un DefaultTableModel
     *
     * @param s ArrayList de tipo ProductoModelo
     * @return regresa un DefaultTableModel con los datos del arreglo
     */
    private DefaultTableModel defTableModel(ArrayList<ProductoModelo> s) {
        DefaultTableModel aux = (DefaultTableModel) nV.getjTable1().getModel();
        for (int i = 0; i < s.size(); i++) {
            String id = s.get(i).getIdProducto();
            String des = s.get(i).getDescripcion();
            int can = s.get(i).getCantidad();
            double prix = s.get(i).getPrecioUnitario();
            double sub = can*prix;
            aux.addRow(new Object[]{id, des, can, prix, sub});
        }
        return aux;
    }
}
