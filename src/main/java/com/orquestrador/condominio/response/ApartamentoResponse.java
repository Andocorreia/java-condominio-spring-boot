package com.orquestrador.condominio.response;

import com.orquestrador.condominio.core.enums.Bloco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartamentoResponse {

	private Bloco bloco;
	private Integer apartamento;
}
