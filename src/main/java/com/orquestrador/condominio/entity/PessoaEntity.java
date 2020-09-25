package com.orquestrador.condominio.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orquestrador.condominio.core.enums.Classificacao;
import com.orquestrador.condominio.core.enums.EstadoCivil;
import com.orquestrador.condominio.core.enums.Sexo;
import com.orquestrador.condominio.core.enums.Situacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String rg;

	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	private Sexo sexo;
	private String email;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@Enumerated(EnumType.STRING)
	private Classificacao classificacao;

}
