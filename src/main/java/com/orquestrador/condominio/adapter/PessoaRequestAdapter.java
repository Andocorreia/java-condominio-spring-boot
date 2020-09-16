package com.orquestrador.condominio.adapter;

import com.orquestrador.condominio.core.enums.Classificacao;
import com.orquestrador.condominio.core.enums.EstadoCivil;
import com.orquestrador.condominio.core.enums.Sexo;
import com.orquestrador.condominio.core.enums.Situacao;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.request.CadastroPessoaRequest;
import com.orquestrador.condominio.response.CadastroPessoaResponse;

public class PessoaRequestAdapter implements Adapter<PessoaEntity, CadastroPessoaRequest>{

	@Override
	public PessoaEntity convert(final CadastroPessoaRequest request) {

		final PessoaEntity pessoaEntity = new PessoaEntity();

		pessoaEntity.setNome(request.getNome());
		pessoaEntity.setDataNascimento(request.getDataNascimento());
		pessoaEntity.setCpf(request.getCpf());
		pessoaEntity.setRg(request.getRg());
		pessoaEntity.setEstadoCivil(EstadoCivil.valueOf(request.getEstadoCivil().toUpperCase()));
		pessoaEntity.setSexo(Sexo.valueOf(request.getSexo()));
		pessoaEntity.setEmail(request.getEmail());
		pessoaEntity.setClassificacao(Classificacao.valueOf(request.getClassificacao().toUpperCase()));
		pessoaEntity.setSituacao(Situacao.ATIVO);
		//TODO Encriptar a senha
		pessoaEntity.setSenha(request.getSenha());

		return pessoaEntity;
	}

	public CadastroPessoaResponse convert(final PessoaEntity pessoaEntity) {

		return new CadastroPessoaResponse(pessoaEntity.getId());
	}
}
