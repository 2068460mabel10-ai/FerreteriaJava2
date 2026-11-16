package Modelo;

public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
    private int idProveedor;

    public Producto(){
        
    }

    public Producto(int idProducto, String nombre, String descripcion, double precio, int stock, String categoria, int idProveedor) {

        this.idProducto = idProducto;
        this.descripcion = descripcion ;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.idProveedor = idProveedor;

    }

    public int getIdProducto() {
    return idProducto;
}

public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
}
public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public double getPrecio() {
    return precio;
}

public void setPrecio(double precio) {
    this.precio = precio;
}

public int getStock() {
    return stock;
}

public void setStock(int stock) {
    this.stock = stock;
}

public String getCategoria() {
    return categoria;
}

public void setCategoria(String categoria) {
    this.categoria = categoria;
}
public int getIdProveedor() {
    return idProveedor;
}

public void setIdProveedor(int idProveedor) {
    this.idProveedor = idProveedor;
}

}

