package modelo;

/**
 * Esta clase representa a cada uno de los productos que se venden en la tienda
 * @author desaextremo
 */
public class Producto {
    /**
     * codigo del producto, valor autoincrementable que depende del valor del atributo de clase o estático cantidadProductos
     */
    private int codigo;
    
    /**
     * Nombre del producto
     */
    private String nombre;
    
    /**
     * Precio del producto
     */
    private double precio;
    
    /**
     * Cantidad del producto en el inventario
     */
    private int inventario;
    
    /**
     * Atributo estático o de clase que lleva el conteo de la cantidad de prodcutos que se han creado. Sirve para
     * calcular el código del prodcuto
     */
    private static int cantidadProductos;
    
    /**
     * Constructor por defecto, se encarga de incrementar la cantidad de producto y asignarlo al código
     */
    public Producto() {
        cantidadProductos++;
        this.codigo = cantidadProductos;
    }
    
    /**
     * Constructor que recibe todos los atributos requeridos por el producto. Se utilizará cuando esta clase se use en los retos de 
     * MasterTech 2 y 3 (mas no en el reto de la iterfaz)
     * @param codigo codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param inventario Cantidad del producto en el inventario
     */
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;

    }
    
    /**
     * Constructor que recibe todos los atributos requeridos por el producto (Excepto el código). Se utilizará cuando esta clase
     * se use en la interfaz gráfica del reto; dado que el código no se indica al crear el producto
     * Invoca al constructor por defecto (this()) para que genere el código del producto y lo asigne
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param inventario Cantidad del producto en el inventario
     */
    public Producto(String nombre, double precio, int inventario) {
        this();
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;

    }
    
    /**
     * Retorna el código del producto
     * @return 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Asigna el código del producto
     * @param codigo Valor del código del producto
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre del producto 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actauliza el nombre del producto
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el precio del producto
     * @return 
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Actualiza el precio del producto
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Retorna la cantidad del producto en el inventario
     * @return 
     */
    public int getInventario() {
        return inventario;
    }
    
    /**
     * Actualiza la cantidad del producto en el inventario 
     * @param inventario cantidad de producto en inventario
     */
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    /**
     * Retorna el estado del objeto
     * @return Cadena de caracteresc con los datos del objeto
     */
    @Override
    public String toString() {
        return "Código:" + codigo + "\nNombre:" + this.nombre + "\nPrecio:" + this.precio + "\nInventario:" + this.inventario;
    }
    
    /**
     * Los datos del producto en un arreglo de cadenas de caracteres. Este método se utiliza para agregar elementos al modelo de datos
     * de la tabla o JTable que se utiliza en la interfaz gráfica; porque a una La tabla de datos no pueden agregarse fila con objetos 
     * si no arreglos de cadenas de caracteres
     * 
     * @return Arreglo de cadenas de caracteres
     */
    public String[] registroProducto() {
        String datos[] = new String[4];

        datos[0] = String.valueOf(this.codigo);
        datos[1] = String.valueOf(this.nombre);
        datos[2] = String.valueOf(this.precio);
        datos[3] = String.valueOf(this.inventario);

        return datos;
    }

}