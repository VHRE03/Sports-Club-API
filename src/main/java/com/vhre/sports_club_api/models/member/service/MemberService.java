package com.vhre.sports_club_api.models.member.service;

import com.vhre.sports_club_api.models.member.model.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.model.dto.MemberResponseDTO;

import java.util.List;
import java.util.UUID;

public interface MemberService {
	MemberResponseDTO create(MemberRequestDTO dto);
	MemberResponseDTO findById(UUID id);
	List<MemberResponseDTO> findAll();
	MemberResponseDTO update(UUID id, MemberRequestDTO dto);
	void delete(UUID id);
}
