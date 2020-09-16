package com.orquestrador.condominio.adapter;

import java.util.ArrayList;
import java.util.List;

import com.orquestrador.condominio.core.enums.TipoEndereco;
import com.orquestrador.condominio.entity.EnderecoEntity;
import com.orquestrador.condominio.request.CadastroPessoaRequest;

public class EnderecoRequestAdapter implements Adapter<List<EnderecoEntity>, CadastroPessoaRequest> {

	@Override
	public List<EnderecoEntity> convert(final CadastroPessoaRequest request) {
		final List<EnderecoEntity> enderecoEntity = new ArrayList<>();

		request.getEnderecos().stream().forEach(endereco -> {
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
			enderecoEntity.add(entity);
		});

		return enderecoEntity;
	}

}
