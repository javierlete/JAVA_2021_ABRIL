package com.ipartek.formacion.ejemploholamundoarquitecturaspring.mensajeros;

import org.springframework.stereotype.Component;

@Component
public class MensajeroConsolaBonito implements Mensajero {

	@Override
	public void enviarMensaje(String mensaje) {
		System.out.println("####" + mensaje + "####");
	}
	
}
