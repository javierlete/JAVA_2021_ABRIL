package com.ipartek.formacion.seguridadservlets.daos;

public class DaosException extends RuntimeException {

	private static final long serialVersionUID = -3465940749775280826L;

	public DaosException() {
		super();
	}

	public DaosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaosException(String message) {
		super(message);
	}

	public DaosException(Throwable cause) {
		super(cause);
	}
	
}
