package com.condominio.backend.configuration.exception;

import com.condominio.backend.configuration.exception.model.ErrorEntity;

import lombok.Getter;

@Getter
public class UnprocessableEntityException extends RuntimeException {

	private final ErrorEntity error;

	public UnprocessableEntityException(final String entity, final String message) {
		super();
		this.error = new ErrorEntity(entity, message);
	}


}
