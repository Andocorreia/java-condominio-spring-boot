package com.condominio.backend.configuration.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.condominio.backend.request.PessoaRequest.Endereco;
import com.condominio.backend.request.PessoaRequest.Telefone;
import com.condominio.backend.request.UsuarioCommonRequest;
import com.condominio.backend.request.UsuarioRequest;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.condominio"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(
						UsuarioRequest.class,
						UsuarioCommonRequest.class,
						Telefone.class,
						Endereco.class
						)
				.globalOperationParameters(
						Arrays.asList(
								new ParameterBuilder()
								.name("Authorization")
								.description("Header para Token JWT")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false)
								.build()));
	}
}
