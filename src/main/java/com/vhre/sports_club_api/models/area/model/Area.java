package com.vhre.sports_club_api.models.area.model;

import com.vhre.sports_club_api.models.access_log.model.AccessLog;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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

	@OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<AccessLog> access_logs = new ArrayList<>();
}
