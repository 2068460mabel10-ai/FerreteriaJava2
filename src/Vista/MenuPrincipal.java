package Vista;

import java.util.Scanner;
import Modelo.Producto;
import DAO.ProductoDAO;

public class MenuPrincipal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("==============================");
            System.out.println("     FERRETERÍA LOS ÁNGELES");
            System.out.println("==============================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.println("==============================");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

    System.out.println("Registrar producto");

    System.out.print("ID del producto: ");
    int id = teclado.nextInt();

    teclado.nextLine();

    System.out.print("Nombre: ");
    String nombre = teclado.nextLine();

    System.out.print("Descripción: ");
    String descripcion = teclado.nextLine();

    System.out.print("Precio: ");
    double precio = teclado.nextDouble();

    System.out.print("Stock: ");
    int stock = teclado.nextInt();

    teclado.nextLine();

    System.out.print("Categoría: ");
    String categoria = teclado.nextLine();

    System.out.print("ID del proveedor: ");
    int idProveedor = teclado.nextInt();

    Producto producto = new Producto(
        id,
        nombre,
        descripcion,
        precio,
        stock,
        categoria,
        idProveedor
    );

    ProductoDAO dao = new ProductoDAO();

    dao.guardarProducto(producto);

    break;

            
                  case 2:

    System.out.println("Buscar producto");

    System.out.print("Ingrese el ID del producto: ");
    int idBuscar = teclado.nextInt();

    ProductoDAO daoBuscar = new ProductoDAO();

    Producto productoEncontrado = daoBuscar.buscarProducto(idBuscar);

    if (productoEncontrado != null) {

        System.out.println("Producto encontrado:");
        System.out.println("ID: " + productoEncontrado.getIdProducto());
        System.out.println("Nombre: " + productoEncontrado.getNombre());
        System.out.println("Descripción: " + productoEncontrado.getDescripcion());
        System.out.println("Precio: " + productoEncontrado.getPrecio());
        System.out.println("Stock: " + productoEncontrado.getStock());
        System.out.println("Categoría: " + productoEncontrado.getCategoria());
        System.out.println("ID Proveedor: " + productoEncontrado.getIdProveedor());

    } else {

        System.out.println("Producto no encontrado");

    }

    break;

                case 3:

    System.out.println("Actualizar producto");

    System.out.print("ID del producto: ");
    int idActualizar = teclado.nextInt();

    teclado.nextLine();

    System.out.print("Nuevo nombre: ");
    String nombreActualizar = teclado.nextLine();

    System.out.print("Nueva descripción: ");
    String descripcionActualizar = teclado.nextLine();

    System.out.print("Nuevo precio: ");
    double precioActualizar = teclado.nextDouble();

    System.out.print("Nuevo stock: ");
    int stockActualizar = teclado.nextInt();

    teclado.nextLine();

    System.out.print("Nueva categoría: ");
    String categoriaActualizar = teclado.nextLine();

    System.out.print("Nuevo ID del proveedor: ");
    int proveedorActualizar = teclado.nextInt();

    Producto productoActualizar = new Producto(
        idActualizar,
        nombreActualizar,
        descripcionActualizar,
        precioActualizar,
        stockActualizar,
        categoriaActualizar,
        proveedorActualizar
    );

    ProductoDAO daoActualizar = new ProductoDAO();

    daoActualizar.actualizarProducto(productoActualizar);

    break;
                case 4:

    System.out.println("Eliminar producto");

    System.out.print("Ingrese el ID del producto: ");
    int idEliminar = teclado.nextInt();

    ProductoDAO daoEliminar = new ProductoDAO();

    daoEliminar.eliminarProducto(idEliminar);

    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");

            }

        } while (opcion != 5);

        teclado.close();
    }
}