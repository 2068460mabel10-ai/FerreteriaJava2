package conexion;

import java.sql.Connection;

public class PruebaConexion {

    public static void main(String[] args) {

        Connection cn = Conexion.conectar();

        if (cn != null) {
            System.out.println("La base de datos esta lista para trabajar");
        } else {
            System.out.println("No se pudo conectar");
        }

    }

}

