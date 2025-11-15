package com.vhre.sports_club_api.models.member.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MemberResponseDTO {
	private UUID id;
	private String member_number;
	private String first_name;
	private String last_name;
	private String email;
	private LocalDate birth_date;
	private LocalDate registration_date;
	private String photo_url;
	private boolean active;
}
