package com.condominio.backend.request;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {

	@NotEmpty
	@JsonProperty
	private String usuario;

	@NotEmpty
	@JsonProperty
	private String senha;

}
