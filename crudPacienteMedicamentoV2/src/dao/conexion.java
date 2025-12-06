package dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class conexion {
	private static final String URL = "jdbc:postgresql://localhost:5432/hospital_db";
	private static final String USER = "postgres";
	private static final String PASS = "12345";

	public static Connection obtenerConexion() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital_db", "postgres", "12345");
		} catch (final SQLException e) {
			System.out.println("❌ Error al conectar a la base de datos");
			e.printStackTrace();
			return null;
		}
	}
}