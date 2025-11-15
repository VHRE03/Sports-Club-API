package com.vhre.sports_club_api.models.area.controller;

import com.vhre.sports_club_api.models.area.model.dto.AreaRequestDTO;
import com.vhre.sports_club_api.models.area.model.dto.AreaResponseDTO;
import com.vhre.sports_club_api.models.area.service.AreaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/areas")
@Tag(name = "Areas", description = "Operaciones CRUD sobre areas")
@RequiredArgsConstructor
public class AreaController {
	private final AreaService service;

	@PostMapping()
	public ResponseEntity<AreaResponseDTO> create(@Valid @RequestBody AreaRequestDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public List<AreaResponseDTO> findAll(){
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AreaResponseDTO> findById(@Valid @PathVariable UUID id){
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AreaResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody AreaRequestDTO dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
