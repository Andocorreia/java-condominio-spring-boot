package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Classificacao {
	PROPRIETARIO_NAO_MORADOR("PROPRIETARIO_NAO_MORADOR"), MORADOR("MORADOR"), VISITANTE("VISITANTE"), PRESTADOR("PRESTADOR"), FUNCIONARIO("FUNCIONARIO");
	private String descricao;

}
