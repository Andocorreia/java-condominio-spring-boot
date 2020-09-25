package com.orquestrador.condominio.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.orquestrador.condominio.adapter.LoginRequestAdapter;
import com.orquestrador.condominio.adapter.LoginResponseAdapter;
import com.orquestrador.condominio.configuration.security.TokenService;
import com.orquestrador.condominio.request.LoginRequest;

@Service
public class LoginUseCase {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	TokenService tokenService;

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
