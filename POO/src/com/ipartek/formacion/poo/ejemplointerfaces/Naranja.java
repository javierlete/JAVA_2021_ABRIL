package com.ipartek.formacion.poo.ejemplointerfaces;

public class Naranja extends Fruto implements Rodable, Comestible {

	private boolean limpia = true;
	
	@Override
	public void comer() {
		if(limpia) {
			System.out.println("Ñam que rica");
		} else {
			System.out.println("Puaj que asco");
		}
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		limpia = false;
	}

}
