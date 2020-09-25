package com.orquestrador.condominio.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {

	@NotNull
	@NotEmpty
	@JsonProperty
	private String usuario;

	@NotNull
	@NotEmpty
	@JsonProperty
	private String senha;

}
