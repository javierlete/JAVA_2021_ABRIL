package com.ipartek.formacion.ejemploholamundoarquitectura;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.ipartek.formacion.ejemploholamundoarquitectura.fabricas.Fabrica;
import com.ipartek.formacion.ejemploholamundoarquitectura.mensajeros.Mensajero;
import com.ipartek.formacion.ejemploholamundoarquitectura.proveedores.Proveedor;

public class Main {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Fabrica f = new Fabrica();
		
		Proveedor p = f.getProveedor();
		String mensaje = p.getMensaje();
		
		Mensajero m = f.getMensajero();
		
		m.enviarMensaje(mensaje);
	}

}
