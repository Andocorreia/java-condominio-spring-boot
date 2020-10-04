package com.condominio.backend.adapter;

import java.util.ArrayList;
import java.util.List;

import com.condominio.backend.entity.ApartamentoPessoaEntity;
import com.condominio.backend.request.PessoaRequest;

public class ApartamentoPessoaRequestAdapter implements Adapter<List<ApartamentoPessoaEntity>, PessoaRequest> {

	@Override
	public List<ApartamentoPessoaEntity> convert(final PessoaRequest request) {

		final List<ApartamentoPessoaEntity> apartamentoPessoaEntity = new ArrayList<>();

		request.getApartamentos().stream().forEach(apartamento -> {
			final ApartamentoPessoaEntity entity = new ApartamentoPessoaEntity();
			entity.setApartamentoId(apartamento);
			apartamentoPessoaEntity.add(entity);
		});
		return apartamentoPessoaEntity;
	}
}
