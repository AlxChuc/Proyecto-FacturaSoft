/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import Controlador.LoginControlador;
import Vista.LoginVista;

/**
 *
 * @author sam33
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginVista principal = new LoginVista();
        LoginControlador principalCtrl = new LoginControlador(principal);
        principal.setVisible(true);
    }
    
}
