package com.vhre.sports_club_api.models.area.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "area")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, length = 50, unique = true)
	private String name;

	@Column(length = 100)
	private String description;

	@Column
	private int capacity;

	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean active = true;
}
