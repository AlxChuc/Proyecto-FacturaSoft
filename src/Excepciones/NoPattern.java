/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author sam33
 */
public class NoPattern extends RuntimeException{
    public NoPattern(String mensaje){
        super(mensaje);
    }
}
