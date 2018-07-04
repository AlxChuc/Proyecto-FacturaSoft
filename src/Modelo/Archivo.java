/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 * Librerias importadas.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam33
 */
public class Archivo {
    private String nombre;
    public ArrayList<String> datos;
    
    public Archivo() {
//        this.nombre = nombre;
        this.datos = new ArrayList<>();
    }
    
    public Archivo(String nombre){
        this.nombre = nombre;
        this.datos = new ArrayList<>();
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Metodo para leer un archivo.
     * @param archivo archivo de texto del usuario.
     * @return datos ArrayList con los datos del archivo.
     */
    public ArrayList<String> leerArchivo(String archivo) {
        datos.clear();
        ArrayList<String> temporal = new ArrayList<String>();
        
        try {

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {
                datos.add(linea);
                temporal.add(linea);
                System.out.println(linea);
                
                
            }System.out.println("");
            
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivo);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temporal;
    }
    /**
     * Metodo para obtener los datos del administrador.
     * @param datos es un ArrayList con los datos del archivo.
     * @return admi es un ArrayList que contiene los datos del administrador.
     */
    public ArrayList<AdministradorModelo> convertirAdministrador(ArrayList<String> datos) {
        
        ArrayList<AdministradorModelo> admi = new ArrayList<>();
        
        for (int i = 0; i < datos.size(); i++) {
            String[] cadena = datos.get(i).split("/");
            if (cadena.length == 3) {
                String id = cadena[0];
                String nombre = cadena[1];
                String contraseña = cadena[2];
                
               AdministradorModelo a = new AdministradorModelo(id, nombre, contraseña);
                admi.add(a);
                
            }
        }
        
        return admi;
    }
    /**
     * Metodo para obtener los datos de los clientes.
     * @param datos es un ArrayList con los datos del archivo.
     * @return clientes es un ArrayList con objetos Clientes.
     */
    public ArrayList<ClienteModelo> convertirClientes(ArrayList<String> datos){
        
        ArrayList<ClienteModelo> clientes = new ArrayList<>();
        
        for (int j = 0; j < datos.size(); j++) {
            String[] cadena = datos.get(j).split("/");
            if(cadena.length == 6){
                String id = cadena[0];
                String nombre = cadena[1];
                String contrasenia = cadena[2];
                String direccion = cadena[3];
                int telefono = Integer.parseInt(cadena[4]);
                int edad = Integer.parseInt(cadena[5]);
                
                ClienteModelo cliente = new ClienteModelo(id, nombre, contrasenia, direccion, telefono, edad);
                clientes.add(cliente);
            }
        }
        
        return clientes;
    }
    /**
     * Metoo para obtener los datos de los empleado.
     * @param datos es un ArrayList con los datos del archivo
     * @return Arreglo de objetos tipo EmpleadoModelo
     */
    public ArrayList<EmpleadoModelo> convetirEmpleadoModelo(ArrayList<String> datos){
        
        ArrayList<EmpleadoModelo> empleados = new ArrayList<>();
        
        for (int j = 0; j < datos.size(); j++) {
            String[] cadena = datos.get(j).split("/");
//            System.out.println(cadena.length);
            if(cadena.length == 4){
                String id = cadena[0];
                String nombre = cadena[1];
                String contrasenia = cadena[2];
                int edad = Integer.parseInt(cadena[3]);
//                double salario = Double.parseDouble(cadena[4]);
                
//                EmpleadoModelo empleado = new EmpleadoModelo(id, nombre, contrasenia, edad);
                empleados.add(new EmpleadoModelo(id, nombre, contrasenia, edad));
            }
        }
        
        return empleados;
    }
}
