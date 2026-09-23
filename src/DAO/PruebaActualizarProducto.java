package DAO;

import Modelo.Producto;

public class PruebaActualizarProducto {

    public static void main(String[] args) {
        Producto producto = new Producto(
    1,
    "Martillo",
    "Martillo de acero reforzado",
    30000,
    20,
    "Herramientas",
    1
);
ProductoDAO dao = new ProductoDAO();

dao.actualizarProducto(producto);

    }

}