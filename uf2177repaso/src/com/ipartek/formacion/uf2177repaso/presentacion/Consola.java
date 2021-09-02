package com.ipartek.formacion.uf2177repaso.presentacion;

import java.util.Scanner;

import com.ipartek.formacion.uf2177repaso.accesodatos.Dao;
import com.ipartek.formacion.uf2177repaso.accesodatos.DaoMueble;
import com.ipartek.formacion.uf2177repaso.entidades.Mueble;

public class Consola {
	private static Scanner sc = new Scanner(System.in);

	private static final int SALIR = 0;

	private static final int OBTENER_TODOS = 1;

	private static final int OBTENER_POR_ID = 2;

	private static final int INSERTAR = 3;

	private static final int MODIFICAR = 4;

	private static final int BORRAR = 5;
	
	private static final Dao<Mueble> dao = new DaoMueble();

	public static void main(String[] args) {
		int respuesta;

		do {
			mostrarMenu();

			respuesta = pedirRespuesta();

			ejecutarRespuesta(respuesta);
		} while (respuesta != SALIR);
	}

	private static void mostrarMenu() {
		System.out.println("1. Listar");
		System.out.println("2. Obtener por id");
		System.out.println("3. Insertar");
		System.out.println("4. Modificar");
		System.out.println("5. Borrar");

		System.out.println();
		
		System.out.println("0. Salir");
		
		System.out.println();
	}

	private static int pedirRespuesta() {
		System.out.print("Introduce la opción deseada: ");
		
		int respuesta = sc.nextInt();

		sc.nextLine();

		return respuesta;
	}
	
	private static long pedirId() {
		System.out.print("Introduce el id deseado: ");
		
		long respuesta = sc.nextLong();

		sc.nextLine();

		return respuesta;
	}
	
	private static Double pedirDouble(String texto) {
		Double dato;
		
		System.out.print(texto + ": ");
		
		String respuesta = sc.nextLine();

		if(respuesta.trim().length() == 0) {
			dato = null;
		} else {
			dato = Double.parseDouble(respuesta);
		}

		return dato;
	}

	private static void ejecutarRespuesta(int respuesta) {
		switch (respuesta) {
		case OBTENER_TODOS:
			obtenerTodos();
			break;
		case OBTENER_POR_ID:
			obtenerPorId();
			break;
		case INSERTAR:
			insertar();
			break;
		case MODIFICAR:
			modificar();
			break;
		case BORRAR:
			borrar();
			break;
		case SALIR:
			System.out.println("Gracias por usar la aplicación");
			break;
		}
	}

	private static void obtenerPorId() {
		System.out.println("Obtener por id");
		
		long id = pedirId();
		
		mostrarMueble(dao.obtenerPorId(id));
	}

	private static void insertar() {
		System.out.println("Insertar");
		
		String nombre = sc.nextLine();
		Double largo = pedirDouble("Largo");
		Double ancho = pedirDouble("Ancho");
		Double alto = pedirDouble("Alto");
		
		dao.insertar(new Mueble(nombre, largo, ancho, alto));
	}

	private static void modificar() {
		System.out.println("Modificar");
		
		Long id = pedirId();
		String nombre = sc.nextLine();
		Double largo = pedirDouble("Largo");
		Double ancho = pedirDouble("Ancho");
		Double alto = pedirDouble("Alto");
		
		dao.modificar(new Mueble(id, nombre, largo, ancho, alto));
	}

	private static void borrar() {
		System.out.println("Borrar");
		
		Long id = pedirId();
		
		dao.borrar(id);
	}

	private static void obtenerTodos() {
		System.out.println("Obtener Todos");
		
		for (Mueble mueble : dao.obtenerTodos()) {
			mostrarMueble(mueble);
		}
	}

	private static void mostrarMueble(Mueble mueble) {
		System.out.println(mueble);
	}

	public static void mainPruebas(String[] args) {
		Dao<Mueble> dao = new DaoMueble();

		// dao.borrar(1L);

		System.out.println(dao.insertar(new Mueble("Prueba")));

		for (Mueble mueble : dao.obtenerTodos()) {
			mostrarMueble(mueble);
		}

		dao.modificar(new Mueble(2L, "Mueble modificado", 5.0, 6.0, 7.0));

		System.out.println(dao.obtenerPorId(2L));
	}
}
