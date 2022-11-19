package mx.test.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURI = "jdbc:mysql://localhost:3306/testHibernate";
		String user = "root";
		String pw = "admin123";

		try {
			System.out.println("Intentando acceder a la Base de Datos: " + jdbcURI);
			Connection miConexion = DriverManager.getConnection(jdbcURI, user, pw);
			System.out.println("Connected to Database: " + miConexion.getCatalog());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
