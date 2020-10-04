package com.condominio.backend.adapter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.condominio.backend.request.LoginRequest;

public class LoginRequestAdapter implements Adapter<UsernamePasswordAuthenticationToken, LoginRequest> {

	@Override
	public UsernamePasswordAuthenticationToken convert(final LoginRequest request) {
		return new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getSenha());
	}

}
