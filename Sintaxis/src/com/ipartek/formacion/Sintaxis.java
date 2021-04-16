package com.ipartek.formacion;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase que muestra la sintaxis b�sica de Java
 * 
 * @author JavierLete
 *
 */
public class Sintaxis {
	/**
	 * M�todo en el que se inicia la aplicaci�n
	 * 
	 * @param args argumentos recibidos por consola
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public static void mainTiposBasicos(String[] args) {
		// Comentario de l�nea

		/*
		 * Comentario multi l�nea
		 */

		// TIPOS PRIMITIVOS
		// ================
		// ENTEROS (CON SIGNO) -2^(n-1) a 2^(n-1)-1

		// byte 8bits -128 a 127
		// short 16bits -32768 a 32767
		// int 32bits -2147M a 2147M (El m�s habitual)
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
		System.out.println("          ahsdfkhasdfjk jkljh�lkahsfd         ".trim());
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

		System.out.println("Hola " + nombre + ", �qu� tal est�s?");

		// Java5
		String saludo = String.format("Hola %s, �qu� tal est�s?", nombre);
		System.out.println(saludo);

		System.out.printf("Un n�mero es %x y el otro es %1.2f", 50, 70.1267);

		int a = 5;

		String s = String.valueOf(a);

		s = "" + a; // Muy mala opci�n
		s = new StringBuffer("").append(a).toString();
		s = ((Integer) a).toString();

	}

	/**
	 * Fechas
	 * 
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Java 1.0
		Date date = new Date();
		System.out.println(date);
		System.out.println((date.getYear() + 1900) + "/" + (date.getMonth() + 1) + "/" + date.getDate());
		
		// Java 1.1
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		System.out.println(gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.DAY_OF_MONTH));
		
		// Java 8 (o JodaTime con Java5 o superior)
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		System.out.println(ld.getYear() + "/" + ld.getMonthValue() + "/" + ld.getDayOfMonth());
	}
}
