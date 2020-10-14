package com.condominio.backend.entrypoint;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.backend.request.UsuarioCommonRequest;
import com.condominio.backend.request.UsuarioRequest;
import com.condominio.backend.response.CadastroUsuarioResponse;
import com.condominio.backend.usecase.UsuarioAlterarSenhaUseCase;
import com.condominio.backend.usecase.UsuarioBloquearUseCase;
import com.condominio.backend.usecase.UsuarioCadastrarUseCase;
import com.condominio.backend.usecase.UsuarioDesbloquearUseCase;

@RestController
@RequestMapping("/usuario")
public class UsuarioEntryPoint {

	private final UsuarioCadastrarUseCase usuarioCadastrarUseCase;
	private final UsuarioBloquearUseCase usuarioBloquearUseCase;
	private final UsuarioAlterarSenhaUseCase usuarioAlterarSenhaUseCase;
	private final UsuarioDesbloquearUseCase usuarioDesbloquearUseCase;

	public UsuarioEntryPoint(
			final UsuarioCadastrarUseCase usuarioCadastrarUseCase,
			final UsuarioBloquearUseCase usuarioBloquearUseCase,
			final UsuarioAlterarSenhaUseCase usuarioAlterarSenhaUseCase,
			final UsuarioDesbloquearUseCase usuarioDesbloquearUseCase
			) {
		this.usuarioCadastrarUseCase = usuarioCadastrarUseCase;
		this.usuarioBloquearUseCase = usuarioBloquearUseCase;
		this.usuarioAlterarSenhaUseCase = usuarioAlterarSenhaUseCase;
		this.usuarioDesbloquearUseCase = usuarioDesbloquearUseCase;
	}

	@PostMapping
	public ResponseEntity<CadastroUsuarioResponse> cadastrar(@RequestBody @Valid final UsuarioRequest request, final UriComponentsBuilder uriBuilder) {
		return usuarioCadastrarUseCase.execute(request, uriBuilder);
	}

	@PutMapping("/bloquear")
	public void bloquear(@RequestBody @Valid final UsuarioCommonRequest usuario) {
		usuarioBloquearUseCase.execute(usuario);
	}

	@PutMapping("/desbloquear/{usuario}")
	public void desbloquear(@PathVariable @Valid final UsuarioCommonRequest usuario) {
		usuarioDesbloquearUseCase.execute(usuario);
	}

	@PutMapping("/alterarsenha")
	public void alterarSenha(@RequestBody @Valid final UsuarioRequest request) {
		usuarioAlterarSenhaUseCase.execute(request);
	}

}
