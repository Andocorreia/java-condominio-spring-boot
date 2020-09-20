package com.orquestrador.condominio.response;

import com.orquestrador.condominio.core.enums.Bloco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApartamentoResponse {

	private Bloco bloco;
	private Integer apartamento;
}
