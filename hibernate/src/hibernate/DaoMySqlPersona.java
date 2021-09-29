package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoMySqlPersona implements Dao<Persona> {

	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "hibernate" );
	
	public EntityManager abrirTransaccion()
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		return em;
	}
	
	public void cerrarTransaccion(EntityManager em)
	{
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Persona> obtenerTodos() {
		EntityManager em = abrirTransaccion();
		
		List<Persona> personas = em.createQuery("from Persona").getResultList();
		
		cerrarTransaccion(em);
		
		return personas;
	}

	@Override
	public Persona obtenerPorId(Long id) {
		EntityManager em = abrirTransaccion();
		
		Persona persona = em.find(Persona.class, id);
		
		cerrarTransaccion(em);
		
		return persona;
	}

	@Override
	public Persona insertar(Persona persona) {
		EntityManager em = abrirTransaccion();
		
		em.persist(persona);
		
		cerrarTransaccion(em);
		
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) {
		EntityManager em = abrirTransaccion();
		
		em.merge(persona);
		
		cerrarTransaccion(em);
		
		return persona;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = abrirTransaccion();
		
		em.remove(em.find(Persona.class, id));
		
		cerrarTransaccion(em);
	}

}
