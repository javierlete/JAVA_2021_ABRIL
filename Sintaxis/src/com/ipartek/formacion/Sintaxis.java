package com.ipartek.formacion;

/**
 * Clase que muestra la sintaxis básica de Java
 * @author JavierLete
 *
 */
public class Sintaxis {
	/**
	 * Método en el que se inicia la aplicación
	 * @param args argumentos recibidos por consola
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {
		// Comentario de línea
		
		/*
		 * Comentario
		 * multi
		 * línea
		 */
		
		// TIPOS PRIMITIVOS
		// ================
		// ENTEROS (CON SIGNO) -2^(n-1) a 2^(n-1)-1
		
		// byte		 8bits	-128 a 127
		// short	16bits	-32768 a 32767
		// int		32bits	-2147M a 2147M (El más habitual)
		// long		64bits	-9T a 9T
		
		// COMA FLOTANTE (IEEE754)
		
		// float	32bits
		// double	64bits
		
		// BOOLEANO
		
		// boolean	16bits (true, false)
		
		// CARACTER
		
		// char		16bits (UNICODE)
		
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
		System.out.println("Pepe".substring(1,4));
		
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
		s = ((Integer)a).toString();
	}
}
