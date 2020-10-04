package com.condominio.backend.entrypoint;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.backend.request.LoginRequest;
import com.condominio.backend.usecase.LoginUseCase;

@RestController
@RequestMapping("/login")
public class LoginEntryPoint {

	private final LoginUseCase loginUsecase;

	public LoginEntryPoint(final LoginUseCase loginUsecase) {
		this.loginUsecase = loginUsecase;
	}

	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Valid final LoginRequest request) {
		return loginUsecase.execute(request);
	}

}
