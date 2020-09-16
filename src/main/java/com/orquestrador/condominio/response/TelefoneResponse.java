package com.orquestrador.condominio.response;

import com.orquestrador.condominio.core.enums.TipoTelefone;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelefoneResponse {

	private Long id;
	private String numero;
	private String complemento;
	private TipoTelefone tipo;
}
