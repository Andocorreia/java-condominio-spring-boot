package com.condominio.backend.usecase;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.condominio.backend.configuration.exception.UnprocessableEntityException;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;
import com.condominio.backend.request.UsuarioCommonRequest;

@Service
public class UsuarioBloquearUseCase {

	private final UsuarioRepository usuarioRepository;

	public UsuarioBloquearUseCase(final UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public void execute(final UsuarioCommonRequest request) {

		final Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findByUsuario(request.getUsuario());
		if (!optionalUsuario.isPresent()) {
			throw new UnprocessableEntityException("usuario", "usuario não cadastrado");
		}

		final UsuarioEntity usuarioEntity = optionalUsuario.get();
		usuarioEntity.setBloqueado(true);
		usuarioRepository.save(usuarioEntity);

	}

}
