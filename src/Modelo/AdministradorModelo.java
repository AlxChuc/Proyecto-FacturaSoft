/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ElenaMariel
 */
public class AdministradorModelo extends Usuario{
    
    public AdministradorModelo(){
        
    }
    
    public AdministradorModelo(String ID, String nombre, String contrasenia) {
        super(ID, nombre, contrasenia);
    }
    //Metodos get y set
    @Override
    public void setContrasenia(String contrasenia) {
        super.setContrasenia(contrasenia);
    }

    @Override
    public String getContrasenia() {
        return super.getContrasenia();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setID(String ID) {
        super.setID(ID);
    }

    @Override
    public String getID() {
        return "A" + super.getID();
    }
    
    public String getIDsinA(){
        return super.getID();
    }
    @Override
    public String toString() {
        return this.ID + "/" + this.nombre + "/" + this.getContrasenia();
    }
}
