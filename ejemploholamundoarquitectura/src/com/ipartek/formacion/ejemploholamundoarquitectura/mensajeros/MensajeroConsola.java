package com.ipartek.formacion.ejemploholamundoarquitectura.mensajeros;

public class MensajeroConsola implements Mensajero {

	@Override
	public void enviarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
}
