package com.vhre.sports_club_api.models.access_log.service;

import com.vhre.sports_club_api.global.service.GenericService;
import com.vhre.sports_club_api.models.access_log.dto.AccessLogRequestDTO;
import com.vhre.sports_club_api.models.access_log.dto.AccessLogResponseDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface AccessLogService {
	AccessLogResponseDTO create(@Valid AccessLogRequestDTO dto);
	AccessLogResponseDTO findById(UUID id);
	List<AccessLogResponseDTO> findAll();
}
