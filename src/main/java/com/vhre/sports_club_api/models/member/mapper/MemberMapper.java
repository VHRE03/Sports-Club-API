package com.vhre.sports_club_api.models.member.mapper;

import com.vhre.sports_club_api.models.member.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.dto.MemberResponseDTO;
import com.vhre.sports_club_api.models.member.dto.MemberUpdateDTO;
import com.vhre.sports_club_api.models.member.model.Member;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MemberMapper {
	// Convert DTO -> Entity
	Member toEntity(MemberRequestDTO dto);

	// Convert Entity -> response DTO
	MemberResponseDTO toResponse(Member entity);

	// Partial update and update
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromRequest(MemberRequestDTO dto, @MappingTarget Member entity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromPatch(MemberUpdateDTO dto, @MappingTarget Member entity);
}
