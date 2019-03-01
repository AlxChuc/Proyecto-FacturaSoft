/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.CompararCambios;
import Excepciones.ContraseniaIncorrecta;
import Modelo.Archivo;
import Vista.InformacionAdministradorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author sam33
 */
class InformacionAdministradorControlador implements ActionListener{
    public InformacionAdministradorVista ventana;
    public String nombre;
    public String contrasenia;
    public JButton guardar;
    public JButton cancelar;
    private Archivo escribir = new Archivo();
    private ArrayList<String> dato = new ArrayList<>();
    
    public InformacionAdministradorControlador(InformacionAdministradorVista vista){
        this.ventana = vista;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTxtIDAdmi(LoginControlador.Admi.getID());
        this.ventana.setTxtNombreAdmi(LoginControlador.Admi.nombre);
        this.guardar = this.ventana.getBtnGuardar();
        this.ventana.getBtnGuardar().addActionListener(this);
        this.cancelar = this.ventana.getBtnCancelar();
        this.ventana.getBtnCancelar().addActionListener(this);
    }
    
    public void guardarCambios(String nombre, String contrasenia){
        if(nombre != LoginControlador.Admi.getNombre()){
            if(contrasenia.equals(LoginControlador.Admi.getContrasenia())){
                LoginControlador.Admi.setNombre(nombre);
                for (int i = 0; i < 1; i++) {
                    dato.add(LoginControlador.Admi.toString());
                }
                System.out.println(dato);
                escribir.escribirArchivo("Administrador.txt", dato);
                JOptionPane.showMessageDialog(null, "Cambio guardado con éxito");
                VentanaAdministradorControlador.ventana.setLbNombreUsuario(LoginControlador.Admi.getNombre());
                this.ventana.setVisible(false);
            }else{
                throw new ContraseniaIncorrecta("No se puede guardar los cambios, contraseña incorrecta.");
            }
        }else{
            throw new CompararCambios("No se realizo ningun cambio a la informacion del usuario.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.guardar == ae.getSource()){
            try{
                nombre = this.ventana.getTxtNombreAdmi().getText();
                contrasenia = this.ventana.getTxtContrasenia().getText();
                guardarCambios(nombre, contrasenia);
            }catch(ContraseniaIncorrecta e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(CompararCambios e1){
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        }
        if(this.cancelar == ae.getSource()){
            this.ventana.setVisible(false);
        }
    }
}
