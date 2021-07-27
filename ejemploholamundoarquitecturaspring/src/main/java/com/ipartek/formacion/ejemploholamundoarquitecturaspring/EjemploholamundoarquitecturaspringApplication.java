package com.ipartek.formacion.ejemploholamundoarquitecturaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.ejemploholamundoarquitecturaspring.mensajeros.Mensajero;
import com.ipartek.formacion.ejemploholamundoarquitecturaspring.proveedores.Proveedor;

@SpringBootApplication
public class EjemploholamundoarquitecturaspringApplication implements CommandLineRunner {

	@Autowired
	private Proveedor proveedor;
	
	@Autowired
	private Mensajero mensajero;
	
	public static void main(String[] args) {
		SpringApplication.run(EjemploholamundoarquitecturaspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mensajero.enviarMensaje(proveedor.getMensaje());
	}

}
