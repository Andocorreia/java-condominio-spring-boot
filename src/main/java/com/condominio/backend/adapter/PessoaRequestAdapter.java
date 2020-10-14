package com.condominio.backend.adapter;

import java.time.LocalDate;

import com.condominio.backend.core.enums.Classificacao;
import com.condominio.backend.core.enums.EstadoCivil;
import com.condominio.backend.core.enums.Sexo;
import com.condominio.backend.core.enums.Situacao;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.request.PessoaRequest;

public class PessoaRequestAdapter implements Adapter<PessoaEntity, PessoaRequest> {

	@Override
	public PessoaEntity convert(final PessoaRequest request) {
		return convert(new PessoaEntity(), request);
	}

	public PessoaEntity convert(final PessoaEntity pessoa, final PessoaRequest request) {
		transformEntityFromRequest(pessoa, request);
		return pessoa;
	}

	private PessoaEntity transformEntityFromRequest(final PessoaEntity pessoaEntity, final PessoaRequest request) {
		final int ano = Integer.parseInt(request.getDataNascimento().substring(0, 4));
		final int mes = Integer.parseInt(request.getDataNascimento().substring(5, 7));
		final int dia = Integer.parseInt(request.getDataNascimento().substring(8, 10));

		pessoaEntity.setNome(request.getNome());
		pessoaEntity.setDataNascimento(LocalDate.of(ano, mes, dia));
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
