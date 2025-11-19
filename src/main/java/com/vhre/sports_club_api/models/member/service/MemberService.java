package com.vhre.sports_club_api.models.member.service;

import com.vhre.sports_club_api.models.member.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.dto.MemberResponseDTO;
import com.vhre.sports_club_api.models.member.dto.MemberUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface MemberService {
	MemberResponseDTO create(MemberRequestDTO dto);
	MemberResponseDTO findById(UUID id);
	List<MemberResponseDTO> findAll();
	MemberResponseDTO update(UUID id, MemberRequestDTO dto);
	MemberResponseDTO patch(UUID id, MemberUpdateDTO dto);
	void delete(UUID id);
}
