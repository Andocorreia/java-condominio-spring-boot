package com.orquestrador.condominio.adapter;

import java.util.ArrayList;
import java.util.List;

import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;
import com.orquestrador.condominio.request.CommonPessoaRequest;

public class ApartamentoPessoaRequestAdapter implements Adapter<List<ApartamentoPessoaEntity>, CommonPessoaRequest> {

	@Override
	public List<ApartamentoPessoaEntity> convert(final CommonPessoaRequest request) {

		final List<ApartamentoPessoaEntity> apartamentoPessoaEntity = new ArrayList<>();

		request.getApartamentos().stream().forEach(apartamento -> {
			final ApartamentoPessoaEntity entity = new ApartamentoPessoaEntity();
			entity.setApartamentoId(apartamento);
			apartamentoPessoaEntity.add(entity);
		});
		return apartamentoPessoaEntity;
	}
}
