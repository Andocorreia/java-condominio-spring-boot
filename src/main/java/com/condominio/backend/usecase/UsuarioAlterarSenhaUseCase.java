package com.condominio.backend.usecase;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.condominio.backend.configuration.exception.UnprocessableEntityException;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;
import com.condominio.backend.request.UsuarioRequest;

@Service
public class UsuarioAlterarSenhaUseCase {

	private final UsuarioRepository usuarioRepository;

	public UsuarioAlterarSenhaUseCase(final UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public void execute(final UsuarioRequest request) {

		final Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findByUsuario(request.getUsuario());

		if (!optionalUsuario.isPresent()) {
			throw new UnprocessableEntityException("usuario", "usuario não cadastrado");
		}

		final UsuarioEntity usuarioEntity = optionalUsuario.get();
		usuarioEntity.setSenha(request.getSenha());
		usuarioEntity.setBloqueado(false);
		usuarioEntity.setUltimaAlteracaoSenha(LocalDate.now());
		usuarioRepository.save(usuarioEntity);
	}

}
