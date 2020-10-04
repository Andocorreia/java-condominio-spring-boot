package com.condominio.backend.configuration.exception;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandlerValidation {

	private final MessageSource messageSource;

	public ErrorsHandlerValidation(final MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Collection<ErrorValidation> handle(final MethodArgumentNotValidException exception) {

		final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		return fieldErrors.stream()
				.map(err -> new ErrorValidation(err.getField(),  messageSource.getMessage(err, LocaleContextHolder.getLocale())))
				.collect(Collectors.toList());
	}
}
