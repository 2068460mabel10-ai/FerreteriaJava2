package DAO;

import conexion.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ProductoDAO {
    public void guardarProducto(Producto producto) {

        Connection cn = Conexion.conectar();

    if (cn == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
    }

String sql = "INSERT INTO producto (idProducto, nombre, descripcion, precio, stock, categoria, idProveedor) VALUES (?, ?, ?, ?, ?, ?, ?)";

try {

        PreparedStatement ps = cn.prepareStatement(sql);

ps.setInt(1, producto.getIdProducto());
ps.setString(2, producto.getNombre());
ps.setString(3, producto.getDescripcion());
ps.setDouble(4, producto.getPrecio());
ps.setInt(5, producto.getStock());
ps.setString(6, producto.getCategoria());
ps.setInt(7, producto.getIdProveedor());
int resultado = ps.executeUpdate();

if (resultado > 0) {
    System.out.println("Producto guardado correctamente");
}

    } catch (SQLException e) {

        System.out.println("Error al guardar producto: " + e.getMessage());

    }

    }

    public Producto buscarProducto(int idProducto) { 
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        Connection cn = Conexion.conectar();

    if (cn == null) {
        return null;
    }

    try {

        PreparedStatement ps = cn.prepareStatement(sql);

        ps.setInt(1, idProducto);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Producto producto = new Producto(
    rs.getInt("idProducto"),
    rs.getString("nombre"),
    rs.getString("descripcion"),
    rs.getDouble("precio"),
    rs.getInt("stock"),
    rs.getString("categoria"),
    rs.getInt("idProveedor")
);

return producto;

}

    } catch (SQLException e) {

        System.out.println("Error al buscar producto: " + e.getMessage());

    }

    return null;
}

public void actualizarProducto (Producto
    producto) {
       String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, stock = ?, categoria = ?, idProveedor = ? WHERE idProducto = ?"; 
      Connection cn = Conexion.conectar();

if (cn == null) {
    return;
    
}
try {

    PreparedStatement ps = cn.prepareStatement(sql);
    ps.setString(1, producto.getNombre());
ps.setString(2, producto.getDescripcion());
ps.setDouble(3, producto.getPrecio());
ps.setInt(4, producto.getStock());
ps.setString(5, producto.getCategoria());
ps.setInt(6, producto.getIdProveedor());
ps.setInt(7, producto.getIdProducto());
int resultado = ps.executeUpdate();

if (resultado > 0) {
    System.out.println("Producto actualizado correctamente");
}

} catch (SQLException e) {

    System.out.println("Error al actualizar producto: " + e.getMessage());

}
    }
    public void eliminarProducto(int idProducto) {

        String sql = "DELETE FROM producto WHERE idProducto = ?";

        Connection cn = Conexion.conectar();

        if (cn == null) {
            return;
        }

        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idProducto);

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Producto eliminado correctamente");
            } else {
                System.out.println("No se encontró el producto");
            }

        } catch (SQLException e) {

            System.out.println("Error al eliminar producto: " + e.getMessage());

        }
    }// Consulta todos los productos registrados en la base de datos.
    public java.util.List<Producto> listarProductos() {

        java.util.List<Producto> productos = new java.util.ArrayList<>();

        String sql = "SELECT * FROM producto";
        Connection cn = Conexion.conectar();

        if (cn == null) {
    System.out.println("ERROR: La conexión a la base de datos es nula.");
    return productos;
} else {
    System.out.println("CONEXIÓN CORRECTA: Java está conectado a la base de datos.");
}

        try (PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getString("categoria"),
                    rs.getInt("idProveedor")
                );

                productos.add(producto);
            }

       } catch (SQLException e) {
    e.printStackTrace();
}

        return productos;
    }

}

        
   






