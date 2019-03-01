/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.CampoVacio;
import Excepciones.NoCoincidenciaContrasenia;
import Modelo.Archivo;
import Modelo.EmpleadoModelo;
import Vista.RegistroEmpleadoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author sam33
 */
class RegistroEmpleadoControlador implements ActionListener{
    private RegistroEmpleadoVista ventana;
    private JButton guardar;
    private JButton cancelar;
    private String nombre;
    private String id;
    private int edad;
    private String contrasenia;
    private String contrasenia2;
    private EmpleadoModelo empleado;
    
    public RegistroEmpleadoControlador(RegistroEmpleadoVista vista, String nextID){
        this.ventana = vista;
        this.empleado = new EmpleadoModelo("","","",0);
        this.guardar = this.ventana.getBtnGuardar();
        this.ventana.getBtnGuardar().addActionListener(this);
        this.cancelar = this.ventana.getBtnCancelar();
        this.ventana.getBtnCancelar().addActionListener(this);
        this.id = nextID;
        this.ventana.setTxtID("B"+ id);
    }
    public ArrayList<String> convertirString(){
        ArrayList<String> empleados = new ArrayList<>();
        for (int i = 0; i < LoginControlador.ListaEmpleados.size(); i++) {
            String cadena = null;
            cadena = LoginControlador.ListaEmpleados.get(i).toString();
            empleados.add(cadena);
        }
        return empleados;
    }
    public void generarNuevoEmpleado(String nombre, int edad, String contrasenia, String contrasenia2){
        Archivo archivo = new Archivo();
        String escribir = null;
        ArrayList<String> datos = new ArrayList<>();
        empleado.setID(id);
        empleado.setNombre(nombre);
        empleado.setEdad(edad);
        empleado.setContrasenia(contrasenia);
        LoginControlador.ListaEmpleados.add(empleado);
        datos = convertirString();
        archivo.escribirArchivo("Empleados.txt", datos);
    }
    public void verificarCampos(){
        if(this.ventana.getTxtNombre().getText().length() == 0){
            throw new CampoVacio("Campo 'Nombre' vacio");
        }
        if(this.ventana.getTxtEdad().getText().length() == 0){
            throw new CampoVacio("Campo 'Edad' vacio");
        }
        if(this.ventana.getTxtContraseña().getText().length() == 0){
            throw new CampoVacio("Campo 'Contraseña' vacio");
        }
        if(this.ventana.getTxtContraseña2().getText().length() == 0){
            throw new CampoVacio("Campo 'Confirmacion contraseña' vacio");
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.guardar == ae.getSource()){
            try{
                verificarCampos();
                nombre = this.ventana.getTxtNombre().getText();
                edad = Integer.parseInt(this.ventana.getTxtEdad().getText());
                contrasenia = this.ventana.getTxtContraseña().getText();
                contrasenia2 = this.ventana.getTxtContraseña2().getText();
                if(contrasenia.equals(contrasenia2)){
                    generarNuevoEmpleado(nombre, edad, contrasenia, contrasenia2);
                }else{
                    throw new NoCoincidenciaContrasenia("Confirmacion de contraseña incorrecta");
                }
            }catch(NumberFormatException e){ 
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un numero entero");
            }catch(NoCoincidenciaContrasenia e1){
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }catch(CampoVacio e2){
                JOptionPane.showMessageDialog(null, e2.getMessage());
            }
            this.ventana.setVisible(false);
        }
        
        if(this.cancelar == ae.getSource()){
            ventana.setVisible(false);
        }
    }
}
