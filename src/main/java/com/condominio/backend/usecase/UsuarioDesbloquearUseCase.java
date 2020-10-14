package com.condominio.backend.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.condominio.backend.configuration.exception.UnprocessableEntityException;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;
import com.condominio.backend.request.UsuarioCommonRequest;

@Service
public class UsuarioDesbloquearUseCase {

	private final UsuarioRepository usuarioRepository;

	public UsuarioDesbloquearUseCase(final UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void execute(final UsuarioCommonRequest request) {

		final Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findByUsuario(request.getUsuario());
		if (!optionalUsuario.isPresent()) {
			throw new UnprocessableEntityException("usuario", "usuario não cadastrado");
		}

		final UsuarioEntity usuarioEntity = optionalUsuario.get();
		usuarioEntity.setBloqueado(false);
		usuarioRepository.save(usuarioEntity);
	}

}
