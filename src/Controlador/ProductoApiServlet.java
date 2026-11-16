package Controlador;

import DAO.ProductoDAO;
import Modelo.Producto;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProductoApiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductoDAO productoDAO;
    private final Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
    }

    // GET: consultar todos los productos o uno por su ID.
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        if (id != null) {
            try {
                int idProducto = Integer.parseInt(id);
                Producto producto = productoDAO.buscarProducto(idProducto);

                if (producto == null) {
                    enviarJSON(response, 404,
                            "{\"mensaje\":\"Producto no encontrado\"}");
                } else {
                    enviarJSON(response, 200, gson.toJson(producto));
                }
            } catch (NumberFormatException e) {
                enviarJSON(response, 400,
                        "{\"mensaje\":\"El ID debe ser numérico\"}");
            }
        } else {
            List<Producto> productos = productoDAO.listarProductos();
            enviarJSON(response, 200, gson.toJson(productos));
        }
    }

    // POST: registrar un producto.
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            Producto producto = gson.fromJson(request.getReader(), Producto.class);

            if (producto == null || producto.getIdProducto() <= 0) {
                enviarJSON(response, 400,
                        "{\"mensaje\":\"Debe enviar un producto con ID válido\"}");
                return;
            }

            if (productoDAO.buscarProducto(producto.getIdProducto()) != null) {
                enviarJSON(response, 409,
                        "{\"mensaje\":\"Ya existe un producto con ese ID\"}");
                return;
            }

            productoDAO.guardarProducto(producto);

            if (productoDAO.buscarProducto(producto.getIdProducto()) != null) {
                enviarJSON(response, 201,
                        "{\"mensaje\":\"Producto registrado correctamente\"}");
            } else {
                enviarJSON(response, 500,
                        "{\"mensaje\":\"No fue posible registrar el producto\"}");
            }

        } catch (Exception e) {
            enviarJSON(response, 400,
                    "{\"mensaje\":\"Datos JSON inválidos o incompletos\"}");
        }
    }

    // PUT: actualizar un producto existente.
    @Override
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            Producto producto = gson.fromJson(request.getReader(), Producto.class);

            if (producto == null || producto.getIdProducto() <= 0) {
                enviarJSON(response, 400,
                        "{\"mensaje\":\"Debe enviar un ID válido\"}");
                return;
            }

            if (productoDAO.buscarProducto(producto.getIdProducto()) == null) {
                enviarJSON(response, 404,
                        "{\"mensaje\":\"Producto no encontrado\"}");
                return;
            }

            productoDAO.actualizarProducto(producto);

            enviarJSON(response, 200,
                    "{\"mensaje\":\"Solicitud de actualización procesada\"}");

        } catch (Exception e) {
            enviarJSON(response, 400,
                    "{\"mensaje\":\"Datos JSON inválidos o incompletos\"}");
        }
    }

    // DELETE: eliminar un producto por su ID.
    @Override
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            String id = request.getParameter("id");

            if (id == null) {
                enviarJSON(response, 400,
                        "{\"mensaje\":\"Debe indicar el ID del producto\"}");
                return;
            }

            int idProducto = Integer.parseInt(id);

            if (productoDAO.buscarProducto(idProducto) == null) {
                enviarJSON(response, 404,
                        "{\"mensaje\":\"Producto no encontrado\"}");
                return;
            }

            productoDAO.eliminarProducto(idProducto);

            if (productoDAO.buscarProducto(idProducto) == null) {
                enviarJSON(response, 200,
                        "{\"mensaje\":\"Producto eliminado correctamente\"}");
            } else {
                enviarJSON(response, 500,
                        "{\"mensaje\":\"No fue posible eliminar el producto\"}");
            }

        } catch (NumberFormatException e) {
            enviarJSON(response, 400,
                    "{\"mensaje\":\"El ID debe ser numérico\"}");
        }
    }

    // Método para enviar respuestas JSON con su código HTTP.
    private void enviarJSON(HttpServletResponse response,
                            int estado,
                            String contenido) throws IOException {

        response.setStatus(estado);
        response.getWriter().write(contenido);
    }
}