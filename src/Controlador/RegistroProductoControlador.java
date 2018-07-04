/**
 * 
 */
package Controlador;

import Excepciones.CampoVacio;
import Modelo.Archivo;
import Modelo.ProductoModelo;
import Vista.RegistroProductoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Samantha Caamal.
 */
public class RegistroProductoControlador implements ActionListener{
    private RegistroProductoVista ventana; 
    private JButton guardar;
    private JButton cancelar;
    private String id;
    private String descripcion;
    private double precio;
    private int piezas;
    private ProductoModelo producto;
    
    public RegistroProductoControlador(RegistroProductoVista vista, String nextID) {
        this.ventana = vista;
        this.guardar = this.ventana.getBtnGuardar();
        this.ventana.getBtnGuardar().addActionListener(this);
        this.cancelar = this.ventana.getBtnCancelar();
        this.ventana.getBtnCancelar().addActionListener(this);
        this.producto = new ProductoModelo();
        this.id = nextID;
        this.ventana.setTxtID("P" + id);
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
    
    public void verificarCampos(){
        if(this.ventana.getTxtDescripcion().getText().length() == 0){
          throw new CampoVacio("Campo 'Descripcion' vacio");  
        }
        
        if(this.ventana.getTxtPrecio().getText().length() == 0){
            throw new CampoVacio("Campo 'Precio' vacio"); 
        }
    }
    
    public void generarNuevoProducto(String id, String descripcion, double precio, int piezas){
        Archivo archivo = new Archivo();
        String escribir = null;
        ArrayList<String> datos = new ArrayList<>();
        producto.setIdProducto(id);
        producto.setDescripcion(descripcion);
        producto.setPrecioUnitario(precio);
        producto.setCantidad(piezas);
        LoginControlador.ListaProductos.add(producto);
        datos = convertirString();
        archivo.escribirArchivo("Productos.txt", datos);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.guardar == ae.getSource()){
            try{
                verificarCampos();
                descripcion = this.ventana.getTxtDescripcion().getText();
                precio = Double.parseDouble(this.ventana.getTxtPrecio().getText());
                piezas = Integer.parseInt(this.ventana.getsPiezas().getValue().toString());
                generarNuevoProducto(id, descripcion, precio, piezas);
                this.ventana.setVisible(false);
            }catch(CampoVacio e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(NumberFormatException e1){ 
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un numero entero");
            }
        }
        
        if(this.cancelar == ae.getSource()){
            this.ventana.setVisible(false);
        }
    }
    
}
