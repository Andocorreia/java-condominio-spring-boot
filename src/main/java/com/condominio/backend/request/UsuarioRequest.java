package com.condominio.backend.request;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

	@JsonProperty
	private Long pessoaId;
	@NotEmpty
	@JsonProperty
	private String usuario;
	@NotEmpty
	@JsonProperty
	private String senha;
	@JsonProperty
	private Collection<String> perfis = new ArrayList<>();
}
