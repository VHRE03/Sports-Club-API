package com.vhre.sports_club_api.global.controller;

import com.vhre.sports_club_api.global.service.GenericService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
public class GenericController<modelResponseDTO, modelRequestDTO, modelUpdateDTO> {
	private final GenericService<modelResponseDTO, modelRequestDTO, modelUpdateDTO> service;

	@PostMapping()
	public ResponseEntity<modelResponseDTO> create(@Valid @RequestBody modelRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public List<modelResponseDTO> findAll(){
		return service.findAll();
	}
}
