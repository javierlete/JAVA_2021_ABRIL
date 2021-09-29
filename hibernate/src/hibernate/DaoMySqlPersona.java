package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoMySqlPersona implements Dao<Persona> {

	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

	public EntityManager abrirTransaccion() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		return em;
	}

	public void cerrarTransaccion(EntityManager em) {
		em.getTransaction().commit();
		em.close();
	}

	private void deshacerTransaccion(EntityManager em) {
		if (em != null) {
			em.getTransaction().rollback();
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Persona> obtenerTodos() {
		EntityManager em = null;
		try {
			em = abrirTransaccion();

			List<Persona> personas = em.createQuery("from Persona").getResultList();

			cerrarTransaccion(em);

			return personas;
		} catch (Exception e) {
			deshacerTransaccion(em);
			throw new DaoException("Ha habido un error al consultar todos los registros", e);
		}
	}

	@Override
	public Persona obtenerPorId(Long id) {
		EntityManager em = null;
		try {
			em = abrirTransaccion();

			Persona persona = em.find(Persona.class, id);

			cerrarTransaccion(em);

			return persona;
		} catch (Exception e) {
			deshacerTransaccion(em);
			throw new DaoException("Ha habido un error al consultar el registro " + id, e);
		}
	}

	@Override
	public Persona insertar(Persona persona) {
		EntityManager em = null;
		try {
			em = abrirTransaccion();

			em.persist(persona);

			cerrarTransaccion(em);

			return persona;
		} catch (Exception e) {
			deshacerTransaccion(em);
			throw new DaoException("Ha habido un error al insertar el registro ", e);
		}
	}

	@Override
	public Persona modificar(Persona persona) {
		EntityManager em = null;
		try {
			em = abrirTransaccion();

			em.merge(persona);

			cerrarTransaccion(em);

			return persona;
		} catch (Exception e) {
			deshacerTransaccion(em);
			throw new DaoException("Ha habido un error al modificar el registro", e);
		}
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = null;
		try {
			em = abrirTransaccion();

			em.remove(em.find(Persona.class, id));

			cerrarTransaccion(em);
		} catch (Exception e) {
			deshacerTransaccion(em);
			throw new DaoException("Ha habido un error al borrar el registro " + id, e);
		}
	}

}
