package com.ipartek.formacion.ejemploholamundoarquitectura.fabricas;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.ipartek.formacion.ejemploholamundoarquitectura.mensajeros.Mensajero;
import com.ipartek.formacion.ejemploholamundoarquitectura.proveedores.Proveedor;

public class Fabrica {
	private Proveedor proveedor;
	private Mensajero mensajero;
	
	public Fabrica() throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Properties prop = new Properties();
		prop.load(this.getClass().getClassLoader().getResourceAsStream("fabrica.properties"));
		
		String p = prop.getProperty("proveedor");
		String m = prop.getProperty("mensajero");
		
		mensajero = (Mensajero) Class.forName(m).getDeclaredConstructor().newInstance();
		proveedor = (Proveedor) Class.forName(p).getDeclaredConstructor().newInstance();
	}
	
	public Mensajero getMensajero() {
		return mensajero;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
}
