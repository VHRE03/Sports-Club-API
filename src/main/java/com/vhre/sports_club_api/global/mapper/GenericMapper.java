package com.vhre.sports_club_api.global.mapper;

public interface GenericMapper<Entity, RequestDTO, ResponseDTO> {
	Entity toEntity(RequestDTO dto);
	ResponseDTO toResponse(Entity entity);
}
