package com.condominio.backend.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;
import com.condominio.backend.request.UsuarioRequest;

@Service
public class UsuarioAlterarSenhaUseCase {

	private final UsuarioRepository usuarioRepository;

	public UsuarioAlterarSenhaUseCase(final UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void execute(final UsuarioRequest request) {

		final Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findByUsuario(request.getUsuario());

		if(optionalUsuario.isPresent()) {
			final UsuarioEntity usuarioEntity = optionalUsuario.get();
			usuarioEntity.setSenha(request.getSenha());
			usuarioEntity.setBloqueado(false);
			usuarioEntity.setExpirado(false);
			usuarioRepository.save(usuarioEntity);
		}

	}

}
