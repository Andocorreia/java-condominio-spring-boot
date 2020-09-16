package com.orquestrador.condominio.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Situacao {

	ATIVO("ATIVO"), INATIVO("INATIVO");

	private String descricao;
}
