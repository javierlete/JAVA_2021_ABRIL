package com.ipartek.formacion.factorydal.dal;

public interface FabricaDao {
	DaoPersona obtenerDaoPersona(String url, String usuario, String password);
}
