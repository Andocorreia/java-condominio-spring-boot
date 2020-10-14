package com.condominio.backend.usecase;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.backend.adapter.ApartamentoPessoaRequestAdapter;
import com.condominio.backend.adapter.EnderecoRequestAdapter;
import com.condominio.backend.adapter.PessoaRequestAdapter;
import com.condominio.backend.adapter.TelefoneRequestAdapter;
import com.condominio.backend.entity.ApartamentoPessoaEntity;
import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.TelefoneEntity;
import com.condominio.backend.repository.ApartamentoPessoaRepository;
import com.condominio.backend.repository.EnderecoRepository;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.repository.TelefoneRepository;
import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.response.CadastroPessoaResponse;

@Service
public class PessoaCadastroUseCase {

	private final PessoaRequestAdapter pessoaAdapter = new PessoaRequestAdapter();
	private final ApartamentoPessoaRepository apartamentoPessoarepository;
	private final EnderecoRepository enderecoRepository;
	private final PessoaRepository pessoaRepository;
	private final TelefoneRepository telefoneRepository;
	private PessoaEntity pessoaEntity;

	public PessoaCadastroUseCase(
			final ApartamentoPessoaRepository apartamentoPessoarepository,
			final EnderecoRepository enderecoRepository,
			final PessoaRepository pessoaRepository,
			final TelefoneRepository telefoneRepository
			) {
		this.apartamentoPessoarepository = apartamentoPessoarepository;
		this.enderecoRepository = enderecoRepository;
		this.pessoaRepository = pessoaRepository;
		this.telefoneRepository = telefoneRepository;
	}

	@Transactional
	public ResponseEntity<CadastroPessoaResponse> execute(final PessoaRequest request, final UriComponentsBuilder uriBuilder) {

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
		return ResponseEntity.created(uri).body(new CadastroPessoaResponse(pessoaEntity.getId()));
	}
}
