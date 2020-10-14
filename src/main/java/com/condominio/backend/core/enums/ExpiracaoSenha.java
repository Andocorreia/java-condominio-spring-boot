package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpiracaoSenha {
	DIAS(30);
	private Integer dias;
}
