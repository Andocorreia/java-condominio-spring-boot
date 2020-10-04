package com.condominio.backend.usecase;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.condominio.backend.adapter.ApartamentoAdapter;
import com.condominio.backend.adapter.EnderecoResponseAdapter;
import com.condominio.backend.adapter.PessoaResponseAdpter;
import com.condominio.backend.adapter.TelefoneResponseAdapter;
import com.condominio.backend.entity.ApartamentoEntity;
import com.condominio.backend.entity.ApartamentoPessoaEntity;
import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.TelefoneEntity;
import com.condominio.backend.repository.ApartamentoPessoaRepository;
import com.condominio.backend.repository.ApartamentoRepository;
import com.condominio.backend.repository.EnderecoRepository;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.repository.TelefoneRepository;
import com.condominio.backend.response.PessoaResponse;

@Service
public class PessoaConsultaUseCase {

	private final ApartamentoPessoaRepository apartamentoPessoaRepository;
	private final ApartamentoRepository apartamentoRepository;
	private final EnderecoRepository enderecoRepository;
	private final PessoaRepository pessoaRepository;
	private final TelefoneRepository telefoneRepository;

	public PessoaConsultaUseCase(
			final ApartamentoPessoaRepository apartamentoPessoaRepository,
			final ApartamentoRepository apartamentoRepository,
			final EnderecoRepository enderecoRepository,
			final PessoaRepository pessoaRepository,
			final TelefoneRepository telefoneRepository
			) {
		this.apartamentoPessoaRepository = apartamentoPessoaRepository;
		this.apartamentoRepository = apartamentoRepository;
		this.enderecoRepository = enderecoRepository;
		this.pessoaRepository = pessoaRepository;
		this.telefoneRepository = telefoneRepository;
	}

	public Collection<PessoaResponse> executa(final Long pessoaId) {
		final Optional<PessoaEntity> pessoaOptional = pessoaRepository.findById(pessoaId);

		if (!pessoaOptional.isPresent()) {
			return Collections.emptyList();
		}
		final PessoaEntity pessoaEntity = pessoaOptional.get();

		final PessoaResponse pessoaResponse = new PessoaResponseAdpter().convert(pessoaEntity);

		final Collection<EnderecoEntity> enderecos = enderecoRepository.findByPessoaId(pessoaEntity).orElse(Collections.emptyList());
		final Collection<TelefoneEntity> telefones = telefoneRepository.findByPessoaId(pessoaEntity).orElse(Collections.emptyList());
		final Collection<ApartamentoPessoaEntity> apartamentoEntity =
				apartamentoPessoaRepository.findByPessoaId(pessoaEntity.getId()).orElse(Collections.emptyList());
		final Collection<ApartamentoEntity> apartamentos =
				apartamentoRepository.findByIdIn(getApartamentosIds(apartamentoEntity)).orElse(Collections.emptyList());

		pessoaResponse.setEnderecos(new EnderecoResponseAdapter().convert(enderecos));
		pessoaResponse.setTelefones(new TelefoneResponseAdapter().convert(telefones));
		pessoaResponse.setApartamentos(new ApartamentoAdapter().convert(apartamentos));

		return Arrays.asList(pessoaResponse);
	}

	public Collection<PessoaResponse> executa() {
		final List<PessoaEntity> pessoaEntity = pessoaRepository.findAll();
		return new PessoaResponseAdpter().convert(pessoaEntity);
	}

	private List<Long> getApartamentosIds(final Collection<ApartamentoPessoaEntity> apartamentoEntity) {
		return apartamentoEntity.stream().map(ApartamentoPessoaEntity::getApartamentoId).collect(Collectors.toList());
	}

}
