package com.condominio.backend.configuration.exception;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.condominio.backend.configuration.exception.model.ErrorEntity;
import com.condominio.backend.configuration.exception.model.ErrorValidation;

@RestControllerAdvice
public class GlobalErrorsHandlerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorsHandlerAdvice.class);
	private final MessageSource messageSource;

	public GlobalErrorsHandlerAdvice(final MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Collection<ErrorValidation> handle(final MethodArgumentNotValidException exception) {
		LOGGER.error(exception.getMessage());

		final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		return fieldErrors.stream()
				.map(err -> new ErrorValidation(err.getField(), messageSource.getMessage(err, LocaleContextHolder.getLocale())))
				.collect(Collectors.toList());
	}

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void handle(final HttpServletRequest req, final DataIntegrityViolationException exception) {
		LOGGER.error(exception.getMessage());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ArgumentNotValidException.class)
	public ErrorValidation handle(final ArgumentNotValidException exception) {
		LOGGER.error(exception.getMessage());
		return exception.getError();
	}

	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(UnprocessableEntityException.class)
	public ErrorEntity handle(final UnprocessableEntityException exception) {
		LOGGER.error(exception.getMessage());
		return exception.getError();
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ExceptionHandler(NoContentException.class)
	public void handle(final NoContentException exception) {
		LOGGER.error(exception.getMessage());
	}
}
