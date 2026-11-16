package DAO;
import Modelo.Producto;

public class PruebaProducto {
    public static void main(String[] args) {
          Producto producto = new Producto(
            1,
            "Martillo",
            "Martillo de acero",
            25000,
            10,
            "Herramientas",
            1
        );
        ProductoDAO dao = new ProductoDAO();

dao.guardarProducto(producto);

    }

}
