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
public class CampoVacio extends RuntimeException {
    public CampoVacio(String mensaje){
        super(mensaje);
    }
}
