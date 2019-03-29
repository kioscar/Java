package ManejoPersonas.datos;
import java.sql.*;

public class Conexion {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/sga?useSSL=false";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "";
	private static Driver driver = null;
	
	/**
	 * Método encargado de crear la conexión a la base de datos.
	 * @return Instancia de la conexión recien creada.
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection() throws SQLException{
		if (driver == null) {
			try {
				@SuppressWarnings("rawtypes")
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Falló en cargar el driver JDBC");
				e.printStackTrace();
			}
		} // if
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}
	
	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
