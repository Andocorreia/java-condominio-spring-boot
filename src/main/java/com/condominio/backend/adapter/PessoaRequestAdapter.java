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
		pessoa.setNome(request.getNome());
		pessoa.setDataNascimento(convertStringToData(request.getDataNascimento()));
		pessoa.setCpf(request.getCpf());
		pessoa.setRg(request.getRg());
		pessoa.setEstadoCivil(EstadoCivil.valueOf(request.getEstadoCivil().toUpperCase()));
		pessoa.setSexo(Sexo.valueOf(request.getSexo()));
		pessoa.setEmail(request.getEmail());
		pessoa.setClassificacao(Classificacao.valueOf(request.getClassificacao().toUpperCase()));
		pessoa.setSituacao(Situacao.ATIVO);

		return pessoa;
	}

	private LocalDate convertStringToData(final String dataNascimento) {
		final int ano = Integer.parseInt(dataNascimento.substring(0, 4));
		final int mes = Integer.parseInt(dataNascimento.substring(5, 7));
		final int dia = Integer.parseInt(dataNascimento.substring(8, 10));
		return LocalDate.of(ano, mes, dia);
	}
}
