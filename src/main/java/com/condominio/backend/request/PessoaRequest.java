package com.condominio.backend.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PessoaRequest {

	@NotEmpty
	@JsonProperty
	private String nome;

	//@Pattern(regexp = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$", message = "{validation.dateDDMMYYYY}")
	@JsonProperty
	private LocalDate dataNascimento;

	@NotEmpty
	@Pattern(regexp = "\\d+", message = "{validation.number}")
	@JsonProperty
	private String cpf;

	@Pattern(regexp = "\\d+", message = "{validation.number}")
	@JsonProperty
	private String rg;

	@JsonProperty
	private String estadoCivil;

	@JsonProperty
	private String sexo;

	//@Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", message = "{validation.number}")
	@JsonProperty
	private String email;

	@JsonProperty
	private final List<Endereco> enderecos = new ArrayList<>();

	@JsonProperty
	private final List<Telefone> telefones = new ArrayList<>();

	@NotEmpty
	@JsonProperty
	private String classificacao;

	@NotEmpty
	@JsonProperty
	private final List<Long> apartamentos = new ArrayList<>();

	@Getter
	public static class Endereco {
		@NotEmpty
		@JsonProperty
		private String tipo;

		@NotEmpty
		@JsonProperty
		private String rua;

		@NotEmpty
		@Pattern(regexp = "\\d+", message = "{validation.number}")
		@JsonProperty
		private String numero;

		@JsonProperty
		private String complemento;

		@NotEmpty
		@Pattern(regexp = "\\d+", message = "{validation.number}")
		@JsonProperty
		private String cep;

		@NotEmpty
		@JsonProperty
		private String bairro;

		@NotEmpty
		@JsonProperty
		private String cidade;

		@NotEmpty
		@JsonProperty
		private String uf;

		@NotEmpty
		@JsonProperty
		private String pais;
	}

	@Getter
	public static class Telefone {

		@NotEmpty
		@Pattern(regexp = "\\d+", message = "{validation.number}")
		@JsonProperty
		private String numero;

		@JsonProperty
		private String complemento;

		@NotEmpty
		@JsonProperty
		private String tipo;

	}
}
