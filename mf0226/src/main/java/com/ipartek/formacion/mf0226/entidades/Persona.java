package com.ipartek.formacion.mf0226.entidades;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Persona {
	private Long id;
	private String nombre;
	private String apellidos;
	private BigDecimal sueldo;
	
	private Ocupacion ocupacion;

	private TreeMap<String, String> errores = new TreeMap<>();
	
	public Persona(String id, String nombre, String apellidos, String sueldo) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setSueldo(sueldo);
	}

	public Persona(Long id, String nombre, String apellidos, BigDecimal sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setId(String id) {
		if(id == null || id.trim().length() == 0) {
			setId((Long)null);
		} else {
			setId(Long.parseLong(id));
		}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			errores.put("nombre", "El nombre es obligatorio");
		}
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		if(apellidos == null || apellidos.trim().length() == 0) {
			errores.put("apellidos", "Los apellidos son obligatorios");
		}
		this.apellidos = apellidos;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		try {
			setSueldo(new BigDecimal(sueldo));
		} catch (Exception e) {
			errores.put("sueldo", "El sueldo debe ser un número que puede tener decimales");
		}
	}
	
	public void setSueldo(BigDecimal sueldo) {
		if(sueldo != null && sueldo.compareTo(BigDecimal.ZERO) <= 0) {
			errores.put("sueldo", "El sueldo debe ser un número positivo");
		}
		this.sueldo = sueldo;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	public TreeMap<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
}
