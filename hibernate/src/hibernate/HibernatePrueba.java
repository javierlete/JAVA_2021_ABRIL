package hibernate;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernatePrueba {

	public static void main(String[] args) {
		Dao<Persona> dao = new DaoMySqlPersona();
		
		dao.insertar(new Persona(null, "Pepe", LocalDate.now()));
		dao.insertar(new Persona(null, "Juan", LocalDate.now()));
		dao.insertar(new Persona(null, "Pedro", LocalDate.now()));
		
		Persona persona2 = dao.obtenerPorId(2L);
		
		System.out.println(persona2);
		
		persona2.setNombre("Modificado2");
		
		dao.modificar(persona2);
		
		Persona persona3 = new Persona(3L, "Modificado3", null);
		
		dao.modificar(persona3);
		
		dao.borrar(1L);
		
		for(Persona persona: dao.obtenerTodos()) {
			System.out.println(persona);
		}
	}
	
	public static void mainSinDao(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "hibernate" );;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// INSERTAR
		entityManager.persist(new Persona(null, "Pepe", LocalDate.now()));
		entityManager.persist(new Persona(null, "Juan", LocalDate.now()));
		entityManager.persist(new Persona(null, "Pedro", LocalDate.now()));
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// OBTENER POR ID
		Persona persona2 = entityManager.find(Persona.class, 2L);
		
		System.out.println(persona2);
		
		// MODIFICAR DESDE BUSQUEDA
		persona2.setNombre("Modificado");
		
		// MODIFICAR DESDE OBJETO NUEVO
		Persona persona3 = new Persona(3L, "Modificado3", null);
		
		entityManager.merge(persona3);
		
		// BORRAR
		entityManager.remove(entityManager.find(Persona.class, 1L));
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// OBTENER TODOS
		@SuppressWarnings("unchecked")
		List<Persona> personas = entityManager.createQuery("from Persona").getResultList();
		
		for(Persona persona: personas) {
			System.out.println(persona);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();
	}
}
