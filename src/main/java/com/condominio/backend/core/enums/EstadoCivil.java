package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoCivil {
	CASADO("CASADO"), SOLTEIRO("SOLTEIRO"), VIUVO("VIUVO"), DIVORCIADO("DIVORCIADO");

	private String descricao;
}
