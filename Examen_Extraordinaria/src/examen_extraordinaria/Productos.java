/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_extraordinaria;

import java.util.Scanner;

/**
 *
 * @author mturr
 */
class Productos {
    
    // Definimos los atributos de la clase:
    private int id;
    private String nombre;
    private Double precio;
    private int stock;
    private String tipo;
    private String categoria;
    private String marca;
    private String sistema_operativo;

    public Productos(int id, String nombre, Double precio, int stock, String tipo, String categoria, String marca, String sistema_operativo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
        this.categoria = categoria;
        this.marca = marca;
        this.sistema_operativo = sistema_operativo;
    }

    
    // Constructor vacio:
    public Productos() {
        
    }
    
    //Informacion de la base datos y para el csv con comas:
    @Override
    public String toString() {
        return id + "," + nombre + "," + precio + "," + stock + "" + tipo + "" + categoria + "," + marca + "," + sistema_operativo;
    }
    
    
    //--------------------------------------------------------------------------------------------------------------------------------------------
    
    public void crearProducto(){
        //creamos el sacanner:
        Scanner leer = new Scanner(System.in);
        
        // datos que rellena el usuario de cada atributo:
        System.out.println("Escribe el id:");
        setId(id = leer.nextInt());
        System.out.println("Escribe el nombre:");
        setNombre(nombre = leer.next());
        System.out.println("Escribe el precio:");
        setPrecio(precio = leer.nextDouble());
        System.out.println("Escribe la stock:");
        setStock(stock = leer.nextInt());
        System.out.println("Escribe el tipo:");
        setTipo(tipo = leer.next());
        System.out.println("Escribe la categoria:");
        setCategoria(categoria = leer.next());
        System.out.println("Escribe la marca:");
        setMarca(marca = leer.next());
        System.out.println("Escribe el sistema Operativo:");
        setSistema_operativo(sistema_operativo = leer.next());
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //getters y setters:

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    
}
