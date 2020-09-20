package com.orquestrador.condominio.usecase;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.orquestrador.condominio.adapter.ApartamentoPessoaRequestAdapter;
import com.orquestrador.condominio.adapter.EnderecoRequestAdapter;
import com.orquestrador.condominio.adapter.PessoaRequestAdapter;
import com.orquestrador.condominio.adapter.TelefoneRequestAdapter;
import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;
import com.orquestrador.condominio.entity.EnderecoEntity;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.entity.TelefoneEntity;
import com.orquestrador.condominio.repository.ApartamentoPessoaRepository;
import com.orquestrador.condominio.repository.EnderecoRepository;
import com.orquestrador.condominio.repository.PessoaRepository;
import com.orquestrador.condominio.repository.TelefoneRepository;
import com.orquestrador.condominio.request.CommonPessoaRequest;
import com.orquestrador.condominio.response.CadastroPessoaResponse;

@Service
public class PessoaCadastroUseCase {

	private final PessoaRequestAdapter pessoaAdapter = new PessoaRequestAdapter();
	private PessoaEntity pessoaEntity;

	@Autowired
	ApartamentoPessoaRepository apartamentoPessoarepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	TelefoneRepository telefoneRepository;

	@Transactional
	public ResponseEntity<CadastroPessoaResponse> execute(final CommonPessoaRequest request, final UriComponentsBuilder uriBuilder) {

		pessoaEntity = pessoaAdapter.convert(request);
		final List<ApartamentoPessoaEntity> apartamentoPessoaEntity = new ApartamentoPessoaRequestAdapter().convert(request);
		final List<TelefoneEntity> telefoneEntity = new TelefoneRequestAdapter().convert(request);
		final List<EnderecoEntity> enderecoEntity = new EnderecoRequestAdapter().convert(request);

		pessoaRepository.save(pessoaEntity);

		apartamentoPessoaEntity.forEach(apartamento -> apartamento.setPessoaId(pessoaEntity.getId()));
		apartamentoPessoarepository.saveAll(apartamentoPessoaEntity);

		telefoneEntity.forEach(telefone -> telefone.setPessoaId(pessoaEntity));
		telefoneRepository.saveAll(telefoneEntity);

		enderecoEntity.forEach(endereco -> endereco.setPessoaId(pessoaEntity));
		enderecoRepository.saveAll(enderecoEntity);

		return getHttpResponse(uriBuilder);

	}

	private ResponseEntity<CadastroPessoaResponse> getHttpResponse(final UriComponentsBuilder uriBuilder) {
		final URI uri = uriBuilder.path("/pessoa/{pessoaId}").buildAndExpand(pessoaEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaAdapter.convert(pessoaEntity));
	}
}
