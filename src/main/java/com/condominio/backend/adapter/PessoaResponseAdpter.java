package com.condominio.backend.adapter;

import java.util.Collection;
import java.util.stream.Collectors;

import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.response.PessoaResponse;

public class PessoaResponseAdpter implements Adapter<Collection<PessoaResponse>, Collection<PessoaEntity>> {
	@Override
	public Collection<PessoaResponse> convert(final Collection<PessoaEntity> entity) {
		return entity.stream().map(this::getReponseFromEntity).collect(Collectors.toList());
	}

	public PessoaResponse convert(final PessoaEntity pessoa) {
		return getReponseFromEntity(pessoa);
	}

	private PessoaResponse getReponseFromEntity(final PessoaEntity pessoa) {
		final PessoaResponse pessoaResponse = new PessoaResponse();
		pessoaResponse.setId(pessoa.getId());
		pessoaResponse.setNome(pessoa.getNome());
		pessoaResponse.setDataNascimento(pessoa.getDataNascimento());
		pessoaResponse.setCpf(pessoa.getCpf());
		pessoaResponse.setRg(pessoa.getRg());
		pessoaResponse.setEstadoCivil(pessoa.getEstadoCivil());
		pessoaResponse.setSexo(pessoa.getSexo());
		pessoaResponse.setEmail(pessoa.getEmail());
		pessoaResponse.setClassificacao(pessoa.getClassificacao());
		pessoaResponse.setSituacao(pessoa.getSituacao());
		return pessoaResponse;
	}
}
