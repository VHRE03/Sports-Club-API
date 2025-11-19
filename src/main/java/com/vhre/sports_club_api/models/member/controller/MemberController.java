package com.vhre.sports_club_api.models.member.controller;

import com.vhre.sports_club_api.models.member.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.dto.MemberResponseDTO;
import com.vhre.sports_club_api.models.member.dto.MemberUpdateDTO;
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

	@PostMapping()
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

	@PatchMapping("/{id}")
	public MemberResponseDTO patch(@PathVariable UUID id, @Valid @RequestBody MemberUpdateDTO dto) {
		return service.patch(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
