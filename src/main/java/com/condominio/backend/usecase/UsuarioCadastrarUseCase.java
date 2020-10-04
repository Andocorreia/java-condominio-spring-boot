package com.condominio.backend.usecase;

import org.springframework.stereotype.Service;

import com.condominio.backend.adapter.UsuarioRequestAdapter;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.PerfilRepository;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.repository.UsuarioRepository;
import com.condominio.backend.request.UsuarioRequest;

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

	public void execute(final UsuarioRequest request) {

		final UsuarioEntity entity = new UsuarioRequestAdapter(pessoaRepository, perfilRepository).convert(request);
		usuarioRepository.save(entity);

	}

}
