package com.ipartek.formacion.poo.pruebas;

public class ClasesAbstractas {

	public static void main(String[] args) {
		Number[] numeros = new Number[2];
		
		numeros[0] = 2; //new Integer(2);
		numeros[1] = 2.5; //new Double(2.5);
		
		for(Number numero: numeros) {
			System.out.println(numero.intValue());
		}
	}
}
