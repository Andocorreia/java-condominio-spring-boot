package com.orquestrador.condominio.usecase;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orquestrador.condominio.adapter.EnderecoResponseAdapter;
import com.orquestrador.condominio.adapter.PessoaResponseAdpter;
import com.orquestrador.condominio.adapter.TelefoneResponseAdapter;
import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;
import com.orquestrador.condominio.entity.EnderecoEntity;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.entity.TelefoneEntity;
import com.orquestrador.condominio.repository.ApartamentoPessoaRepository;
import com.orquestrador.condominio.repository.ApartamentoRepository;
import com.orquestrador.condominio.repository.EnderecoRepository;
import com.orquestrador.condominio.repository.PessoaRepository;
import com.orquestrador.condominio.repository.TelefoneRepository;
import com.orquestrador.condominio.response.PessoaResponse;

@Service
public class PessoaConsultaUseCase {

	@Autowired
	ApartamentoPessoaRepository apartamentoPessoaRepository;

	@Autowired
	ApartamentoRepository apartamentoRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	TelefoneRepository telefoneRepository;

	public Collection<PessoaResponse> executa(final Long pessoaId) {
		final Optional<PessoaEntity> pessoaOptional = pessoaRepository.findById(pessoaId);

		if(!pessoaOptional.isPresent()) {

			return Collections.emptyList();
		}

		final PessoaEntity pessoaEntity = pessoaOptional.get();

		final PessoaResponse pessoaResponse = new PessoaResponseAdpter().convert(pessoaEntity);

		final Collection<EnderecoEntity> enderecos =
				enderecoRepository.findByPessoaId(pessoaEntity).orElse(Collections.emptyList());

		final Collection<TelefoneEntity> telefones =
				telefoneRepository.findByPessoaId(pessoaEntity).orElse(Collections.emptyList());

		final Collection<ApartamentoPessoaEntity> apartamentos =
				apartamentoPessoaRepository.findByPessoaId(pessoaId).orElse(Collections.emptyList());

		pessoaResponse.setEnderecos(new EnderecoResponseAdapter().convert(enderecos));
		pessoaResponse.setTelefones(new TelefoneResponseAdapter().convert(telefones));

		return Arrays.asList(pessoaResponse);
	}

	public Collection<PessoaResponse> executa() {
		final List<PessoaEntity> pessoaEntity = pessoaRepository.findAll();
		return new PessoaResponseAdpter().convert(pessoaEntity);
	}

}
