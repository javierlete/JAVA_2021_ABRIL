package hibernate;

import java.time.LocalDate;
import java.util.List;

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
		
		// INSERTAR
		session.save(new Persona(null, "Pepe", LocalDate.now()));
		session.save(new Persona(null, "Juan", LocalDate.now()));
		session.save(new Persona(null, "Pedro", LocalDate.now()));
		
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		
		// OBTENER POR ID
		Persona persona2 = session.find(Persona.class, 2L);
		
		System.out.println(persona2);
		
		// MODIFICAR DESDE BUSQUEDA
		persona2.setNombre("Modificado");
		
		// MODIFICAR DESDE OBJETO NUEVO
		Persona persona3 = new Persona(3L, "Modificado3", null);
		
		session.merge(persona3);
		
		// BORRAR
		session.delete(new Persona(1L, null, null));
		
		// session.remove(session.find(Persona.class, 1L));
		
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		
		// OBTENER TODOS
		@SuppressWarnings("unchecked")
		List<Persona> personas = session.createQuery("from Persona").list();
		
		for(Persona persona: personas) {
			System.out.println(persona);
		}
		
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
