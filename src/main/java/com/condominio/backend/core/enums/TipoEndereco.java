package com.condominio.backend.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoEndereco {

	RESIDENCIAL("RESIDENCIAL"), CORRESPONDENCIA("CORRESPONDENCIA"),	COMERCIAL("COMERCIAL");
	private String descricao;
}
