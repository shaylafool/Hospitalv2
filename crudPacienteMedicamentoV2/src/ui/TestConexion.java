package ui;

import java.sql.Connection;
import dao.conexion;

public class TestConexion {
    public static void main(String[] args) {
        Connection c = conexion.obtenerConexion();
        if (c != null) {
            System.out.println("✔ Conexión exitosa a PostgreSQL");
            try { c.close(); } catch (Exception e) {}
        } else {
            System.out.println("❌ No se pudo conectar. Revisa URL/usuario/contraseña/servicio");
        }
    }
}
