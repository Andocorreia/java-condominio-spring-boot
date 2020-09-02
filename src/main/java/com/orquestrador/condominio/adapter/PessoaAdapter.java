package com.orquestrador.condominio.adapter;

import com.orquestrador.condominio.core.enums.Classificacao;
import com.orquestrador.condominio.core.enums.EstadoCivil;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.request.CadastroPessoaRequest;

public class PessoaAdapter implements Adapter<PessoaEntity, CadastroPessoaRequest>{

	@Override
	public PessoaEntity convert(final CadastroPessoaRequest request) {

		final PessoaEntity pessoaEntity = new PessoaEntity();

		pessoaEntity.setNome(request.getNome());
		pessoaEntity.setDataNascimento(request.getDataNascimento());
		pessoaEntity.setCpf(request.getCpf());
		pessoaEntity.setRg(request.getRg());
		pessoaEntity.setEstadoCivil(EstadoCivil.valueOf(request.getEstadoCivil().toUpperCase()));
		pessoaEntity.setEmail(request.getEmail());
		pessoaEntity.setClassificacao(Classificacao.valueOf(request.getClassificacao().toUpperCase()));
		//TODO Encriptar a senha
		pessoaEntity.setSenha(request.getSenha());

		return pessoaEntity;
	}
}
