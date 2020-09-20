package com.orquestrador.condominio.adapter;

import java.util.Collection;

import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;
import com.orquestrador.condominio.response.ApartamentoResponse;

public class ApartamentoPessoaResponseAdapter implements Adapter<Collection<ApartamentoResponse>, Collection<ApartamentoPessoaEntity>> {

	@Override
	public Collection<ApartamentoResponse> convert(final Collection<ApartamentoPessoaEntity> request) {
		return null;
	}

}
