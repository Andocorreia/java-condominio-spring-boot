package com.condominio.backend.usecase;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.condominio.backend.core.enums.Situacao;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.repository.PessoaRepository;

@Service
public class pessoaDeletaUseCase {

	private final PessoaRepository pessoaRepository;

	public pessoaDeletaUseCase(final PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public ResponseEntity<?> execute(final Long pessoaId) {

		final Optional<PessoaEntity> pessoa = pessoaRepository.findById(pessoaId);

		if (pessoa.isPresent()) {

			final PessoaEntity entity = pessoaRepository.getOne(pessoaId);
			entity.setSituacao(Situacao.INATIVO);

			pessoaRepository.save(entity);
			return ResponseEntity.accepted().build();
		}

		return ResponseEntity.notFound().build();
	}

}
