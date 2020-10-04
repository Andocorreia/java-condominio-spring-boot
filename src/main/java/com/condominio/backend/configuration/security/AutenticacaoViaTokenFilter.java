package com.condominio.backend.configuration.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final UsuarioRepository usuarioRepository;

	public AutenticacaoViaTokenFilter(final TokenService tokenService, final UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(
			final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain)
					throws ServletException, IOException {

		final String auth = request.getHeader("Authorization");

		if (this.tokenService.valida(auth)) {
			this.autenticarCliente(auth);
		}

		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(final String auth) {

		final String usuarioNome = this.tokenService.getUsuario(auth);
		final Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findByUsuario(usuarioNome);

		if (optionalUsuario.isPresent()) {

			final UsuarioEntity usuario = optionalUsuario.get();

			final UsernamePasswordAuthenticationToken authentication =
					new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authentication);

		}
	}

}
