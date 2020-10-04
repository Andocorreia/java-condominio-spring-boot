package com.condominio.backend.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;

@Service
public class UsuarioBloquearUseCase {

	private final UsuarioRepository usuarioRepository;

	public UsuarioBloquearUseCase(final UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void execute(final String request) {

		final Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findByUsuario(request);
		if(optionalUsuario.isPresent()) {
			final UsuarioEntity usuarioEntity = optionalUsuario.get();
			usuarioEntity.setBloqueado(true);
			usuarioRepository.save(usuarioEntity);
		}

	}

}
