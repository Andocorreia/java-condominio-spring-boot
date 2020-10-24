package com.condominio.backend.adapter;

import java.util.Collection;
import java.util.stream.Collectors;

import com.condominio.backend.entity.TelefoneEntity;
import com.condominio.backend.response.TelefoneResponse;

public class TelefoneResponseAdapter implements Adapter<Collection<TelefoneResponse>, Collection<TelefoneEntity>> {

	@Override
	public Collection<TelefoneResponse> convert(final Collection<TelefoneEntity> entity) {
		return entity.stream().map(telefoneEntity -> {
			final TelefoneResponse telefone = new TelefoneResponse();
			telefone.setId(telefoneEntity.getId());
			telefone.setNumero(telefoneEntity.getNumero());
			telefone.setComplemento(telefoneEntity.getComplemento());
			telefone.setTipo(telefoneEntity.getTipo());
			return telefone;
		}).collect(Collectors.toList());
	}
}
