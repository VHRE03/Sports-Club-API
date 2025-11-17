package com.vhre.sports_club_api.models.area.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AreaResponseDTO {
	private UUID id;
	private String name;
	private String description;
	private int capacity;
	private boolean active;
}
