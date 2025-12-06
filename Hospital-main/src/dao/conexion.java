package dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class conexion {

	    private static final String URL = "jdbc:postgresql://localhost:5432/hospital_db";
	    private static final String USER = "postgres";
	    private static final String PASS = "12we";

	    public static Connection obtenerConexion() {
	        try {
	            return DriverManager.getConnection(URL, USER, PASS);
	        } catch (SQLException e) {
	            System.out.println("❌ Error al conectar a la base de datos");
	            e.printStackTrace();
	            return null;
	        }
	    }
}
