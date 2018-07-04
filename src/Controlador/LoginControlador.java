/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
/**
 * Librerias importadas.
 */
import Excepciones.NoPattern;
import Modelo.AdministradorModelo;
import Modelo.Archivo;
import Modelo.ClienteModelo;
import Modelo.EmpleadoModelo;
import Vista.LoginVista;
import Vista.RegistroClienteVista;
import Vista.VentanaAdministradorVista;
import Vista.VentanaClienteVista;
import Vista.VentanaEmpleadoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Clase que controla la ventana de iniciar sesion.
 * @author Samantha Caamal
 */
public class LoginControlador implements ActionListener{
    /**
     * Atriburo que contiene el nombre del archivo de texto.
     */
    public static String archivo;
    /**
     * Variable que contiene los datos del administrador Master.
     */
    public static AdministradorModelo Admi = new AdministradorModelo("Master", "Samantha Caamal", "123");
    /**
     * ArrayList con todos los clientes.
     */
    public static ArrayList<ClienteModelo> ListaClientes = new ArrayList<>();
    /**
     * ArrayList con todos los empleados.
     */
    public static ArrayList<EmpleadoModelo> ListaEmpleados = new ArrayList<>();
    /**
     * Variable para guardar la posicion del usuario ingresado.
     */
    public static int indicadorUsuario;
    /**
     * Ventana Login.
     */
    public LoginVista ventana;
    /**
     * Boton para iniciar sesion.
     */
    public JButton iniciarSesion;
    /**
     * Boton para registrar nuevo cliente.
     */
    public JButton registrar;
    /**
     * Boton para salir del programa.
     */
    public JButton salir;
    /**
     * Variable que contiene el usuario.
     */
    public String user;
    /**
     * Variable que contiene la contrasenia del usuario.
     */
    public String password;
    /**
     * ArrayList para leer la informacion de los archivos.
     */
    private ArrayList<String> archivoleido = new ArrayList<>();
    /**
     * Contructor de la clase LoginControlador.
     */
    public LoginControlador(LoginVista vista){
        this.ventana = vista;
        this.iniciarSesion = this.ventana.getBtnIniciarSesion();
        this.iniciarSesion.addActionListener(this);
        this.registrar = this.ventana.getBtnRegistrarse();
        this.registrar.addActionListener(this);
        this.salir = this.ventana.getBtnSalir();
        this.ventana.getBtnSalir().addActionListener(this);
        
    }
    /**
     * Metodo para poder iniciar sesion en el sistema,
     * verifica que tipo de usuario desea ingresar.
     * @param id contiene la matricula del usuario.
     * @param contrasenia contiene la contrasenia de la cuenta del usuario.
     */
    public void getIniciarSesion(String id, String contrasenia){
        //Obtenemos la lista de empleados.
        Archivo archivoEmpleados = new Archivo();
        archivoleido = archivoEmpleados.leerArchivo("Empleados.txt");
        ListaEmpleados = archivoEmpleados.convetirEmpleadoModelo(archivoleido);
        archivoleido.clear();
        //Obtenemos la lista de clientes.
        Archivo archivoCliente = new Archivo();
        archivoleido = archivoCliente.leerArchivo("Cliente.txt");
        ListaClientes = archivoCliente.convertirClientes(archivoleido);
            /**
             * Verificamos si la cuenta ingresada es de tipo administrativo, para 
             * después poder verificar si la cuenta existe e ingresar.
             */
            if(id.contains("A") && Admi.getID()!= null){
                System.out.println("Usuario admin..");
                if(Admi.getID().equals(id)){
                    if(contrasenia.equals(Admi.getContrasenia())){
                        VentanaAdministradorVista admiVista = new VentanaAdministradorVista();
                        VentanaAdministradorControlador admiCtrl = new VentanaAdministradorControlador();
                        admiVista.setVisible(true);
                    }else{
                        throw new NoPattern("Contraseña incorrecta");
                    }
                }else{
                    throw new NoPattern("ID incorrecto");
                }
            }//Fin de administrador.
            else{
                /**
                 * Verificamos si la cuenta ingresada es de tipo empleado, para 
                 * después poder verificar si la cuenta existe e ingresar.
                 */
                
                if(id.contains("B") && ListaEmpleados.size() > 0){
                    System.out.println("Usuario empleado...");
                    for (int i = 0; i < ListaEmpleados.size(); i++) {
                        if(id.equals(ListaEmpleados.get(i).getID())){
                            if(contrasenia.equals(ListaEmpleados.get(i).getContrasenia())){
                                indicadorUsuario = i;
                                /*CAMbios*/
                                EmpleadoModelo empl = ListaEmpleados.get(indicadorUsuario);
                                VentanaEmpleadoVista empleadoVista = new VentanaEmpleadoVista();
                                VentanaEmpleadoControlador empleadoCtrl = new VentanaEmpleadoControlador(empleadoVista,empl);
                                empleadoVista.setVisible(true);
                            }else{
                                throw new NoPattern("Contraseña incorrecta");
                            }
                        }else{
                            throw new NoPattern("ID incorrecto");
                        }
                    }
                }//Fin de empleado.
                else{
                    /**
                     * Verificamos si la cuenta ingresada es de tipo cliente, para 
                     * después poder verificar si la cuenta existe e ingresar.
                     */
                    if(id.contains("C") && ListaClientes.size() > 0){
                        System.out.println("Usuario cliente...");
                        for (int i = 0; i < ListaClientes.size(); i++) {
                            if(id.equals(ListaClientes.get(i).getID())){
                                if(contrasenia.equals(ListaClientes.get(i).getContrasenia())){
                                    indicadorUsuario = i;
                                    VentanaClienteVista clienteVista = new VentanaClienteVista();
                                    VentanaClienteControlador clienteCtrl = new VentanaClienteControlador();
                                    clienteVista.setVisible(true);
                                }
                            }else{
                                throw new NoPattern("ID incorrecto");
                            }
                        }
                    }//Fin de cliente.
                }
            }
    }
    /**
     * Metodo que verifica que accion se realizo en la pantalla.
     * @param arg0 es la accion realizada por el usuario.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Estructura de control para iniciar sesion.
        if(this.ventana.getBtnIniciarSesion() == arg0.getSource()){
            try{
                System.out.println("Boton de iniciar sesion...");
               user = this.ventana.getTxtUsuario().getText();
               password = this.ventana.getTxtContrasenia().getText();
                System.out.println(user + "--" + password);
               getIniciarSesion(user, password);
            }catch(NoPattern e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage());
            }
        }
        //Estructura de control para registrarte.
        if(this.ventana.getBtnRegistrarse() == arg0.getSource()){
            System.out.println("Boton de registro...");
            RegistroClienteVista nuevoCliente = new RegistroClienteVista();
            RegistroClienteControlador clienteCtrl = new RegistroClienteControlador();
            nuevoCliente.setVisible(true);
        }
        //Estructura de control para cerrar programa.
        if(this.ventana.getBtnSalir() == arg0.getSource()){
            System.out.println("Boton para salir del programa...");
            ventana.dispose();
        }
    }
}
