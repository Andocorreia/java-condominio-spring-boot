package com.condominio.backend.adapter;

import java.util.Collection;
import java.util.stream.Collectors;

import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.response.EnderecoResponse;

public class EnderecoResponseAdapter implements Adapter<Collection<EnderecoResponse>, Collection<EnderecoEntity>> {

	@Override
	public Collection<EnderecoResponse> convert(final Collection<EnderecoEntity> entity) {
		return entity.stream().map(this::getResponseFromEntity).collect(Collectors.toList());
	}

	private EnderecoResponse getResponseFromEntity(final EnderecoEntity entity) {
		final EnderecoResponse endereco = new EnderecoResponse();
		endereco.setId(entity.getId());
		endereco.setTipo(entity.getTipo());
		endereco.setRua(entity.getRua());
		endereco.setNumero(entity.getNumero());
		endereco.setComplemento(entity.getComplemento());
		endereco.setCep(entity.getCep());
		endereco.setBairro(entity.getBairro());
		endereco.setCidade(entity.getCidade());
		endereco.setUf(entity.getUf());
		endereco.setPais(entity.getPais());
		return endereco;
	}

}
