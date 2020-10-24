package com.condominio.backend.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.condominio.backend.entity.ApartamentoPessoaEntity;
import com.condominio.backend.request.PessoaRequest;

public class ApartamentoPessoaRequestAdapter implements Adapter<List<ApartamentoPessoaEntity>, PessoaRequest> {

	@Override
	public List<ApartamentoPessoaEntity> convert(final PessoaRequest request) {

		return request.getApartamentos().stream().map(apartamento -> {
			final ApartamentoPessoaEntity entity = new ApartamentoPessoaEntity();
			entity.setApartamentoId(apartamento);
			return entity;
		}).collect(Collectors.toList());
	}
}
