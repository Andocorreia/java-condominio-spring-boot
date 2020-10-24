package com.condominio.backend.adapter;

import java.util.Collection;
import java.util.stream.Collectors;

import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.response.EnderecoResponse;

public class EnderecoResponseAdapter implements Adapter<Collection<EnderecoResponse>, Collection<EnderecoEntity>> {

	@Override
	public Collection<EnderecoResponse> convert(final Collection<EnderecoEntity> entity) {
		return entity.stream().map(entityEndereco -> {
			final EnderecoResponse endereco = new EnderecoResponse();
			endereco.setId(entityEndereco.getId());
			endereco.setTipo(entityEndereco.getTipo());
			endereco.setRua(entityEndereco.getRua());
			endereco.setNumero(entityEndereco.getNumero());
			endereco.setComplemento(entityEndereco.getComplemento());
			endereco.setCep(entityEndereco.getCep());
			endereco.setBairro(entityEndereco.getBairro());
			endereco.setCidade(entityEndereco.getCidade());
			endereco.setUf(entityEndereco.getUf());
			endereco.setPais(entityEndereco.getPais());
			return endereco;
		}).collect(Collectors.toList());
	}
}
