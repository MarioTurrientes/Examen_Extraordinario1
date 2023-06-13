package examen_extraordinaria;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author mturr
 */
public class Examen_Extraordinaria {

    // 0. Objeto privado:
    private static Lista li;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //O. Compartir un objeto entre clases que es para la lista:
        li = new Lista(); // Inicializar el objeto Lista
        
        DB_Manager bd = new DB_Manager(li); //O. Pasamos el objeto lista por argumento.
                
                try {
                    Connection connection = bd.getConnection();
                    
                    // Cerrar conexion:
                    connection.close();
                    
                } catch (Exception e) {
                    System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                }

        
        //--------------------------------------------------- EMPEZAMOS MENU ---------------------------------------------------------
        
        
        //variable:
        int opcion;
        
        do{
            // Llmamos al segundo menu para ver que quiere hacer el usuario:
            opcion = menu();
            
            switch (opcion) {
                case 1:
                    //mostrar datos por id:
                    Scanner sc = new Scanner(System.in);
                    
                    System.out.println("Ingrese el id del producto:");
                    int id_producto = sc.nextInt();
                    
                    Productos producto_encontrado = li.buscarProductoPorId(id_producto);
                    
                    if (producto_encontrado != null) {
                        System.out.println("Autora encontrada:\n" + producto_encontrado);
                    } else {
                        System.out.println("No se encontró la autora.");
                    }
                    
                    break;
                    
                case 2:
                    // llamamos al metodo de la clase Lista para sumar la stock de cada tipo de producto:
                    li.mostrarStockDeTipo();
                    
                    break;
                    
                case 3:
                    // llamamos al metodo de la clase Lista para contar cada prodcuto por S.O:
                    li.contarNumeroPorSO();
                    break;
                    
                case 4:
                    // Creamos el objeto autora vacio para introducir datos por teclado:
                    Productos nuevo_producto = new Productos();
                    
                    // Llamamos al metodo de crear nueva autora de la clase autora:
                    nuevo_producto.crearProducto();     // en el precio solo me dejan enteros me di cuenta tarde.
                    
                    // Añadimos en la listaProductos el producto del objeto nuevo_producto llamando al metodo de la clase Lista:
                    li.rellenar_lista(nuevo_producto);
                    
                    break;
               
                case 0:
                    // Imprimimos la lista con los cambios del metodo de la clase Lista:
                    li.muestra_lista();
                    
                    // 12. Llamar al método de la clase creardor para guardar la lista en un archivo CSV
                    Scanner sc2 = new Scanner(System.in);
                    
                    try {
                        System.out.println("Ingrese el nombre del archivo CSV para crear: ");
                        String nombreArchivo = sc2.nextLine();
                        // metodo llamado:
                        li.guardarAutorasEnCSV(nombreArchivo);
                       
                        System.out.println("El archivo CSV se ha creado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al crear el archivo CSV: " + e.getMessage());
                    }
                    
                    // Mensaje despedida:
                    System.out.println("Saliendo del programa...");
                    break;
                    

                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    
                    break;
            }
        }while (opcion != 0);
        
        
    }
    
    //--------------------------------------------------- FIN ---------------------------------------------------------
    
    // Funcion para llamar al menu:
    public static int menu() {
        
        Scanner scanner = new Scanner(System.in);

        //Menu del programa:
        
            System.out.println("=== MENÚ ===");
            System.out.println("0. Salir");
            System.out.println("1. Mostrar producto por id");
            System.out.println("2. Mostrar stock total cada tipo producto");
            System.out.println("3. Mostrar numero productos por S.O");
            System.out.println("4. Añadir producto");
            System.out.print("Elija una opción: ");
            
            // respuesta del usuario:
            int opcion = scanner.nextInt();
            
        return opcion;
    }
    
}
