package com.condominio.backend.adapter;

import java.util.Collection;
import java.util.stream.Collectors;

import com.condominio.backend.entity.ApartamentoEntity;
import com.condominio.backend.response.ApartamentoResponse;

public class ApartamentoAdapter implements Adapter<Collection<ApartamentoResponse>, Collection<ApartamentoEntity>> {

	@Override
	public Collection<ApartamentoResponse> convert(final Collection<ApartamentoEntity> entity) {

		return entity.stream()
				.map(apartamento -> new ApartamentoResponse(apartamento.getBloco(), apartamento.getApartamento()))
				.sorted((a1, a2) -> {
					if (a1.getBloco().compareTo(a2.getBloco()) == 0) {
						return a1.getApartamento().compareTo(a2.getApartamento());
					}
					return a1.getBloco().compareTo(a2.getBloco());
				}).collect(Collectors.toList());
	}

}
