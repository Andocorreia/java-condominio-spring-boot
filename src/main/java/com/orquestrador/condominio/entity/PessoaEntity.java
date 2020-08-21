package com.orquestrador.condominio.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.orquestrador.condominio.core.enums.Classificacao;
import com.orquestrador.condominio.core.enums.EstadoCivil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pessoa")
@Getter
@Setter
@NoArgsConstructor
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

	private String email;

	@OneToMany(mappedBy = "pessoaId")
	private List<EnderecoEntity> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "pessoaId")
	private List<TelefoneEntity> telefones = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	private Classificacao classificacao;

	@OneToMany(mappedBy = "pessoaId")
	private List<ApartamentoPessoaEntity> apartamentos = new ArrayList<>();

	private String senha;

}
