package com.orquestrador.condominio.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orquestrador.condominio.core.enums.Situacao;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.repository.PessoaRepository;

@Service
public class pessoaDeletaUseCase {

	@Autowired
	PessoaRepository pessoaRepository;

	public ResponseEntity<?> execute(final Long pessoaId) {

		final Optional<PessoaEntity> pessoa = pessoaRepository.findById(pessoaId);

		if(pessoa.isPresent()) {

			final PessoaEntity entity = pessoaRepository.getOne(pessoaId);
			entity.setSituacao(Situacao.INATIVO);

			pessoaRepository.save(entity);
			return ResponseEntity.accepted().build();
		}

		return ResponseEntity.notFound().build();
	}

}
