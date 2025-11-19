package com.vhre.sports_club_api.models.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberUpdateDTO {
	@Schema(description = "Número único de miembro (opcional)", example = "M-001")
	@Size(max = 20)
	private String member_number;

	@Schema(description = "Nombre(s) (opcional)", example = "John")
	@Size(max = 100)
	private String first_name;

	@Schema(description = "Apellido(s) (opcional)", example = "Doe")
	@Size(max = 100)
	private String last_name;

	@Schema(description = "Correo electronico (opcional)", example = "john_doe@email.com")
	@Email
	private String email;

	@Schema(description = "Fecha de nacimiento (opcional)", example = "02-03-1988")
	private LocalDate birth_date;

	@Schema(description = "Fecha de registro (opcional)", example = "10-12-2025")
	private LocalDate registration_date;

	@Schema(description = "Url de la foto de identificación (opcional)", example = "")
	private String photo_url;

	@Schema(description = "Indicador de usuario activo (opcional)", example = "true")
	private Boolean active;
}
