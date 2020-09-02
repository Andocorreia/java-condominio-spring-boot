package com.orquestrador.condominio.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class CadastroPessoaRequest {

	@JsonProperty
	private String nome;

	@JsonProperty
	private LocalDate dataNascimento;

	@JsonProperty
	private String cpf;

	@JsonProperty
	private String rg;

	@JsonProperty
	private String estadoCivil;

	@JsonProperty
	private String email;

	@JsonProperty
	private final List<Endereco> enderecos = new ArrayList<>();

	@JsonProperty
	private final List<Telefone> telefones = new ArrayList<>();

	@JsonProperty
	private String classificacao;

	@JsonProperty
	private final List<Long> apartamentos = new ArrayList<>();

	@JsonProperty
	private String senha;

	@Getter
	public static class Endereco {
		@JsonProperty
		private String tipo;

		@JsonProperty
		private String rua;

		@JsonProperty
		private String numero;

		@JsonProperty
		private String complemento;

		@JsonProperty
		private String cep;

		@JsonProperty
		private String bairro;

		@JsonProperty
		private String cidade;

		@JsonProperty
		private String uf;

		@JsonProperty
		private String pais;
	}

	@Getter
	public static class Telefone {

		@JsonProperty
		private String numero;

		@JsonProperty
		private String tipo;

	}
}
