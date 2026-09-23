package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import Modelo.Producto;

/**
 * Clase DAO (Data Access Object) para gestionar los productos.
 *
 * Se encarga de realizar las operaciones de la tabla producto
 * en la base de datos ferreteria.
 */
public class ProductoDAO {

    /**
     * Guarda un nuevo producto en la base de datos.
     *
     * @param producto producto que se desea guardar
     */
    public void guardarProducto(Producto producto) {

        Connection cn = Conexion.conectar();

        if (cn == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        String sql = "INSERT INTO producto "
                + "(idProducto, nombre, descripcion, precio, stock, categoria, idProveedor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

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
                System.out.println("Producto guardado correctamente.");
            }

        } catch (SQLException e) {

            System.out.println("Error al guardar producto: " + e.getMessage());
        }
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param idProducto identificador del producto
     * @return producto encontrado o null si no existe
     */
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

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param producto producto con los datos que se desean actualizar
     */
    public void actualizarProducto(Producto producto) {

        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, "
                + "precio = ?, stock = ?, categoria = ?, idProveedor = ? "
                + "WHERE idProducto = ?";

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
                System.out.println("Producto actualizado correctamente.");
            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    /**
     * Elimina un producto de la base de datos.
     *
     * @param idProducto identificador del producto que se desea eliminar
     */
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
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el producto.");
            }

        } catch (SQLException e) {

            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }
}





