package com.condominio.backend.usecase;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.backend.adapter.PessoaRequestAdapter;
import com.condominio.backend.configuration.exception.UnprocessableEntityException;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.request.PessoaRequest;

@Service
public class PessoaAlteraUseCase {

	private final PessoaRepository pessoaRepository;

	public PessoaAlteraUseCase(final PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Transactional
	public void execute(
			final Long pessoaId, final PessoaRequest request, final UriComponentsBuilder uriBuilder) {

		final Optional<PessoaEntity> pessoa = pessoaRepository.findById(pessoaId);
		if (!pessoa.isPresent()) {
			throw new UnprocessableEntityException("pessoa", "pessoa não cadastrada");
		}

		final PessoaRequestAdapter pessoaAdapter = new PessoaRequestAdapter();
		final PessoaEntity pessoaEntity = pessoaAdapter.convert(pessoa.get(), request);
		pessoaRepository.save(pessoaEntity);
	}

}
