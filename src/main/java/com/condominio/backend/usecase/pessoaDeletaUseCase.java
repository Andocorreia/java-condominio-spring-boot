package com.condominio.backend.usecase;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.condominio.backend.configuration.exception.UnprocessableEntityException;
import com.condominio.backend.core.enums.Situacao;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.repository.PessoaRepository;

@Service
public class pessoaDeletaUseCase {

	private final PessoaRepository pessoaRepository;

	public pessoaDeletaUseCase(final PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Transactional
	public void execute(final Long pessoaId) {

		final Optional<PessoaEntity> pessoa = pessoaRepository.findById(pessoaId);

		if (!pessoa.isPresent()) {
			throw new UnprocessableEntityException("pessoa", "pessoa não cadastrada");
		}

		final PessoaEntity entity = pessoaRepository.getOne(pessoaId);
		entity.setSituacao(Situacao.INATIVO);

		pessoaRepository.save(entity);

	}

}
