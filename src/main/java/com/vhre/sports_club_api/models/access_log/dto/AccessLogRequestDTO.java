package com.vhre.sports_club_api.models.access_log.dto;

import com.vhre.sports_club_api.models.access_log.enums.VisitorType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class AccessLogRequestDTO {
	@Schema(description = "Identificador único del socio que accede")
	@NotNull(message = "El id del miembro es obligatorio")
	private UUID member_id;

	@Schema(description = "Identificador del area a la que se accede")
	@NotNull(message = "El ide del área es obligatorio")
	private UUID area_id;

	@Schema(description = "Tipo de visitante")
	private VisitorType visitor_type;
}
