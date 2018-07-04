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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        //datos.clear();
        ArrayList<String> temporal = new ArrayList<>();
        
        try {

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {
                //datos.add(linea);
                temporal.add(linea);
                
            }
            
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivo);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temporal;
    }
    /**
     * Metodo para escribir un solo elemento en un archivo.
     * @param archivo
     * @param dato 
     */
    public void escribirArchivo(String archivo, String dato) {
        try {
            FileWriter fr = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fr);
            System.out.println("Escribiendo...");
            System.out.println(dato);
            pw.write(dato);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al imprimir...");
        }
    }
    /**
     * Metodo para poder escribir en el archivo de texto.
     * @param archivo
     * @param datos 
     */
    public void escribirArchivo(String archivo, ArrayList<String> datos) {
        try {
            FileWriter fr = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fr);
            for (int i = 0; i < datos.size(); i++) {
                System.out.println("Escribiendo...");
                System.out.println(datos.get(i));
                pw.println(datos.get(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al imprimir...");
        }
    }
    /**
     * Metodo para obtener los datos del administrador.
     * @param datos es un ArrayList con los datos del archivo.
     * @return admi es un ArrayList que contiene los datos del administrador.
     */
    public AdministradorModelo convertirAdministrador(ArrayList<String> datos) {
        AdministradorModelo administrador = null;
        for (int i = 0; i < datos.size(); i++) {
            String[] cadena = datos.get(i).split("/");
            if (cadena.length == 3) {
                String id = cadena[0];
                String nombre = cadena[1];
                String contraseña = cadena[2];
               administrador = new AdministradorModelo(id, nombre, contraseña);
            }
        }
        
        
        return administrador;
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
     * Metoo para obtener los datos de los clientes.
     * @param datos
     * @return 
     */
    public ArrayList<EmpleadoModelo> convetirEmpleadoModelo(ArrayList<String> datos){
        
        ArrayList<EmpleadoModelo> empleados = new ArrayList<>();
        
        for (int m = 0; m < datos.size(); m++) {
            String[] cadena = datos.get(m).split("/");
            if(cadena.length == 5){
                String id = cadena[0];
                String nombre = cadena[1];
                int edad = Integer.parseInt(cadena[2]);
                String contrasenia = cadena[3];
                double salario = Double.parseDouble(cadena[4]);
                
                empleados.add(new EmpleadoModelo(id, nombre, contrasenia, edad));
            }
        }
        return empleados;
    }
    
    public ArrayList<ProductoModelo> convertirProducto(ArrayList<String> datos){
        
        ArrayList<ProductoModelo> productos = new ArrayList<>();
        
        for (int n = 0; n < datos.size(); n++) {
            String[] cadena = datos.get(n).split("/");
            if(cadena.length == 4){
                String id = cadena[0];
                String descripcion = cadena[1];
                int cantidad = Integer.parseInt(cadena[2]);
                double precio = Double.parseDouble(cadena[3]);
                
                productos.add(new ProductoModelo(id, descripcion, cantidad, precio,0));
            }
        }
        
        return productos;
    }
}
