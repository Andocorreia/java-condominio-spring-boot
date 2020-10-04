package com.condominio.backend.adapter;

import com.condominio.backend.core.enums.Classificacao;
import com.condominio.backend.core.enums.EstadoCivil;
import com.condominio.backend.core.enums.Sexo;
import com.condominio.backend.core.enums.Situacao;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.response.CadastroPessoaResponse;

public class PessoaRequestAdapter implements Adapter<PessoaEntity, PessoaRequest> {

	@Override
	public PessoaEntity convert(final PessoaRequest request) {
		final PessoaEntity pessoaEntity = new PessoaEntity();
		transformEntityFromRequest(pessoaEntity, request);
		return pessoaEntity;
	}

	public CadastroPessoaResponse convert(final PessoaEntity pessoaEntity) {
		return new CadastroPessoaResponse(pessoaEntity.getId());
	}

	public PessoaEntity convert(final PessoaEntity pessoa, final PessoaRequest request) {
		transformEntityFromRequest(pessoa, request);
		return pessoa;
	}

	private PessoaEntity transformEntityFromRequest(final PessoaEntity pessoaEntity, final PessoaRequest request) {
		pessoaEntity.setNome(request.getNome());
		pessoaEntity.setDataNascimento(request.getDataNascimento());
		pessoaEntity.setCpf(request.getCpf());
		pessoaEntity.setRg(request.getRg());
		pessoaEntity.setEstadoCivil(EstadoCivil.valueOf(request.getEstadoCivil().toUpperCase()));
		pessoaEntity.setSexo(Sexo.valueOf(request.getSexo()));
		pessoaEntity.setEmail(request.getEmail());
		pessoaEntity.setClassificacao(Classificacao.valueOf(request.getClassificacao().toUpperCase()));
		pessoaEntity.setSituacao(Situacao.ATIVO);

		return pessoaEntity;
	}
}
