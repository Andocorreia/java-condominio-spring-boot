package com.orquestrador.condominio.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.orquestrador.condominio.adapter.PessoaRequestAdapter;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.repository.PessoaRepository;
import com.orquestrador.condominio.request.CommonPessoaRequest;
import com.orquestrador.condominio.response.CadastroPessoaResponse;

@Service
public class PessoaAlteraUseCase {

	@Autowired
	PessoaRepository pessoaRepository;

	public ResponseEntity<CadastroPessoaResponse> execute(
			final Long pessoaId, final CommonPessoaRequest request, final UriComponentsBuilder uriBuilder) {

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
