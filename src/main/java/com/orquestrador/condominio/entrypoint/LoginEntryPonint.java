package com.orquestrador.condominio.entrypoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orquestrador.condominio.request.LoginRequest;
import com.orquestrador.condominio.usecase.LoginUseCase;

@RestController
@RequestMapping("/login")
public class LoginEntryPonint {

	@Autowired
	private LoginUseCase loginUsecase;

	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Valid final LoginRequest request) {

		return loginUsecase.execute(request);

	}


}
