/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.CampoVacio;
import Modelo.Archivo;
import Vista.StockVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sam33
 */
class StockControlador implements ActionListener, MouseListener{
    /**
     * Variable para instanciar la vista de Stock.
     */
    private StockVista ventana;
    /**
     * Variable para 
     */
    private DefaultTableModel model;
    public JTable tabla;
    private JButton editar;
    private JButton eliminar;
    private JButton guardar;
    private JButton salir;
    private String id;
    private int indicador;
    
    StockControlador(StockVista vista) {
        this.ventana = vista;
        this.tabla = this.ventana.getTablaProductos();
        this.editar = this.ventana.getBtnEditar();
        this.ventana.getBtnEditar().addActionListener(this);
        this.eliminar = this.ventana.getBtnEliminar();
        this.ventana.getBtnEliminar().addActionListener(this);
        this.guardar = this.ventana.getBtnCambios();
        this.ventana.getBtnCambios().addActionListener(this);
        this.salir = this.ventana.getBtnSalir();
        this.ventana.getBtnSalir().addActionListener(this);
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    
                }
            }
        });
        tabla.addMouseListener(this);
        
        mostrarDatosTabla();
    }

    public void mostrarDatosTabla(){
        String[] titulos = {"ID", "Descripcion", "Piezas disponibles", "Precio unitario"};
        model = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        String[] datos = new String[4];
        for (int i = 0; i < LoginControlador.ListaProductos.size(); i++) {
            datos[0] = LoginControlador.ListaProductos.get(i).getIdProducto();
            datos[1] = LoginControlador.ListaProductos.get(i).getDescripcion();
            datos[2] = Integer.toString(LoginControlador.ListaProductos.get(i).getCantidad());
            datos[3] = Double.toString(LoginControlador.ListaProductos.get(i).getPrecioUnitario());
            
            model.addRow(datos);
            model.isCellEditable(i, 0);
            model.isCellEditable(i, 1);
            model.isCellEditable(i, 2);
            model.isCellEditable(i, 3);
            this.tabla.setModel(model);
            this.ventana.setTablaProductos(tabla);
        }
    }
    
    public int colocarDatos(String id){
        int indicador = 0;
        for (int i = 0; i < LoginControlador.ListaProductos.size(); i++) {
            if(id.equals(LoginControlador.ListaProductos.get(i).getIdProducto())){
                this.ventana.setTxtID(LoginControlador.ListaProductos.get(i).getIdProducto());
                this.ventana.setTxtDescripcion(LoginControlador.ListaProductos.get(i).getDescripcion());
                this.ventana.setTxtPrecio(Double.toString(LoginControlador.ListaProductos.get(i).getPrecioUnitario()));
                indicador = i;
            }
        }
        return indicador;
    }
    
    public ArrayList<String> convertirString(){
        ArrayList<String> productos = new ArrayList<>();
        for (int i = 0; i < LoginControlador.ListaProductos.size(); i++) {
            String cadena = null;
            cadena = LoginControlador.ListaProductos.get(i).toString();
            productos.add(cadena);
        }
        return productos;
    }
    
    public void realizarCambios(int id, String descripcion, double precio, int unidades){
        Archivo archivo = new Archivo();
        ArrayList<String> datos = new ArrayList<>();
        
        LoginControlador.ListaProductos.get(id).setDescripcion(descripcion);
        LoginControlador.ListaProductos.get(id).setPrecioUnitario(precio);
        int masPiezas = unidades + LoginControlador.ListaProductos.get(id).getCantidad();
        LoginControlador.ListaProductos.get(id).setCantidad(masPiezas);
        
        datos = convertirString();
        archivo.escribirArchivo("Productos.txt", datos);
    }
    
    public int obtenerPosicion(String id){
        int indi = 0;
        for (int j = 0; j < LoginControlador.ListaProductos.size(); j++) {
            if(id.equals(LoginControlador.ListaProductos.get(j).getIdProducto())){
                indi = j;
            }
        }
        
        return indi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.editar == ae.getSource()){
            try{ 
                if(this.ventana.getTxtIDEliminar().getText().length() != 0){
                    id = this.ventana.getTxtIDEliminar().getText();
                    indicador = colocarDatos(id);
                }else{
                    throw new CampoVacio("Favor de seleccionar un articulo de la tabla.");
                }
            }catch(CampoVacio e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        if(this.guardar == ae.getSource()){
            try{ 
                if(this.ventana.getTxtID().getText().length() != 0){
                    String descripcion = this.ventana.getTxtDescripcion().getText();
                    double precio = Double.parseDouble(this.ventana.getTxtPrecio().getText());
                    int unidades = Integer.parseInt(this.ventana.getsAgregarUnidades().getValue().toString());
                    realizarCambios(indicador, descripcion, precio, unidades);
                    mostrarDatosTabla();
                }else{
                    throw new CampoVacio("Favor de seleccionar un articulo de la tabla.");
                }
            }catch(CampoVacio e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(NumberFormatException e){ 
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un numero entero");
            }
        }
        
        if(this.eliminar == ae.getSource()){
            try{ 
                if(this.ventana.getTxtIDEliminar().getText().length() != 0){
                    id = this.ventana.getTxtIDEliminar().getText();
                    int posicion = obtenerPosicion(id);
                    LoginControlador.ListaProductos.remove(posicion);
                    Archivo archivo = new Archivo();
                    ArrayList<String> datos = new ArrayList<>();
                    datos = convertirString();
                    archivo.escribirArchivo("Productos.txt", datos);
                    mostrarDatosTabla();
                }else{
                    throw new CampoVacio("Favor de seleccionar un articulo de la tabla.");
                }
            }catch(CampoVacio e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        if(this.salir == ae.getSource()){
            this.ventana.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(tabla == me.getSource() && me.getClickCount() == 2){
            int filaPulsada = tabla.getSelectedRow();
            if( filaPulsada >= 0){
                String id = (String)this.tabla.getValueAt(filaPulsada, 0);
                this.ventana.setTxtIDEliminar(id);
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
