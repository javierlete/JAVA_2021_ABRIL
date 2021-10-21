package com.ipartek.formacion.factorydal.dal;

import java.util.TreeMap;

public class FabricaDaoImpl implements FabricaDao {

	private TreeMap<String, DaoPersona> daosPersona = new TreeMap<>();

	@Override
	public DaoPersona obtenerDaoPersona(String url, String usuario, String password) {
		String clave = url + usuario + password;

		if (daosPersona.containsKey(clave)) {
			return daosPersona.get(clave);
		}

		daosPersona.put(clave, new DaoMySqlPersona(url, usuario, password));

		return daosPersona.get(clave);
	}

}
