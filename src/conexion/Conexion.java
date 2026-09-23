package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {

        Connection conexion = null;

       String url = "jdbc:mysql://localhost:3306/ferreteria?useSSL=false&serverTimezone=UTC";
String usuario = "root";
String contraseña = "";

        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos");

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        return conexion;
    }
}