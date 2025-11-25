package com.vhre.sports_club_api.models.access_log.dto;

import com.vhre.sports_club_api.models.access_log.enums.VisitorType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccessLogResponseDTO {
	@Schema(description = "Identificador único del socio que accede")
	private UUID member_id;

	@Schema(description = "Identificador del area a la que se accede")
	private UUID area_id;

	@Schema(description = "Fecha y hora exacta del acceso")
	private LocalDateTime access_datetime;

	@Schema(description = "Tipo de visitante")
	private VisitorType visitor_type;
}
