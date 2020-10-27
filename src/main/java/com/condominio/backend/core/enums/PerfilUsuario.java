package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerfilUsuario {
	ADMINISTRADOR("ADMINISTRADOR"), PORTARIA("portaria");

	private String descricao;
}
