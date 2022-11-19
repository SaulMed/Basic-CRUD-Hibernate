package mx.test.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetClientes {

	// Hql = Hibernate Query Language

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Creacion de Session Factory para la lectura del archivo de configuracion de
		// hibernate
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// Creacion de obj tipo Session
		Session mySession = myFactory.openSession();

		try {
			// Comenzar con la Session
			mySession.beginTransaction();

			// Consulta de Clientes
			String hql = "FROM Cliente";
			List<Cliente> lista = mySession.createQuery(hql).getResultList();

			// Mostrar registros Totales
			mostrarRegistros(lista);

			// Mostrar registros apellidos = Mendoza . apuntando a la propiedad apellidos de nuestra clase Cliente NO a la DB
			hql = "FROM Cliente c WHERE c.apellidos='McGregor'";
			lista = mySession.createQuery(hql).getResultList();

			// Mostrar registros con Apellidos Mendoza
			mostrarRegistros(lista);

			// Mostrar los que se llaman Paulina o los que se apellidan Lord
			hql = "FROM Cliente c WHERE c.nombre='Paulina' OR c.apellidos='Lord'";
			lista = mySession.createQuery(hql).getResultList();

			//Mostrar registros con nombres Paulina o apellidos Lord
			mostrarRegistros(lista);

			// Commit
			mySession.getTransaction().commit();

		} finally {
			mySession.close();
			myFactory.close();
		}

	}

	private static void mostrarRegistros(List<Cliente> lista) {
		for (Cliente cliente : lista) {
			System.out.println(cliente);
		}
	}

}
