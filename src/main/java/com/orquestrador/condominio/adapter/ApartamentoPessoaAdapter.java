package com.orquestrador.condominio.adapter;

import java.util.ArrayList;
import java.util.List;

import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;
import com.orquestrador.condominio.request.CadastroPessoaRequest;

public class ApartamentoPessoaAdapter implements Adapter<List<ApartamentoPessoaEntity>, CadastroPessoaRequest>{

	@Override
	public List<ApartamentoPessoaEntity> convert(final CadastroPessoaRequest request) {

		final List<ApartamentoPessoaEntity> apartamentoPessoaEntity = new ArrayList<>();

		request.getApartamentos().stream().forEach(apartamento -> {
			final ApartamentoPessoaEntity entity = new ApartamentoPessoaEntity();
			entity.setApartamentoId(apartamento);
			apartamentoPessoaEntity.add(entity);
		});
		return apartamentoPessoaEntity;
	}
}
