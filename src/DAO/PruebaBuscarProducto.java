package DAO;

import Modelo.Producto;

public class PruebaBuscarProducto {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        Producto producto = dao.buscarProducto(1);

        if (producto != null) {

            System.out.println("Producto encontrado:");
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Categoría: " + producto.getCategoria());
            System.out.println("Proveedor: " + producto.getIdProveedor());

        } else {

            System.out.println("Producto no encontrado");

        }

    }

}