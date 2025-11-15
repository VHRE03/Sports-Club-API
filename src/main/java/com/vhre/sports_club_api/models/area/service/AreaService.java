package com.vhre.sports_club_api.models.area.service;

import com.vhre.sports_club_api.models.area.model.dto.AreaRequestDTO;
import com.vhre.sports_club_api.models.area.model.dto.AreaResponseDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface AreaService {
	AreaResponseDTO create(@Valid AreaRequestDTO dto);
	AreaResponseDTO findById(UUID id);
	List<AreaResponseDTO> findAll();
	AreaResponseDTO update(UUID id, AreaRequestDTO dto);
	void delete(UUID id);
}
