package com.orquestrador.condominio.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerfilUsuario {
	ADMINISTRADOR("ADMINISTRADOR");

	private String descricao;
}
