package com.orquestrador.condominio.adapter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.orquestrador.condominio.request.LoginRequest;

public class LoginRequestAdapter implements Adapter<UsernamePasswordAuthenticationToken, LoginRequest> {

	@Override
	public UsernamePasswordAuthenticationToken convert(final LoginRequest request) {
		return new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getSenha());
	}

}
