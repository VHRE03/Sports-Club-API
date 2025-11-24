package com.vhre.sports_club_api.global.impl;

import com.vhre.sports_club_api.global.mapper.GenericMapper;
import com.vhre.sports_club_api.global.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericImpl<
	Entity,
	ID,
	ModelResponseDTO,
	ModelRequestDTO,
	ModelUpdateDTO,
	ModelRepository extends JpaRepository<Entity, ID>,
	ModelMapper extends GenericMapper<Entity, ModelRequestDTO, ModelResponseDTO>
	> implements GenericService<ModelResponseDTO, ModelRequestDTO, ModelUpdateDTO> {

	protected ModelRepository repository;
	protected ModelMapper mapper;

	@Override
	public ModelResponseDTO create(ModelRequestDTO dto) {
		Entity entity = mapper.toEntity(dto);
		Entity savedEntity = repository.save(entity);
		return mapper.toResponse(savedEntity);
	}
}
