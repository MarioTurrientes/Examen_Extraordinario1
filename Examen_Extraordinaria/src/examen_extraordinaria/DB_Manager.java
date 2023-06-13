package examen_extraordinaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mturr
 */
public class DB_Manager {
    
    //O. Para el objeto de la lista autoras:
    private Lista li;
    
    //O. Constructor con el objeto de la lista:
    public DB_Manager(Lista li) {
        this.li = li;
    }
 
    // 1. almacenará la conexión establecida con la base de datos.
    private Connection conn;
    
    // 1. Constructor vacio:
    public DB_Manager() {
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------
    
    //1. creamos un metodo para la conexion con la db:
    public Connection getConnection() {
        
        String url = "jdbc:mysql://10.230.109.71:3306/tienda_electronica?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "";
        
        try {
            conn = DriverManager.getConnection(url,"root","");     // establecer la conexión 
            System.out.println("Conexión exitosa a la base de datos");
            
            // Obtener los datos de las autoras y agregarlos a la lista de Autora
            obtenerDatosProductos();
            
        
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return conn;  // se retorna la conexión establecida y asi poder ser utilizada para otras partes del codigo.
        
    }
    
    
    //3. Metodo para recoger los datos de la tabla:
    public void obtenerDatosProductos() throws SQLException {
        
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM productos";
        ResultSet resultSet = statement.executeQuery(sql);
        

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            Double precio = resultSet.getDouble("precio");
            int stock = resultSet.getInt("stock");
            String tipo = resultSet.getString("tipo");
            String categoria = resultSet.getString("categoria");
            String marca = resultSet.getString("marca");
            String sistema_operativo = resultSet.getString("sistema_operativo");

            Productos producto = new Productos(id, nombre, precio, stock, tipo, categoria, marca, sistema_operativo);
            
            //en la lista la relleno con los objetos autoras, llamando al metodo de la clase Lista:
            li.rellenar_lista(producto);
            
        }
        
        // Imprimimos la lista de productos, llamando al metodo de la clase Lista:
        li.muestra_lista();

        //cerramos el statement y el resulset:
        resultSet.close();
        statement.close();
    }
    
}
