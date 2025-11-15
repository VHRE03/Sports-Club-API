package com.vhre.sports_club_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.method.HandlerMethod;

import java.util.List;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Sports Club API 🏋️‍♂️")
				.version("1.0.0")
				.description("API REST para la gestión de miembros del club deportivo. Incluye registro, búsqueda, actualización y eliminación de miembros.")
				.contact(new Contact()
					.name("Victor Hugo Romero Esquivel")
					.email("vhre@mail.com")
					.url("https://github.com/vhre"))
				.license(new License()
					.name("Apache 2.0")
					.url("https://www.apache.org/licenses/LICENSE-2.0"))
			)
			.servers(List.of(
				new Server().url("http://localhost:8080").description("Servidor local de desarrollo")
			));
	}

	@Bean
	public OperationCustomizer operationCustomizer() {
		return (operation, handlerMethod) -> {
			// Ordenar por método HTTP y luego por path
			String sortKey = getHttpMethodOrder(handlerMethod) + handlerMethod.getMethod().getName();
			operation.addExtension("x-sort", sortKey);
			return operation;
		};
	}

	private String getHttpMethodOrder(HandlerMethod handlerMethod) {
		if (handlerMethod.hasMethodAnnotation(GetMapping.class)) return "1";
		if (handlerMethod.hasMethodAnnotation(PostMapping.class)) return "2";
		if (handlerMethod.hasMethodAnnotation(PutMapping.class)) return "3";
		if (handlerMethod.hasMethodAnnotation(DeleteMapping.class)) return "4";
		return "5";
	}
}
