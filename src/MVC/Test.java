/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.util.ArrayList;

/**
 *
 * @author sam33
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String numero = "1000";
        char a1 = numero.charAt(0);
        char a2 = numero.charAt(1);
        char a3 = numero.charAt(2);
        char a4 = numero.charAt(3);
        String convertir = null;
        convertir = ""+a1+a2+a3+a4;
        int n = Integer.parseInt(convertir);
        System.out.println(n);
    }
    
}
