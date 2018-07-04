/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.CompararCambios;
import Excepciones.ContraseniaIncorrecta;
import Excepciones.NoCoincidenciaContrasenia;
import Modelo.Archivo;
import Vista.CambiarContraseniaAdmiVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author sam33
 */
public class CambiarContraseniaAdmiControlador implements ActionListener{
    private CambiarContraseniaAdmiVista ventana;
    private JButton guardar;
    private JButton salir;
    private String antiguaContrasenia;
    private String nuevaContrasenia;
    private String nuevaContrasenia2;
    private Archivo escribir = new Archivo();
    private ArrayList<String> dato = new ArrayList<>();
    
    public CambiarContraseniaAdmiControlador(CambiarContraseniaAdmiVista vista) {
        this.ventana = vista;
        this.ventana.setLocationRelativeTo(null);
        this.guardar = this.ventana.getBtnGuardar();
        this.ventana.getBtnGuardar().addActionListener(this);
        this.salir = this.ventana.getBtnCancelar();
        this.ventana.getBtnCancelar().addActionListener(this);
    }
    
    public void verificar(String antigua, String nueva, String nueva2){
        if(antigua.equals(LoginControlador.Admi.getContrasenia())){
            if(nueva.equals(LoginControlador.Admi.getContrasenia())){
                throw new CompararCambios("No se ha realizado cambios en la contraseña.");
            }else{
                if(nueva.equals(nueva2)){
                    LoginControlador.Admi.setContrasenia(nueva);
                    for (int i = 0; i < 1; i++) {
                        dato.add(LoginControlador.Admi.toString());
                    }
                    System.out.println(dato);
                    escribir.escribirArchivo("Administrador.txt", dato);
                    JOptionPane.showMessageDialog(null, "Cambio guardado con éxito");
                    this.ventana.setVisible(false);
                }else{
                    throw new NoCoincidenciaContrasenia("Confirmacion incorrecta.");
                }
            }
        }else{
            throw new ContraseniaIncorrecta("Contrasenia incorrecta.");
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.guardar == ae.getSource()){
            antiguaContrasenia = this.ventana.getTxtContraseniaAntigua().getText();
            nuevaContrasenia = this.ventana.getTxtContrasenia1().getText();
            nuevaContrasenia2 = this.ventana.getTxtContrasenia2().getText();
            try{
                verificar(antiguaContrasenia, nuevaContrasenia, nuevaContrasenia2);
            }catch(CompararCambios e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(NoCoincidenciaContrasenia e1){
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }catch(ContraseniaIncorrecta e2){
                JOptionPane.showMessageDialog(null, e2.getMessage());
            }
        }
        
        if(this.salir == ae.getSource()){
            this.ventana.setVisible(false);
        }
    }
    
}
