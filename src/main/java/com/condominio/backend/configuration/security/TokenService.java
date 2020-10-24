package com.condominio.backend.configuration.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.condominio.backend.entity.UsuarioEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${condominio.jwt.secret}")
	String secret;

	@Value("${condominio.jwt.expiration}")
	private String expiration;

	public boolean valida(final String auth) {
		if (auth == null || auth.isEmpty() || !auth.startsWith("Bearer ")) {
			return false;
		}

		try {
			this.getDados(auth);
			return true;
		}
		catch (final Exception e) {
			return false;
		}
	}


	public String getUsuario(final String auth) {
		return this.getDados(auth).getBody().getSubject();
	}

	public String cria(final Authentication authenticate) {
		final UsuarioEntity usuario = (UsuarioEntity) authenticate.getPrincipal();
		final Date dataAtual = new Date();
		final Date dataExpiracao = new Date(dataAtual.getTime() + Long.parseLong(expiration));

		return "Bearer " +
		Jwts.builder()
		.setIssuer("API da aplicação Condominio")
		.setSubject(usuario.getUsername())
		.setIssuedAt(dataAtual)
		.setExpiration(dataExpiracao)
		.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	private String getToken(final String token) {
		return token.substring(7, token.length());
	}

	private Jws<Claims> getDados(final String token) {
		return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(getToken(token));
	}
}
