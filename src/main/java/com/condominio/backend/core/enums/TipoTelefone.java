package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
	RESIDENCIAL("RESIDENCIAL"), COMERCIAL("COMERCIAL"), CELULAR("CELULAR"), OUTROS("OUTROS"), RECADO("RECADO");
	private String descricao;
}
