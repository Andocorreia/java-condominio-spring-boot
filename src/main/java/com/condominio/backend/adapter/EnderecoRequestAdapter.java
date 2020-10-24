package com.condominio.backend.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.condominio.backend.core.enums.TipoEndereco;
import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.request.PessoaRequest;

public class EnderecoRequestAdapter implements Adapter<List<EnderecoEntity>, PessoaRequest> {

	@Override
	public List<EnderecoEntity> convert(final PessoaRequest request) {
		return request.getEnderecos().stream().map(endereco -> {
			final EnderecoEntity entity = new EnderecoEntity();
			entity.setTipo(TipoEndereco.valueOf(endereco.getTipo().toUpperCase()));
			entity.setRua(endereco.getRua());
			entity.setNumero(endereco.getNumero());
			entity.setComplemento(endereco.getComplemento());
			entity.setCep(endereco.getCep());
			entity.setBairro(endereco.getBairro());
			entity.setCidade(endereco.getCidade());
			entity.setUf(endereco.getUf());
			entity.setPais(endereco.getPais());
			return entity;
		}).collect(Collectors.toList());

	}

}
