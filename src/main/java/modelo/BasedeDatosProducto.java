package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase representa a una base de datos de productos, que cuenta con una colección de tipo HashMap administrable
 * con métodos que permiten agregar,borrar y actualizar. Adicionalmente cuenta con métodos adicionales para generar informes y
 * validaciones.
 * @author desaextremo
 */
public class BasedeDatosProducto {
    /**
     * Atributo para administrar colecciónd e tipo HashMap
     */
    private Map<Integer, Producto> listaProductos;
    
    /**
     * Constructor de la clase: Se encarga de inicializar la colección y agregar productos existentes
     */
    public BasedeDatosProducto() {
       listaProductos = new HashMap<Integer, Producto>();

        listaProductos.put(1, new Producto("Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto("Limones", 2300.0, 15));
        listaProductos.put(3, new Producto("Peras", 2700.0, 33));
        listaProductos.put(4, new Producto("Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto("Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto("Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto("Helado", 4500.0, 41));
        listaProductos.put(8, new Producto("Galletas", 500.0, 8));
        listaProductos.put(9, new Producto("Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto("Jamon", 15000.0, 10));
    }
    
    /**
     * Permite obtener la colección de productos
     * @return colección de productos
     */
    public Map<Integer, Producto> getListaProductos() {
        return listaProductos;
    }
    
    /**
     * Permite agregar un producto a la colección
     * @param producto El producto que se agregara a la colección
     */
    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }
    
    /**
     * Permite borrar un producto de la colección
     * @param producto El producto que se borrara de la colección
     */
    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }
    
    /**
     * Permite actualizar los datos de un producto de la colección
     * @param producto  El producto que actualizara
     */
    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);
    }
    
    /**
     * Retorna el nombre del producto con mayor precio 
     * @return String con el nombre del producto
     */
    public String productoPrecioMayor(){        
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();
        for (Producto producto: listaProductos.values()) {
            if (producto.getPrecio() > precio){
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }
    
    /**
     *  El nombre del producto con menor precio
     * @return String con el nombre del producto
     */
    public String productoPrecioMenor(){        
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();
        for (Producto producto: listaProductos.values()) {
            if (producto.getPrecio() < precio){
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }    
    
    /**
     * Retorna el promedio de precios de todos los productos
     * @return double con el promedio de precios
     */
    public double promedioPrecios(){        
        double suma = 0;
        for (Producto producto: listaProductos.values()) {
            suma += producto.getPrecio();       
        }
        return suma / (listaProductos.size()) ;
    }
   
    /**
     * Total del inventario: Suma de valor inventario de cada producto(precio producto x cantidad de inventario)
     * @return total de inventario
     */
    public double totalInventario(){        
        double totalInventario = 0;
        for (Producto producto: listaProductos.values()) {
            totalInventario += producto.getPrecio() * producto.getInventario();       
        }
        return totalInventario ;
    }

    /**
     * Validar si el código del producto recibido como parámetro, existe en la colección
     * @param producto El producto cuyo código se validar en la colección
     * @return true si existe un producto con ese código en la colección, o false en caso contrario
     */
    public boolean verificarExistencia(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());
    }
    
    /**
     * Generar informe con el nombre del producto de mayor precio, el nombre del producto del manor precio, el promedio de precios y el total de inventario
     * @return Cadena de caracteres con información requerida
     */
     public String generarInforme() {
        List<Producto> listaM = obtenerMayores();
        return listaM.get(0).getNombre() + " " + listaM.get(1).getNombre() + " " + listaM.get(2).getNombre();
    }

    /**
     * Retorna un listado con los 3 productos de mayor Precio
     * @return List de 3 posiciones
     */ 
    private List<Producto> obtenerMayores() {
        List<Producto> listaMayores = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            Producto productoMayor = productosPrecioMayor();
            listaProductos.remove(productoMayor.getCodigo());
            listaMayores.add(productoMayor);
        }

        return listaMayores;
    }
    
    /**
     * Retorna el producto de mayor valor
     * @return producto
     */
    public Producto productosPrecioMayor() {
        Producto producto = listaProductos.values().iterator().next();
        for (Producto p : listaProductos.values()) {
            if (p.getPrecio() > producto.getPrecio()) {
                producto = p;
            }
        }
        return producto;
    }

}