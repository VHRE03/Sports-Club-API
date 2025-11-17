package com.vhre.sports_club_api.models.area.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AreaUpdateDTO {
	@Schema(description = "Nuevo nombre del área (opcional)", example = "Alberca techada")
	@Size(max = 50)
	private String name;

	@Schema(description = "Nueva descripción del área (opcional)", example = "Área remodelada")
	@Size(max = 100)
	private String description;

	@Schema(description = "Nueva capacidad (opcional)", example = "80")
	@PositiveOrZero
	private Integer capacity;

	@Schema(description = "Actualizar si está activa (opcional)", example = "false")
	private Boolean active;
}
