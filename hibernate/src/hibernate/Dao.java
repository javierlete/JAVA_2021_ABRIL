package hibernate;

public interface Dao<T> {
	public Iterable<T> obtenerTodos();
	public T obtenerPorId(Long id);
	
	public T insertar(T objeto);
	public T modificar(T objeto);
	public void borrar(Long id);
}
