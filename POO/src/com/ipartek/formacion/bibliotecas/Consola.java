package com.ipartek.formacion.bibliotecas;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Biblioteca que facilita el uso de la entrada y salida en consola
 * @author JavierLete
 *
 */
public class Consola {
	// Atributo estático ("de clase")
	// final -> No se puede modificar una vez inicializado (constante = static final)
	private static final Scanner SCANNER = new Scanner(System.in);
	
	/**
	 * Método sustituto de System.out.println
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 */
	public static void pl(Object mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * Método sustituto de System.out.print (sin enter)
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 */
	public static void p(Object mensaje) {
		System.out.print(mensaje);
	}
	
	/**
	 * Lee un texto de consola mostrando un mensaje para pedirlo.
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return texto introducido sin espacios en los laterales
	 */
	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return SCANNER.nextLine().trim();
	}
	
	/**
	 * Lee un long introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return long introducido
	 */
	public static long leerLong(String mensaje) {
		String linea = leerString(mensaje);
		return Long.parseLong(linea);
	}
	
	/**
	 * Lee un int introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return int introducido
	 */
	public static int leerInt(String mensaje) {
		int i = 0;
		boolean correcto = false;
		String linea;
		
		do {
			linea = leerString(mensaje);
			try {
				i = Integer.parseInt(linea);
				correcto = true;
			} catch (NumberFormatException e) {
				pl("Debes introducir un número que sea entero");
			} 
		} while (!correcto);
		
		return i;
	}
	
	/**
	 * Lee un short introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return short introducido
	 */
	public static short leerShort(String mensaje) {
		String linea = leerString(mensaje);
		return Short.parseShort(linea);
	}

	/**
	 * Lee un byte introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return byte introducido
	 */
	public static byte leerByte(String mensaje) {
		String linea = leerString(mensaje);
		return Byte.parseByte(linea);
	}

	/**
	 * Lee un double introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return double introducido
	 */
	public static double leerDouble(String mensaje) {
		String linea = leerString(mensaje);
		return Double.parseDouble(linea);
	}
	
	/**
	 * Lee un float introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return float introducido
	 */
	public static double leerFloat(String mensaje) {
		String linea = leerString(mensaje);
		return Float.parseFloat(linea);
	}
	
	/**
	 * Lee un char introducido por consola, mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return char introducido (coge el primero escrito, después de eliminar los espacios laterales)
	 */
	public static char leerChar(String mensaje) {
		String linea = leerString(mensaje);
		return linea.charAt(0);
	}
	
	/**
	 * Lee un s/n de la consola (sin distinguir mayúsculas de minúsculas), mostrando un mensaje para pedirlo
	 * @param mensaje mensaje que se quiere mostrar al usuario
	 * @return si se ha introducido 'S' ó 's' devuelve true, y si no, false
	 */
	public static boolean leerBoolean(String mensaje) {
		char sn = leerChar(mensaje + "(S/N)");
		return Character.toUpperCase(sn) == 'S';
	}
	
	public static LocalDate leerLocalDate(String mensaje) {
		String linea = leerString(mensaje + " (AAAA-MM-DD)");
		return LocalDate.parse(linea);
	}
}
