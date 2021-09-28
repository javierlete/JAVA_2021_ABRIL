package hibernate;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernatePrueba {

	public static void main(String[] args) {
		SessionFactory factory = obtenerSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(new Persona(null, "Pepe", LocalDate.now()));
		session.save(new Persona(null, "Juan", LocalDate.now()));
		session.save(new Persona(null, "Pedro", LocalDate.now()));
		
		session.getTransaction().commit();
		session.close();
	}

	private static SessionFactory obtenerSessionFactory() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
			throw e;
		}
	}

}
