package com.orquestrador.condominio.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orquestrador.condominio.request.CadastroPessoaRequest;
import com.orquestrador.condominio.usecase.PessoaCadastroUseCase;

@RestController
@RequestMapping("/cadastroPessoa")
public class CadastroPessoaEntrypoint {

	@Autowired
	PessoaCadastroUseCase pessoaCadastroUseCase;

	@PostMapping
	public String cadastro(@RequestBody final CadastroPessoaRequest request) {

		pessoaCadastroUseCase.execute(request);

		return "Cadastro OK";
	}

	@DeleteMapping("/{pessoaId}")
	public String delete(@PathVariable(name = "pessoaId") final Long pessoaID) {

		return "Delete OK";
	}
}
