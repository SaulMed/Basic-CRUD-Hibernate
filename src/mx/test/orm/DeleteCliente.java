package mx.test.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCliente {

	public static void main(String[] args) {
		// Crear Session Factory para lectura del archivo de configuracion hibernate
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// Creacion de obj tipo Session
		Session mySession = myFactory.openSession();

		try {
			// Sentencia para eliminar registro
			mySession.beginTransaction();

			// Preparar sentencia para eliminar
			String hqlDelete = "DELETE Cliente WHERE Id='2'";
			mySession.createQuery(hqlDelete).executeUpdate();

			// Ejecutar transaccion
			mySession.getTransaction().commit();
			System.out.println("Registro eliminado conexito.");

		} finally {
			mySession.close();
			myFactory.close();
		}
	}

}
