package com.vhre.sports_club_api.models.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequestDTO {
	@Schema(description = "Número único de miembro (máx. 20 caracteres)", example = "M-001")
	@NotBlank
	@Size(max = 20)
	private String member_number;

	@Schema(description = "Nombre(s) (máx. 100 caracteres)", example = "John")
	@NotBlank
	@Size(max = 100)
	private String first_name;

	@Schema(description = "Apellido(s) (máx. 100 caracteres)", example = "Doe")
	@NotBlank
	@Size(max = 100)
	private String last_name;

	@Schema(description = "Correo electronico", example = "john_doe@email.com")
	@Email
	@NotBlank
	private String email;

	@Schema(description = "Fecha de nacimiento", example = "02-03-1988")
	@NotNull
	private LocalDate birth_date;

	@Schema(description = "Fecha de registro", example = "10-12-2025")
	@NotNull
	private LocalDate registration_date;

	@Schema(description = "Url de la foto de identificación", example = "")
	private String photo_url;

	@Schema(description = "Indicador de usuario activo", example = "true")
	private Boolean active;
}