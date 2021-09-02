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

	private static void ejecutarRespuesta(int respuesta) {
		switch (respuesta) {
		case OBTENER_TODOS:
			System.out.println("Obtener Todos");
			break;
		case OBTENER_POR_ID:
			System.out.println("Obtener por ID");
			break;
		case INSERTAR:
			System.out.println("Insertar");
			break;
		case MODIFICAR:
			System.out.println("Modificar");
			break;
		case BORRAR:
			System.out.println("Borrar");
			break;
		case SALIR:
			System.out.println("Gracias por usar la aplicación");
			break;
		}
	}

	public static void mainPruebas(String[] args) {
		Dao<Mueble> dao = new DaoMueble();

		// dao.borrar(1L);

		System.out.println(dao.insertar(new Mueble("Prueba")));

		for (Mueble mueble : dao.obtenerTodos()) {
			System.out.println(mueble);
		}

		dao.modificar(new Mueble(2L, "Mueble modificado", 5.0, 6.0, 7.0));

		System.out.println(dao.obtenerPorId(2L));
	}
}
