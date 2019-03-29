package IntroduccionJDBC;
import java.sql.*;

public class Main {
	/**
	 * Método main.
	 * @param args
	 */
	public static void main(String[] args) {
		// Cadena de conexión de Mysql, el parametro useSSL es opcional (Solo no manda warning)
		
		String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
		
		//Cargamos el driver de mysql
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Creamos objeto de conexión.
			Connection conexion = (Connection) DriverManager.getConnection(url, "root", "");
			
			//Creamos un objeto Statement
			Statement instruccion = conexion.createStatement();
			
			// Creamos el query 
			String sql = "select * from persona";
			
			ResultSet result = instruccion.executeQuery(sql);
			
			while(result.next()) {
				System.out.println("Id: " + result.getInt(1) + "\nNombre: " + result.getString(2) + "\nApellido: " + result.getString(3));
				
				System.out.println();
			}
			
			result.close();
			instruccion.close();
			conexion.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
