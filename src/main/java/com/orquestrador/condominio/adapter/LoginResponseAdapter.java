package com.orquestrador.condominio.adapter;

import com.orquestrador.condominio.response.LoginResponse;

public class LoginResponseAdapter implements Adapter<LoginResponse, String> {

	private final String TIPOTOKEN = "Bearer";

	@Override
	public LoginResponse convert(final String token) {
		return new LoginResponse(token);
	}

}
