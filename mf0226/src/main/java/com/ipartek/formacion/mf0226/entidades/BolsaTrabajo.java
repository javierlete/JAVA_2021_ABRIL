package com.ipartek.formacion.mf0226.entidades;

import java.math.BigDecimal;
import java.util.TreeMap;

public class BolsaTrabajo {
	private TreeMap<Long, Persona> personas = new TreeMap<>();
	private String empresa;
	
	public BolsaTrabajo(String empresa) {
		this.empresa = empresa;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public Iterable<Persona> getPersonas() {
		return personas.values();
	}
	
	public BigDecimal getTotalSueldo() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(Persona persona: personas.values()) {
			if(persona.getSueldo() != null) {
				total = total.add(persona.getSueldo());
			}
		}
		
		return total;
	}
	
	public void agregarPersona(Persona persona) {
		personas.put(persona.getId(), persona);
	}
	
	public void eliminarPersona(Long id) {
		personas.remove(id);
	}
	
}
