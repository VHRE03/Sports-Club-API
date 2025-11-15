package com.vhre.sports_club_api.models.area.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AreaRequestDTO {
	@Schema(description = "Nombre del área (máx. 50 caracteres)", example = "Alberca")
	@NotBlank
	@Size(max = 50)
	private String name;

	@Schema(description = "Descripción del área (opcional, máx. 100 caracteres)", example = "Área techada con alberca semiolímpica")
	@Size(max = 100)
	private String description;

	@Schema(description = "Capacidad máxima del área", example = "50")
	@PositiveOrZero
	private int capacity;

	@Schema(description = "Indica si el área está activa", example = "true")
	private Boolean active;
}
