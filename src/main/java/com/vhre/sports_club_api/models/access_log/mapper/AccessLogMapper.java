package com.vhre.sports_club_api.models.access_log.mapper;

import com.vhre.sports_club_api.models.access_log.dto.AccessLogRequestDTO;
import com.vhre.sports_club_api.models.access_log.dto.AccessLogResponseDTO;
import com.vhre.sports_club_api.models.access_log.model.AccessLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccessLogMapper {
	@Mapping(target = "member", ignore = true)
	@Mapping(target = "area", ignore = true)
	AccessLog toEntity(AccessLogRequestDTO dto);

	AccessLogResponseDTO toResponse(AccessLog entity);
}
