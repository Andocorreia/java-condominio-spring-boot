package com.condominio.backend.usecase;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.backend.adapter.PessoaRequestAdapter;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.response.CadastroPessoaResponse;

@Service
public class PessoaAlteraUseCase {

	private final PessoaRepository pessoaRepository;

	public PessoaAlteraUseCase(final PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public ResponseEntity<CadastroPessoaResponse> execute(
			final Long pessoaId, final PessoaRequest request, final UriComponentsBuilder uriBuilder) {

		final Optional<PessoaEntity> pessoa = pessoaRepository.findById(pessoaId);
		if (pessoa.isPresent()) {
			final PessoaRequestAdapter pessoaAdapter = new PessoaRequestAdapter();
			final PessoaEntity pessoaEntity = pessoaAdapter.convert(pessoa.get(), request);
			pessoaRepository.save(pessoaEntity);
			return ResponseEntity.accepted().build();
		}

		return ResponseEntity.notFound().build();
	}

}
