package com.condominio.backend.configuration.exception;

import com.condominio.backend.configuration.exception.model.ErrorValidation;

import lombok.Getter;

@Getter
public class ArgumentNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorValidation error;

	public ArgumentNotValidException(final String field, final String message) {
		super();
		this.error = new ErrorValidation(field, message);
	}


}
