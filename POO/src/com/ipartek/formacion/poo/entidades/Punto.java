package com.ipartek.formacion.poo.entidades;

public class Punto {
	// 6. Constantes con valores por defecto para constructores
	private static final int X_POR_DEFECTO = 0;
	private static final int Y_POR_DEFECTO = 0;
	private static final int X_MAXIMA = 100;
	private static final int X_MINIMA = -100;
	
	// 1. Variables de instancia
	private int x, y;

	// 2. Constructor completo
	public Punto(int x, int y) {
		// 4. Llamar a setters
		setX(x);
		setY(y);
	}

	// 6. Constructores extra
	public Punto(int xy) {
		this(xy, xy);
	}
	
	public Punto() {
		this(X_POR_DEFECTO, Y_POR_DEFECTO);
	}
	
	// 4. Getters y setters
	public int getX() {
		return x;
	}

	
	public void setX(int x) {
		// 7. Validaciones
		if(x < X_MINIMA || x > X_MAXIMA) {
			throw new EntidadesException("No se admiten x fuera de límites");
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// 5. Hashcode e equals (5 -> clase bastante completa)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	// 3. toString (3 -> crea versión básica de una clase)
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
}
