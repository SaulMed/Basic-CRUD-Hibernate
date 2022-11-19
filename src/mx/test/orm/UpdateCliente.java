package mx.test.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateCliente {

	public static void main(String[] args) {

		// Crear Session Factory para la lectura del arhcivo de confiracion hibernate
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// Creacion de obj tipo Session
		Session mySession = myFactory.openSession();

		try {

			// Actualizar directamente un registro usando POO
//			int idCliente = 2;	//No de registro a modificar

			// Consultar registros con apellido que inician con "M"

//			Cliente miCliente = mySession.get(Cliente.class, idCliente);	//Almacenar el obj cliente a modificar
			// Cargar nueva data
//			miCliente.setNombre("NameModify");
//			miCliente.setApellidos("LastNameModify");
//			miCliente.setTelefono(7224468454L);

			mySession.beginTransaction();

			// Preparar sentencia con clausula LIKE
			String hqlUpdate = "UPDATE Cliente SET Apellidos='Green' WHERE Apellidos LIKE 'M%' ";
			mySession.createQuery(hqlUpdate).executeUpdate();

			mySession.getTransaction().commit();
			System.out.println("Actualizacion realizada con exito.");
		} finally {
			// Cerrar recursos
			mySession.close();
			myFactory.close();
		}

	}

}
