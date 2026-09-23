<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos - Ferretería Los Ángeles</title>
</head>
<body>

    <h1>Gestión de Productos</h1>

    <h2>Registrar producto</h2>

    <form action="ProductoServlet" method="post">

        <label>Nombre:</label>
        <input type="text" name="nombre" required>
        <br><br>

        <label>Descripción:</label>
        <input type="text" name="descripcion" required>
        <br><br>

        <label>Precio:</label>
        <input type="number" name="precio" step="0.01" required>
        <br><br>

        <label>Stock:</label>
        <input type="number" name="stock" required>
        <br><br>

        <label>Categoría:</label>
        <input type="text" name="categoria" required>
        <br><br>

        <label>ID Proveedor:</label>
        <input type="number" name="idProveedor" required>
        <br><br>

        <button type="submit">Guardar producto</button>

    </form>

    <br>

    <a href="index.jsp">Volver al inicio</a>

</body>
</html>