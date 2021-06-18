package com.ipartek.formacion.uf2406.modelos;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Integer cantidad;
	
	private TreeMap<String, String> errores = new TreeMap<>();

	public Producto(String id, String nombre, String precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}
	
	public Producto(Long id, String nombre, BigDecimal precio, Integer cantidad) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setCantidad(cantidad);
	}

	public Producto(Long id, String nombre, BigDecimal precio) {
		this(id, nombre, precio, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(String id) {
		Long lId = null;
		
		if(id != null && id.trim().length() > 0) {
			lId = Long.parseLong(id);
		}
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			errores.put("nombre", "No se admite un nombre vacío"); 
		}
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "La próxima vez introduce un número");
		}
	}
	
	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio debe ser mayor o igual que 0");
		}
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public TreeMap<String, String> getErrores() {
		return errores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Producto other = (Producto) obj;
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
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}

	public BigDecimal getTotal() {
		return precio.multiply(new BigDecimal(cantidad));
	}
}
