/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import Controlador.*;
import Modelo.EmpleadoModelo;
import Vista.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alex
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.put("TextField.inactiveBackground", java.awt.Color.white);
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException | UnsupportedLookAndFeelException ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException 
                    | IllegalAccessException | UnsupportedLookAndFeelException ex1) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

//        VentanaEmpleadoVista vEV = new VentanaEmpleadoVista();
//        VentanaEmpleadoControlador vEC = new VentanaEmpleadoControlador(vEV);
        EmpleadoModelo eM = new EmpleadoModelo("0000","Alejandro Chuc","pass",4);
        new VentanaEmpleadoControlador(new VentanaEmpleadoVista(),eM);

    }

}
