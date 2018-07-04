/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.CambiarContraseniaAdmiVista;
import Vista.InformacionAdministradorVista;
import Vista.InformacionEmpleadoVista;
import Vista.RegistroEmpleadoVista;
import Vista.RegistroProductoVista;
import Vista.StockVista;
import Vista.VentanaAdministradorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author sam33
 */
public class VentanaAdministradorControlador implements ActionListener{
    public static VentanaAdministradorVista ventana;
    public JMenuBar menuAdmi;
    public JMenu perfil;
    public JMenu empleado;
    public JMenu producto;
    public JMenuItem modificarPerfil;
    public JMenuItem cambiarContrasenia;
    public JMenuItem nuevoEmpleado;
    public JMenuItem infoEmpleados;
    public JMenuItem nuevoProducto;
    public JMenuItem stock;
    public JLabel nombreAdmi;
    public JButton salir;
    public String mostrarNombre;
    
    public VentanaAdministradorControlador(VentanaAdministradorVista vista){
        this.ventana = vista;
        this.ventana.setLocationRelativeTo(null);
        this.modificarPerfil = this.ventana.getmModificarPerfil();
        this.modificarPerfil.addActionListener(this);
        this.cambiarContrasenia = this.ventana.getmCambiarContrasenia();
        this.cambiarContrasenia.addActionListener(this);
        this.nuevoEmpleado = this.ventana.getmNuevoEmpleado();
        this.nuevoEmpleado.addActionListener(this);
        this.infoEmpleados = this.ventana.getmInformacionEmpleado();
        this.infoEmpleados.addActionListener(this);
        this.nuevoEmpleado = this.ventana.getmNuevoProducto();
        this.nuevoEmpleado.addActionListener(this);
        this.stock = this.ventana.getmStock();
        this.stock.addActionListener(this);
        this.ventana.setLbNombreUsuario(LoginControlador.Admi.getNombre());
        this.salir = this.ventana.getBtnSalir();
        this.salir.addActionListener(this);
    }
    /**
     * 
     * @return 
     */
    public int getUltimoIDempleado(){
        int idEmpleado = 0;
        if(LoginControlador.ListaEmpleados.size() > 0){
                System.out.println("Array con elementos");
                int tamanio = LoginControlador.ListaEmpleados.size()-1;
                char a1 = LoginControlador.ListaEmpleados.get(tamanio).getID().charAt(1);
                char a2 = LoginControlador.ListaEmpleados.get(tamanio).getID().charAt(2);
                char a3 = LoginControlador.ListaEmpleados.get(tamanio).getID().charAt(3);
                char a4 = LoginControlador.ListaEmpleados.get(tamanio).getID().charAt(4);
                String convertir = "" + a1 + a2 + a3 + a4;
                idEmpleado = Integer.parseInt(convertir);
                System.out.println("Ultimo ID es: " + convertir);
            }else{
                System.out.println("Array vacio");
                idEmpleado = 1;
            }
        return idEmpleado;
    }
    
    public int ultimoIDproducto(){
        int idProducto = 0;
        if(LoginControlador.ListaProductos.size() > 0){
            System.out.println("Array con elementos");
            int tamanio1 = LoginControlador.ListaProductos.size()-1;
            char a1 = LoginControlador.ListaProductos.get(tamanio1).getIdProducto().charAt(1);
            char a2 = LoginControlador.ListaProductos.get(tamanio1).getIdProducto().charAt(2);
            char a3 = LoginControlador.ListaProductos.get(tamanio1).getIdProducto().charAt(3);
            char a4 = LoginControlador.ListaProductos.get(tamanio1).getIdProducto().charAt(4);
            String cadena = "" + a1 + a2 + a3 + a4;
            idProducto = Integer.parseInt(cadena);
            System.out.println("Ultimo ID es:" +  cadena);
        }else{
            System.out.println("Array vacio");
            idProducto = 1;
        }
        return idProducto;
    }
    public String  generarID(int id) {
        int dato = id;
        String num = "";
        int cont = 1;
        if((dato >= 1000) || (dato < 1000))
        {
            int can=cont+dato;
            num = "" + can;
        }
        if((dato>=100) || (dato<100))
        {
            int can=cont + dato;
            num = "0" + can;
        }
        if((dato>=9) || (dato<100))
        {
            int can = cont + dato;
            num = "00" + can;
        }
        if(dato<9)
        {
            int can=cont + dato;
            num = "000" + can;
        }
        
        return num;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.ventana.getmModificarPerfil() == ae.getSource()){
            System.out.println("Perfil administrador...");
            InformacionAdministradorVista perfilVista = new InformacionAdministradorVista();
            InformacionAdministradorControlador perfilCtrl = new InformacionAdministradorControlador(perfilVista);
            perfilVista.setVisible(true);
        }
        
        if(this.cambiarContrasenia == ae.getSource()){
            CambiarContraseniaAdmiVista cambiarVista = new CambiarContraseniaAdmiVista();
            CambiarContraseniaAdmiControlador cambiarCtrl = new CambiarContraseniaAdmiControlador(cambiarVista);
            cambiarVista.setVisible(true);
        }
        
        if(this.ventana.getmNuevoEmpleado() == ae.getSource()){
            int ultimoIDe = getUltimoIDempleado();
            String nextID = generarID(ultimoIDe);
            RegistroEmpleadoVista nuevoVista = new RegistroEmpleadoVista();
            RegistroEmpleadoControlador nuevoCtrl = new RegistroEmpleadoControlador(nuevoVista, nextID);
            nuevoVista.setVisible(true);
        }
        
        if(this.ventana.getmInformacionEmpleado() == ae.getSource()){
            InformacionEmpleadoVista infoVista = new InformacionEmpleadoVista();
            InformacionEmpleadoControlador infoCtrl = new InformacionEmpleadoControlador(infoVista);
            infoVista.setVisible(true);
        }
        
        if(this.ventana.getmNuevoProducto() == ae.getSource()){
            int ultimoIDp = ultimoIDproducto();
            String nextIDp = generarID(ultimoIDp);
            System.out.println(nextIDp);
            RegistroProductoVista productoVista = new RegistroProductoVista();
            RegistroProductoControlador productoCtrl = new RegistroProductoControlador(productoVista, nextIDp);
            productoVista.setVisible(true);
        }
        
        if(this.ventana.getmStock() == ae.getSource()){
            StockVista stockVista = new StockVista();
            StockControlador stockCtrl = new StockControlador(stockVista);
            stockVista.setVisible(true);
        }
        
        if(this.ventana.getBtnSalir() == ae.getSource()){
            System.out.println("Boton salir");
            this.ventana.setVisible(false);
            
        }
    }
}
