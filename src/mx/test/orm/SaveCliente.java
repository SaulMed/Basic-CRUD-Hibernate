package mx.test.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveCliente {

	public static void main(String[] args) {

		// Crear Session Factory para leer el archivo de configuracion Hibernate
		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// Creacion de obj tipo Session
		Session mySession = myFactory.openSession();

		// Comenzar operaciones con la Session

		try {
			
//Agregar registro en DB			
			Cliente cliente = new Cliente("Ultra", "Lord", 7226598471L);
			// Comenzar Transaccion
			mySession.beginTransaction();
			// Guardar registro en la DB
			mySession.save(cliente);
			//Enviar Commit
			mySession.getTransaction().commit();
			System.out.println("Registro insertado con exito.");

//Consultar registro insertado
			mySession.beginTransaction();
			System.out.println("Datos de cliente No. " + cliente.getId());
			Cliente clienteInsertado = mySession.get(Cliente.class, cliente.getId());
			System.out.println(clienteInsertado);
			mySession.getTransaction().commit();
		} finally {
			// Cerrar recursos
			mySession.close();
			myFactory.close();
		}

	}

}
