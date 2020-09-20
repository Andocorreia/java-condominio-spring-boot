package com.orquestrador.condominio.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class CommonPessoaRequest {

	@NotNull
	@NotEmpty
	@JsonProperty
	private String nome;

	//@Pattern(regexp = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$", message = "{validation.dateDDMMYYYY}")
	@JsonProperty
	private LocalDate dataNascimento;

	@NotNull
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

	@NotNull
	@NotEmpty
	@JsonProperty
	private String classificacao;

	@NotNull
	@NotEmpty
	@JsonProperty
	private final List<Long> apartamentos = new ArrayList<>();

	@JsonProperty
	private String senha;

	@Getter
	public static class Endereco {
		@NotNull
		@NotEmpty
		@JsonProperty
		private String tipo;

		@NotNull
		@NotEmpty
		@JsonProperty
		private String rua;

		@NotNull
		@NotEmpty
		@Pattern(regexp = "\\d+", message = "{validation.number}")
		@JsonProperty
		private String numero;

		@JsonProperty
		private String complemento;

		@NotNull
		@NotEmpty
		@Pattern(regexp = "\\d+", message = "{validation.number}")
		@JsonProperty
		private String cep;

		@NotNull
		@NotEmpty
		@JsonProperty
		private String bairro;

		@NotNull
		@NotEmpty
		@JsonProperty
		private String cidade;

		@NotNull
		@NotEmpty
		@JsonProperty
		private String uf;

		@NotNull
		@NotEmpty
		@JsonProperty
		private String pais;
	}

	@Getter
	public static class Telefone {

		@NotNull
		@NotEmpty
		@Pattern(regexp = "\\d+", message = "{validation.number}")
		@JsonProperty
		private String numero;

		@JsonProperty
		private String complemento;

		@NotNull
		@NotEmpty
		@JsonProperty
		private String tipo;

	}
}
