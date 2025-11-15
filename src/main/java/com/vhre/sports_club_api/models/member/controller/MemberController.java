package com.vhre.sports_club_api.models.member.controller;

import com.vhre.sports_club_api.models.member.model.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.model.dto.MemberResponseDTO;
import com.vhre.sports_club_api.models.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/members")
@Tag(name = "Miembros", description = "Operaciones CRUD sobre miembros")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService service;

	@PostMapping(
		consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE
		},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	@Operation(summary = "Crear nuevo miembro", description = "Registra un nuevo miembro en la base de datos")
	public ResponseEntity<MemberResponseDTO> create(@Valid @RequestBody MemberRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public List<MemberResponseDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemberResponseDTO> findById(@Valid @PathVariable UUID id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MemberResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody MemberRequestDTO dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
