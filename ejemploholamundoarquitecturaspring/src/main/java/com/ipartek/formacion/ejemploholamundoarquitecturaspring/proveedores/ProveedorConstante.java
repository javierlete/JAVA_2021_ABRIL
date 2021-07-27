package com.ipartek.formacion.ejemploholamundoarquitecturaspring.proveedores;

import org.springframework.stereotype.Component;

@Component
public class ProveedorConstante implements Proveedor {

	@Override
	public String getMensaje() {
		return "Hola desde ProveedorConstante";
	}

}
