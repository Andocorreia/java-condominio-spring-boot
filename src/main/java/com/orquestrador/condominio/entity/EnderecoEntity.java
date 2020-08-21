package com.orquestrador.condominio.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.orquestrador.condominio.core.enums.TipoEndereco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="endereco")
@Getter
@Setter
@NoArgsConstructor
public class EnderecoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoEndereco tipo;

	private String rua;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;

	@ManyToOne
	private PessoaEntity pessoaId;

}
