package com.orquestrador.condominio.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
	RESIDENCIAL("RESIDENCIAL"), COMERCIAL("COMERCIAL"), CELULAR("CELULAR"), OUTROS("OUTROS");
	private String descricao;
}
