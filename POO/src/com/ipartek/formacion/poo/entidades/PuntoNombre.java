package com.ipartek.formacion.poo.entidades;

public class PuntoNombre extends Punto {
	private String nombre;

	public PuntoNombre(int x, int y, String nombre) {
		super(x, y);
		this.setNombre(nombre);
	}

	public PuntoNombre(int xy, String nombre) {
		this(xy, xy, nombre);
	}

	public PuntoNombre(String nombre) {
		this(0, 0, nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuntoNombre other = (PuntoNombre) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PuntoNombre [nombre=" + nombre + ", x=" + getX() + ", y=" + getY() + "]";
	}

}
