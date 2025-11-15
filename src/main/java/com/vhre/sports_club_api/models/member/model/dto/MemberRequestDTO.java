package com.vhre.sports_club_api.models.member.model.dto;

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

	@NotBlank
	@Size(max = 100)
	private String first_name;

	@NotBlank
	@Size(max = 100)
	private String last_name;

	@Email
	@NotBlank
	private String email;

	@NotNull
	private LocalDate birth_date;

	@NotNull
	private LocalDate registration_date;

	private String photo_url;

	private Boolean active;
}