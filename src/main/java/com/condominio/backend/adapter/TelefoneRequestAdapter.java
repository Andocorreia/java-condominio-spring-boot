package com.condominio.backend.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.condominio.backend.core.enums.TipoTelefone;
import com.condominio.backend.entity.TelefoneEntity;
import com.condominio.backend.request.PessoaRequest;

public class TelefoneRequestAdapter implements Adapter<List<TelefoneEntity>, PessoaRequest> {

	@Override
	public List<TelefoneEntity> convert(final PessoaRequest request) {
		return request.getTelefones().stream().map(telefone -> {
			final TelefoneEntity entity = new TelefoneEntity();
			entity.setNumero(telefone.getNumero());
			entity.setTipo(TipoTelefone.valueOf(telefone.getTipo().toUpperCase()));
			entity.setComplemento(telefone.getComplemento());
			return entity;
		}).collect(Collectors.toList());
	}
}
