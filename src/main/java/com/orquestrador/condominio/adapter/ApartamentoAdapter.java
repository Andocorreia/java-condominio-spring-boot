package com.orquestrador.condominio.adapter;

import java.util.Collection;
import java.util.stream.Collectors;

import com.orquestrador.condominio.entity.ApartamentoEntity;
import com.orquestrador.condominio.response.ApartamentoResponse;

public class ApartamentoAdapter implements Adapter<Collection<ApartamentoResponse>, Collection<ApartamentoEntity>> {

	@Override
	public Collection<ApartamentoResponse> convert(final Collection<ApartamentoEntity> entity) {

		return entity.stream().map(apartamento -> new ApartamentoResponse(apartamento.getBloco(), apartamento.getApartamento())).collect(Collectors.toList());
	}

}
