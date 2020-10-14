package com.condominio.backend.configuration.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorValidation {
	@JsonProperty
	private final String field;
	@JsonProperty
	private final String message;
}
