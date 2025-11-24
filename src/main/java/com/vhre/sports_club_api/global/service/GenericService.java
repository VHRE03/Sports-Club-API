package com.vhre.sports_club_api.global.service;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface GenericService<ModelResponseDTO, ModelRequestDTO, ModelUpdateDTO> {
	ModelResponseDTO create(@Valid ModelRequestDTO dto);

	ModelResponseDTO findById(UUID id);

	List<ModelResponseDTO> findAll();

	ModelResponseDTO update(UUID id, ModelRequestDTO dto);

	ModelResponseDTO patch(UUID id, ModelUpdateDTO dto);

	void delete(UUID id);
}