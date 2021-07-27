package com.ipartek.formacion.ejemploholamundoarquitectura.proveedores;

import java.util.Scanner;

public class ProveedorConsola implements Proveedor {

	@SuppressWarnings("resource")
	@Override
	public String getMensaje() {
		return new Scanner(System.in).nextLine();
	}

}
