package com.ipartek.formacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase que muestra la sintaxis básica de Java
 * 
 * @author JavierLete
 *
 */
public class Sintaxis {
	/**
	 * Método en el que se inicia la aplicación
	 * 
	 * @param args argumentos recibidos por consola
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public static void mainTiposBasicos(String[] args) {
		// Comentario de línea

		/*
		 * Comentario multi línea
		 */

		// TIPOS PRIMITIVOS
		// ================
		// ENTEROS (CON SIGNO) -2^(n-1) a 2^(n-1)-1

		// byte 8bits -128 a 127
		// short 16bits -32768 a 32767
		// int 32bits -2147M a 2147M (El más habitual)
		// long 64bits -9T a 9T

		// COMA FLOTANTE (IEEE754)

		// float 32bits
		// double 64bits

		// BOOLEANO

		// boolean 16bits (true, false)

		// CARACTER

		// char 16bits (UNICODE)

		int i = 5;

		int x;

		x = 7;

		System.out.println(i);
		System.out.println(x);

		long l = 123123123123123l;

		System.out.println(l);

		boolean b = true;

		char c = 'c';

		char enter = '\n';

		double d = 5.4;

		float f = 5;

		i = (int) d;

		// TIPOS ENCAPSULADOS

		// Byte, Short, Integer, Long, Float, Double, Character, Boolean

		Integer ii = new Integer(i);

		// Java5
		ii = i;

		ii = null;

		// STRING

		String nombre = "Javier";
		String nombre2 = new String("Javier");

		System.out.println(nombre.equalsIgnoreCase(nombre2));
		System.out.println("          ahsdfkhasdfjk jkljhñlkahsfd         ".trim());
		System.out.println("Javier".equals(nombre));
		System.out.println("Pepe".compareTo("Juan") > 0); // "Pepe" > "Juan"
		System.out.println("Pepillo".toLowerCase());
		System.out.println("Pepe".substring(1, 4));

		System.out.println("En un lugar de la Mancha de cuyo...".replace("Mancha", "Marcha"));

		String texto = "";
		texto = "Hola " + nombre;

		String log = "";

		log = log + "Primer dato\n";
		log = log + "Segundo dato\n";

		System.out.println(log);

		log = new StringBuffer(log).append("Primer dato\n").toString();
		log = new StringBuffer(log).append("Segundo dato\n").toString();

		StringBuffer miLog = new StringBuffer();

		miLog.append("Un dato\n");
		miLog.append("Otro dato\n");

		System.out.println(miLog.toString());

		System.out.println("Hola " + nombre + ", ¿qué tal estás?");

		// Java5
		String saludo = String.format("Hola %s, ¿qué tal estás?", nombre);
		System.out.println(saludo);

		System.out.printf("Un número es %x y el otro es %1.2f", 50, 70.1267);

		int a = 5;

		String s = String.valueOf(a);

		s = "" + a; // Muy mala opción
		s = new StringBuffer("").append(a).toString();
		s = ((Integer) a).toString();

	}

	/**
	 * Fechas
	 * 
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void mainFechas(String[] args) {
		// Java 1.0
		Date date = new Date();
		System.out.println(date);
		System.out.println((date.getYear() + 1900) + "/" + (date.getMonth() + 1) + "/" + date.getDate());

		// Java 1.1
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		System.out.println(
				gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.DAY_OF_MONTH));

		// Java 8 (o JodaTime con Java5 o superior)
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		System.out.println(ld.getYear() + "/" + ld.getMonthValue() + "/" + ld.getDayOfMonth());
	}

	/**
	 * Arrays
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void mainArrays(String[] args) {
		int[] arr;
		int tamanyo = 3;
		arr = new int[tamanyo];
		int[] arr2 = new int[10];

		System.out.println(arr.length);

		arr[0] = 67;
		arr[1] = 12;
		arr[2] = 56;
		// arr[3] = 12; // Da error

		char[][] tablero = new char[8][8];

		tablero[0][0] = 'T';
		tablero[0][1] = 'C';

		tablero[7][0] = 't';
		tablero[7][7] = 't';

		System.out.println(tablero.length);
		System.out.println(tablero[0].length);
	}

	/**
	 * Colecciones
	 * 
	 * @param args
	 */
	public static void mainColecciones(String[] args) {
		// Java 5 <String> Java8 <>
		// Colección de elementos que pueden estar repetidos (Listas)
		ArrayList<String> al = new ArrayList<>();

		al.add("Uno");
		al.add("Dos");
		al.add("Tres");
		al.add("Uno");

		System.out.println(al.size());

		al.remove(1);

		System.out.println(al.get(1));

		// Colección de elementos sin repeticiones (Conjuntos)
		HashSet<String> hs = new HashSet<>();

		hs.add("Uno");
		hs.add("Dos");
		hs.add("Tres");
		hs.add("Uno");

		System.out.println(hs.size());

		Iterator<String> iterator = hs.iterator();

		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		// System.out.println(iterator.next());

		// "Diccionario" (pares clave/valor)
		HashMap<String, Integer> hm = new HashMap<>();

		hm.put("uno", 1);
		hm.put("dos", 2);

		System.out.println(hm.get("dos"));

		HashMap<String, String> dic = new HashMap<>();

		dic.put("casa", "house");
		dic.put("perro", "dog");

		System.out.println(dic.get("perro"));
	}

	/**
	 * Entrada por teclado
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void mainConsola(String[] args) throws IOException {
		System.out.println("Bienvenido a este programa");

		// Java 5
		Scanner s = new Scanner(System.in);

		System.out.print("¿Cómo te llamas? ");
		String nombre = s.nextLine(); // Javier\n

		System.out.println("Hola " + nombre);

		System.out.print("¿Años de experiencia? ");
		int anyos = s.nextInt(); // 24\n
		s.nextLine(); // \n
		// Buffer vacío

		System.out.println("Osea que tienes " + anyos + " años de experiencia...");

		System.out.println("¿Especialidad?");
		String especialidad = s.nextLine(); // \n

		System.out.println(especialidad.toUpperCase() + " es una buena especialidad");

		System.out.println("¿Hobby?");
		String hobby = s.nextLine();

		System.out.println(hobby.toUpperCase() + " es un buen hobby");

		s.close();

		// Versiones anteriores
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();

		int dato = Integer.parseInt(linea);

		String texto = String.valueOf(dato);

		System.out.println(texto);

		// Java 6 Funciona pero solo en consola real
		// String linea = System.console().readLine();

		// System.out.println(linea);
	}

	/**
	 * Estructuras de control
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean estaEncendido = true;

		if (!estaEncendido) {
			System.out.println("Es falso");
		} else {
			System.out.println("Es verdadero");
			System.out.println("El motor está encendido");
		}

		int numero = 101;

		if (numero > 100) {
			System.out.println("El número es mayor que 100");
		} else if (numero > 50) {
			System.out.println("El número es mayor que 50");
		} else {
			System.out.println("No tengo nada que decir");
		}

		// Sólo admite enteros y boolean + String en Java 7 o superior

		int opcion = 2;

		switch (opcion) {
		case 1:
			System.out.println("Opción 1");
			break;
		case 2:
			System.out.println("Opción 2");
			break;
		default:
			System.out.println("Opción no reconocida");
		}

		String nombre = "Javier";

		switch (nombre) {
		case "Javier":
			System.out.println("¡Tú eres el profe!");
			break;
		case "Pepe":
			System.out.println("¡Tú eres el ejemplo por defecto!");
			break;
		default:
			System.out.println("Tú eres un nombre normal y corriente");
		}

		int mes = 4, dias;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.println(dias);

		int c = 1;

		while (c <= 3) {
			System.out.println(c++);
		}

		c = 1;

		do {
			System.out.println(c++);
		} while (c <= 3);

		for (int i = 1; i <= 3; i++) {
			System.out.println(i);
		}

		// int i = 1;
		// while(i <= 3) {
		// System.out.println(i);
		// i++;
		// }

		for (int j = 5, k = 10; j < k; j++, k -= 2, System.out.println(j + ", " + k)) {
		}

		int[] arr = { 1, 5, 67, 89, 0, 67, 43, 56 };
		boolean encontrado = false;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");

			if (arr[i] == 0) {
				encontrado = true;
				break;
			}
		}

		System.out.println(encontrado ? "Hemos encontrado un cero" : "No lo hemos encontrado");

		encontrado = false;

//		for(int i = 0; i < arr.length && !(encontrado = arr[i] == 0); i++) {
//			System.out.print(arr[i] + "\t");
//		}

		for (int i = 0; i < arr.length && !encontrado; i++) {
			System.out.print(arr[i] + "\t");

			if (arr[i] == 0) {
				encontrado = true;
			}
		}

		System.out.println(encontrado ? "Hemos encontrado un cero" : "No lo hemos encontrado");

		// Java 5, parecido a for(var dato of arr) en JavaScript o foreach(int dato:
		// arr) en C#

		encontrado = false;

		for (int dato : arr) {
			System.out.print(dato + "\t");

			if (dato == 0) {
				encontrado = true;
				break;
			}
		}

		System.out.println(encontrado ? "Hemos encontrado un cero" : "No lo hemos encontrado");

		encontrado = false;

		// Mala alternativa ya que sigue repitiendo aunque no haga nada con los datos y haya encontrado lo que buscaba
		for (int dato : arr) {
			if (!encontrado) {
				System.out.print(dato + "\t");

				if (dato == 0) {
					encontrado = true;
				}
			}
		}

		System.out.println(encontrado ? "Hemos encontrado un cero" : "No lo hemos encontrado");

		if (arr[0] == 56454)
			; // Metedura de pata monumental SOBRA EL PUNTO Y COMA
		{
			int variableInterna = 5;
			System.out.println("Crea un ámbito para las variables declaradas dentro");
			System.out.println(variableInterna);
		}

		// System.out.println(variableInterna);
	}

	{
		System.out.println("No hace nada");
	}
}
