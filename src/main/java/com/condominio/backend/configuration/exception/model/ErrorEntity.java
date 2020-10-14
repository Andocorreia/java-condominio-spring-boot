package com.condominio.backend.configuration.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorEntity {
	@JsonProperty
	private final String entity;
	@JsonProperty
	private final String message;
}
