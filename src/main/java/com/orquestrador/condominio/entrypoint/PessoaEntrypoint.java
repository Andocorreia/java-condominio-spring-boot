package com.orquestrador.condominio.entrypoint;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.orquestrador.condominio.request.CommonPessoaRequest;
import com.orquestrador.condominio.response.CadastroPessoaResponse;
import com.orquestrador.condominio.response.PessoaResponse;
import com.orquestrador.condominio.usecase.PessoaAlteraUseCase;
import com.orquestrador.condominio.usecase.PessoaCadastroUseCase;
import com.orquestrador.condominio.usecase.PessoaConsultaUseCase;
import com.orquestrador.condominio.usecase.pessoaDeletaUseCase;

@RestController
@RequestMapping("/pessoa")
public class PessoaEntrypoint {

	@Autowired
	PessoaCadastroUseCase pessoaCadastroUseCase;

	@Autowired
	pessoaDeletaUseCase pessoaDeletaUseCase;

	@Autowired
	PessoaConsultaUseCase pessoaConsultaUseCase;

	@Autowired
	PessoaAlteraUseCase pessoaAlteraUseCase;

	@PostMapping
	public ResponseEntity<CadastroPessoaResponse> insert(@RequestBody @Valid final CommonPessoaRequest request, final UriComponentsBuilder uriBuilder) {
		return pessoaCadastroUseCase.execute(request, uriBuilder);
	}

	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<?> delete(@PathVariable final Long pessoaId) {
		return pessoaDeletaUseCase.execute(pessoaId);
	}

	@GetMapping("/{pessoaId}")
	public Collection<PessoaResponse> search(@PathVariable final Long pessoaId) {
		return pessoaConsultaUseCase.executa(pessoaId);
	}

	@GetMapping
	public Collection<PessoaResponse> search() {
		return pessoaConsultaUseCase.executa();
	}

	@PutMapping("/{pessoaId}")
	public ResponseEntity<?> update(
			@PathVariable final Long pessoaId, @RequestBody @Valid final CommonPessoaRequest request, final UriComponentsBuilder uriBuilder) {
		return pessoaAlteraUseCase.execute(pessoaId, request, uriBuilder);
	}
}
