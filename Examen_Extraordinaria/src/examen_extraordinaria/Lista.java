/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_extraordinaria;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mturr
 */
public class Lista {
    
    // Creamos una lista de autoras:
    private static ArrayList <Productos> listaProductos = new ArrayList();
    
    // Constructor vacio:
    public Lista() {
    }
    
    
    //------------------------------------------------------------------------------------------------------------

    
    // rellenar lista productos mencionada en la clase DB_Manager:
    public void rellenar_lista(Productos producto){
        listaProductos.add(producto);
    }
    
    //-------------------------------------------------------------------------------------------------------------
    
    // Mostrar todo los datos de la lista:
    public void muestra_lista(){
        
        for(int i=0;i<listaProductos.size();i++) {
            System.out.println(listaProductos.get(i).toString()); // Llamamos al metodo toString de la clase Productos para saber los datos de cada posicion de arrayList:
        }
    }
    
    //-------------------------------------------------------------------------------------------------------------
    
    // Metodo para buscar el producto por id:
    public static Productos buscarProductoPorId(int idProducto) {
        // Recorre la lista de productos y busca el ID especificado
        for (Productos campo : listaProductos) {
            if (campo.getId() == idProducto) {
                return campo;
            }
        }
        return null; // Si no se encuentra el producto, retorna null
    }
    
    //-------------------------------------------------------------------------------------------------------------
    
    //Metodo para mostrar la stock total de cada tipo
    public void mostrarStockDeTipo() {
        
        
        
    }
    
    //-------------------------------------------------------------------------------------------------------------
    
    // Metodo para contar el numero de productos por S.O
    public void contarNumeroPorSO() {
        
        // Creamos un mapa que almacena el campo y su recuento:
        Map<String, Integer> contarProductos = new HashMap<>();
        
        for (Productos dato : listaProductos) {
            String campo_so = dato.getSistema_operativo();  //obtenemos el S.O del producto actual y se guarda en el string campo_so
            
            // Si el campo de trabajo ya está presente en el mapa, se incrementa
            // Si no está presente, se agrega al mapa con un recuento inicial de 1.
            contarProductos.put(campo_so, contarProductos.getOrDefault(campo_so, 0) + 1);   //Obtiene el recuento actual del campo de trabajo. Si no existe, devuelve 0, si no suma 1.
        }
        
        for (Map.Entry<String, Integer> entry : contarProductos.entrySet()) {
            
            // Se obtiene el campo S.O de la entrada actual.
            String campo_so = entry.getKey();
            
            // Se obtiene el recuento de productos del campo del S.O actual.
            int contar_productos = entry.getValue();
            
            System.out.println(campo_so + " : " + contar_productos);
        }
    }
    
    //-------------------------------------------------------------------------------------------------------------
    
    // Metodo para guardar y crear csv con los datos actualizados:
    public void guardarAutorasEnCSV(String nombreArchivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));  //si el archivo no existe, se creará uno nuevo con dicho nombre.

        for (Productos autora : listaProductos) {
            String linea = autora.toString(); // Utilizar el método toString() de la clase Producto que ya esta con comas.
            
            writer.write(linea);    //Se escribe la cadena linea en el archivo CSV utilizando el objeto writer
            writer.newLine();   //Se agrega una nueva línea al archivo CSV después de escribir cada producto.
        }

        writer.close(); //se cierra el objeto, asegura que todos los datos se guarden correctamente en el archivo 
    }
}
