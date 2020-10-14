package com.condominio.backend.entrypoint;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.response.CadastroPessoaResponse;
import com.condominio.backend.response.PessoaResponse;
import com.condominio.backend.usecase.PessoaAlteraUseCase;
import com.condominio.backend.usecase.PessoaCadastroUseCase;
import com.condominio.backend.usecase.PessoaConsultaUseCase;
import com.condominio.backend.usecase.pessoaDeletaUseCase;

@RestController
@RequestMapping("/pessoa")
public class PessoaEntryPoint {

	private final PessoaCadastroUseCase pessoaCadastroUseCase;
	private final pessoaDeletaUseCase pessoaDeletaUseCase;
	private final PessoaConsultaUseCase pessoaConsultaUseCase;
	private final PessoaAlteraUseCase pessoaAlteraUseCase;

	public PessoaEntryPoint(
			final PessoaCadastroUseCase pessoaCadastroUseCase,
			final pessoaDeletaUseCase pessoaDeletaUseCase,
			final PessoaConsultaUseCase pessoaConsultaUseCase,
			final PessoaAlteraUseCase pessoaAlteraUseCase
			) {
		this.pessoaCadastroUseCase = pessoaCadastroUseCase;
		this.pessoaDeletaUseCase = pessoaDeletaUseCase;
		this.pessoaConsultaUseCase = pessoaConsultaUseCase;
		this.pessoaAlteraUseCase = pessoaAlteraUseCase;

	}

	@PostMapping
	@CacheEvict(value = "pessoaSearch", allEntries = true)
	public ResponseEntity<CadastroPessoaResponse> insert(@RequestBody @Valid final PessoaRequest request, final UriComponentsBuilder uriBuilder) {
		return pessoaCadastroUseCase.execute(request, uriBuilder);
	}

	@DeleteMapping("/{pessoaId}")
	@CacheEvict(value = "pessoaSearch", allEntries = true)
	public void delete(@PathVariable final Long pessoaId) {
		pessoaDeletaUseCase.execute(pessoaId);
	}

	@GetMapping("/{pessoaId}")
	@Cacheable("pessoaSearch")
	public Collection<PessoaResponse> search(@PathVariable final Long pessoaId) {
		return pessoaConsultaUseCase.executa(pessoaId);
	}

	@GetMapping
	public Collection<PessoaResponse> search() {
		return pessoaConsultaUseCase.executa();
	}

	@PutMapping("/{pessoaId}")
	@CacheEvict(value = "pessoaSearch", allEntries = true)
	public void update(
			@PathVariable final Long pessoaId, @RequestBody @Valid final PessoaRequest request, final UriComponentsBuilder uriBuilder) {
		pessoaAlteraUseCase.execute(pessoaId, request, uriBuilder);
	}
}
