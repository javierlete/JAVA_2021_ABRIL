package com.ipartek.formacion.poo.entidades;

public class EntidadesException extends RuntimeException {

	private static final long serialVersionUID = 1266614373967418343L;

	public EntidadesException() {
		super();
	}

	public EntidadesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntidadesException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadesException(String message) {
		super(message);
	}

	public EntidadesException(Throwable cause) {
		super(cause);
	}

}
