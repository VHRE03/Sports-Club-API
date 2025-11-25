package com.vhre.sports_club_api.models.access_log.controller;

import com.vhre.sports_club_api.models.access_log.dto.AccessLogRequestDTO;
import com.vhre.sports_club_api.models.access_log.dto.AccessLogResponseDTO;
import com.vhre.sports_club_api.models.access_log.service.AccessLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/access_logs")
@Tag(name = "Registro de acceso", description = "Registro de accesos")
@RequiredArgsConstructor
public class AccessLogController {
	private final AccessLogService service;

	@PostMapping()
	public ResponseEntity<AccessLogResponseDTO> create(@Valid @RequestBody AccessLogRequestDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccessLogResponseDTO> findById(@Valid @PathVariable UUID id){
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping
	public List<AccessLogResponseDTO> findAll(){
		return service.findAll();
	}
}
