package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.ProductoDAO;
import Modelo.Producto;

public class ProductoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
    }

     @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String accion = request.getParameter("accion");

    ProductoDAO dao = new ProductoDAO();

    if ("buscar".equals(accion)) {

        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        Producto producto = dao.buscarProducto(idProducto);

        request.setAttribute("producto", producto);
        request.getRequestDispatcher("/productos.jsp").forward(request, response);

    } else if ("eliminar".equals(accion)) {

        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        dao.eliminarProducto(idProducto);

        response.sendRedirect("productos.jsp");

    } else {

        response.sendRedirect("productos.jsp");
    }
}


@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String accion = request.getParameter("accion");

    ProductoDAO dao = new ProductoDAO();

    if ("guardar".equals(accion)) {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String categoria = request.getParameter("categoria");
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));

        Producto producto = new Producto();

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setCategoria(categoria);
        producto.setIdProveedor(idProveedor);

        dao.guardarProducto(producto);

        response.sendRedirect("productos.jsp");

    } else if ("actualizar".equals(accion)) {

        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String categoria = request.getParameter("categoria");
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));

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

    } else {

        response.sendRedirect("productos.jsp");
    }
}
}