package com.condominio.backend.usecase;


import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.condominio.backend.adapter.LoginRequestAdapter;
import com.condominio.backend.adapter.LoginResponseAdapter;
import com.condominio.backend.configuration.security.TokenService;
import com.condominio.backend.request.LoginRequest;

@Service
public class LoginUseCase {

	private final AuthenticationManager authManager;
	private final TokenService tokenService;

	public LoginUseCase(final AuthenticationManager authManager, final TokenService tokenService) {
		this.authManager = authManager;
		this.tokenService = tokenService;
	}

	@Transactional
	public ResponseEntity<?> execute(final LoginRequest request) {

		try {
			final Authentication authenticate = authManager.authenticate(new LoginRequestAdapter().convert(request));

			final String token = tokenService.cria(authenticate);

			return ResponseEntity.ok(new LoginResponseAdapter().convert(token));
		}
		catch (final AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
