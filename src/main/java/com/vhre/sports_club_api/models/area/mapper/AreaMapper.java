package com.vhre.sports_club_api.models.area.mapper;

import com.vhre.sports_club_api.models.area.dto.AreaUpdateDTO;
import com.vhre.sports_club_api.models.area.model.Area;
import com.vhre.sports_club_api.models.area.dto.AreaRequestDTO;
import com.vhre.sports_club_api.models.area.dto.AreaResponseDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AreaMapper {
	// Convert DTO -> Entity
	Area toEntity(AreaRequestDTO dto);

	// Convert Entity -> response DTO
	AreaResponseDTO toResponse(Area entity);

	// Partial update and update
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromRequest(AreaRequestDTO dto, @MappingTarget Area entity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromPatch(AreaUpdateDTO dto, @MappingTarget Area entity);
}
