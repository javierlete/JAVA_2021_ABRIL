package com.ipartek.formacion.factorydal.controladores;

import com.ipartek.formacion.factorydal.dal.DaoPersona;
import com.ipartek.formacion.factorydal.dal.FabricaDaoImpl;

public class Globales {
	private Globales() {}
	
	public static final DaoPersona daoPersonas = new FabricaDaoImpl().obtenerDaoPersona(
			"jdbc:mysql://localhost:3306/hibernate", "root", "admin");
}
