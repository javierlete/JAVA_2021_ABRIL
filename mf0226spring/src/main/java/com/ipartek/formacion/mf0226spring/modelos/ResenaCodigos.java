package com.ipartek.formacion.mf0226spring.modelos;

public class ResenaCodigos {
	private Integer alumnoCodigo;
	private Integer cursoCodigo;
	private String texto;
	
	public ResenaCodigos(Integer alumnoCodigo, Integer cursoCodigo, String texto) {
		super();
		this.alumnoCodigo = alumnoCodigo;
		this.cursoCodigo = cursoCodigo;
		this.texto = texto;
	}

	public Integer getAlumnoCodigo() {
		return alumnoCodigo;
	}

	public void setAlumnoCodigo(Integer alumnoCodigo) {
		this.alumnoCodigo = alumnoCodigo;
	}

	public Integer getCursoCodigo() {
		return cursoCodigo;
	}

	public void setCursoCodigo(Integer cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnoCodigo == null) ? 0 : alumnoCodigo.hashCode());
		result = prime * result + ((cursoCodigo == null) ? 0 : cursoCodigo.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		ResenaCodigos other = (ResenaCodigos) obj;
		if (alumnoCodigo == null) {
			if (other.alumnoCodigo != null)
				return false;
		} else if (!alumnoCodigo.equals(other.alumnoCodigo))
			return false;
		if (cursoCodigo == null) {
			if (other.cursoCodigo != null)
				return false;
		} else if (!cursoCodigo.equals(other.cursoCodigo))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResenaCodigos [alumnoCodigo=" + alumnoCodigo + ", cursoCodigo=" + cursoCodigo + ", texto=" + texto
				+ "]";
	}
	
	
}
