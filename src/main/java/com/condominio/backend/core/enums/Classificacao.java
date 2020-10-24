package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Classificacao {
	PROPRIETARIO_NAO_MORADOR("PROPRIETARIO_NAO_MORADOR"),
	PROPRIETARIO_MORADOR("PROPRIETARIO_MORADOR"),
	INQUILINO("INQUILINO"),
	VISITANTE("VISITANTE"),
	PRESTADOR_SERVICO("PRESTADOR_SERVICO"),
	FUNCIONARIO_CONDOMINIO("FUNCIONARIO_CONDOMINIO");

	private String descricao;

}
