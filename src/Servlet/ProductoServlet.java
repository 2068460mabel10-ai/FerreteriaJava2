package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.ProductoDAO;
import Modelo.Producto;

/**
 * Servlet encargado de gestionar las solicitudes del módulo Productos.
 *
 * Permite realizar las operaciones de guardar, buscar,
 * actualizar y eliminar productos.
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Objeto encargado de realizar las operaciones con la base de datos.
    private ProductoDAO productoDAO;

    /**
     * Inicializa el Servlet y crea el objeto DAO.
     */
    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
    }

    /**
     * Gestiona las solicitudes GET.
     *
     * Se utiliza principalmente para buscar y eliminar productos.
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene la acción enviada desde la página web.
        String accion = request.getParameter("accion");

        ProductoDAO dao = new ProductoDAO();

        // Busca un producto por su ID.
        if ("buscar".equals(accion)) {

            int idProducto =
                    Integer.parseInt(request.getParameter("idProducto"));

            Producto producto = dao.buscarProducto(idProducto);

            // Envía el producto encontrado a la página JSP.
            request.setAttribute("producto", producto);

            request.getRequestDispatcher("/productos.jsp")
                    .forward(request, response);

        // Elimina un producto por su ID.
        } else if ("eliminar".equals(accion)) {

            int idProducto =
                    Integer.parseInt(request.getParameter("idProducto"));

            dao.eliminarProducto(idProducto);

            response.sendRedirect("productos.jsp");

        // Si no se recibe una acción válida, regresa a productos.
        } else {

            response.sendRedirect("productos.jsp");
        }
    }

    /**
     * Gestiona las solicitudes POST.
     *
     * Se utiliza para guardar y actualizar productos.
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene la acción enviada desde el formulario.
        String accion = request.getParameter("accion");

        ProductoDAO dao = new ProductoDAO();

        // Guarda un nuevo producto.
        if ("guardar".equals(accion)) {

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            double precio =
                    Double.parseDouble(request.getParameter("precio"));
            int stock =
                    Integer.parseInt(request.getParameter("stock"));
            String categoria = request.getParameter("categoria");
            int idProveedor =
                    Integer.parseInt(request.getParameter("idProveedor"));

            Producto producto = new Producto();

            producto.setIdProducto(
                    Integer.parseInt(request.getParameter("idProducto")));
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setCategoria(categoria);
            producto.setIdProveedor(idProveedor);

            dao.guardarProducto(producto);

            response.sendRedirect("productos.jsp");

        // Actualiza un producto existente.
        } else if ("actualizar".equals(accion)) {

            int idProducto =
                    Integer.parseInt(request.getParameter("idProducto"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            double precio =
                    Double.parseDouble(request.getParameter("precio"));
            int stock =
                    Integer.parseInt(request.getParameter("stock"));
            String categoria = request.getParameter("categoria");
            int idProveedor =
                    Integer.parseInt(request.getParameter("idProveedor"));

            Producto producto = new Producto();

            producto.setIdProducto(idProducto);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setCategoria(categoria);
            producto.setIdProveedor(idProveedor);

            dao.actualizarProducto(producto);

            response.sendRedirect("productos.jsp");

        // Si no se recibe una acción válida, regresa a productos.
        } else {

            response.sendRedirect("productos.jsp");
        }
    }
}