package com.condominio.backend.response;

import com.condominio.backend.core.enums.Bloco;

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
