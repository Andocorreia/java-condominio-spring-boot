package com.orquestrador.condominio.adapter;

import java.util.ArrayList;
import java.util.List;

import com.orquestrador.condominio.core.enums.TipoTelefone;
import com.orquestrador.condominio.entity.TelefoneEntity;
import com.orquestrador.condominio.request.CadastroPessoaRequest;

public class TelefoneAdapter implements Adapter< List<TelefoneEntity>, CadastroPessoaRequest>{

	@Override
	public List<TelefoneEntity> convert(final CadastroPessoaRequest request) {

		final List<TelefoneEntity> telefoneEntity = new ArrayList<>();
		request.getTelefones().stream().forEach(telefone -> {
			final TelefoneEntity entity = new TelefoneEntity();
			entity.setNumero(telefone.getNumero());
			entity.setTipo(TipoTelefone.valueOf(telefone.getTipo().toUpperCase()));
			telefoneEntity.add(entity);
		});
		return telefoneEntity;
	}
}
