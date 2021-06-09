package com.ipartek.formacion.uf2406.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2406.modelos.Usuario;

public class UsuarioDao {
	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	static {
		usuarios.put(1L, new Usuario(1L, "javier@email.net", "contra", "Javier"));
		usuarios.put(2L, new Usuario(2L, "pepe@email.net", "perez", "Pepe"));
		usuarios.put(3L, new Usuario(3L, "juan@email.net", "juanes", "Juan"));
	}
	
	public static Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}
	
	public static Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}
	
	public static Usuario obtenerPorEmail(String email) {
//		for(Usuario usuario: usuarios.values()) {
//			if(email.equals(usuario.getEmail())) {
//				return usuario;
//			}
//		}
//		
//		return null;
		
		return usuarios.values().stream()
				.filter(usuario -> email.equals(usuario.getEmail()))
				.findFirst().orElse(null);
	}
	
	public static void insertar(Usuario usuario) {
		Long id = usuarios.lastKey() + 1;
		usuario.setId(id);
		usuarios.put(usuario.getId(), usuario);
	}
	
	public static void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}
	
	public static void borrar(Long id) {
		usuarios.remove(id);
	}
}
