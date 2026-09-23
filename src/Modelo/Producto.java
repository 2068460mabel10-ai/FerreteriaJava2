package Modelo;

/**
 * Modelo que representa un producto de la Ferretería Los Ángeles.
 * Contiene los datos principales utilizados por el sistema.
 */
public class Producto {

    // Identificación del producto
    private int idProducto;

    // Información básica del producto
    private String nombre;
    private String descripcion;

    // Información comercial
    private double precio;
    private int stock;
    private String categoria;

    // Identificación del proveedor relacionado
    private int idProveedor;

    /**
     * Constructor vacío.
     * Se utiliza para crear un producto y asignar sus datos
     * mediante los métodos setter.
     */
    public Producto() {

    }

    /**
     * Constructor completo para crear un producto con todos sus datos.
     */
    public Producto(int idProducto, String nombre, String descripcion,
                    double precio, int stock, String categoria, int idProveedor) {

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.idProveedor = idProveedor;
    }

    // Métodos para obtener y modificar el ID del producto
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    // Métodos para obtener y modificar la descripción
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos para obtener y modificar el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y modificar el precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Métodos para obtener y modificar el stock
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Métodos para obtener y modificar la categoría
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Métodos para obtener y modificar el proveedor
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}