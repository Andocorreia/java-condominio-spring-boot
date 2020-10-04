package com.condominio.backend.configuration.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorValidation {
	private final String campo;
	private final String erro;
}
