package com.condominio.backend.usecase;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.backend.adapter.UsuarioRequestAdapter;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.PerfilRepository;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.repository.UsuarioRepository;
import com.condominio.backend.request.UsuarioRequest;
import com.condominio.backend.response.CadastroUsuarioResponse;

@Service
public class UsuarioCadastrarUseCase {

	private final UsuarioRepository usuarioRepository;
	private final PessoaRepository pessoaRepository;
	private final PerfilRepository perfilRepository;

	public UsuarioCadastrarUseCase(
			final UsuarioRepository usuarioRepository,
			final PessoaRepository pessoaRepository,
			final PerfilRepository perfilRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.pessoaRepository = pessoaRepository;
		this.perfilRepository = perfilRepository;
	}

	@Transactional
	public ResponseEntity<CadastroUsuarioResponse> execute(final UsuarioRequest request, final UriComponentsBuilder uriBuilder) {

		final UsuarioEntity usuarioEntity = new UsuarioRequestAdapter(pessoaRepository, perfilRepository).convert(request);
		usuarioRepository.save(usuarioEntity);

		return getHttpResponse(uriBuilder, usuarioEntity);

	}

	private ResponseEntity<CadastroUsuarioResponse> getHttpResponse(final UriComponentsBuilder uriBuilder, final UsuarioEntity usuarioEntity) {
		final URI uri = uriBuilder.path("/pessoa/{pessoaId}").buildAndExpand(usuarioEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(new CadastroUsuarioResponse(usuarioEntity.getId()));
	}

}
