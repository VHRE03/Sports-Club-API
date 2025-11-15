package com.vhre.sports_club_api.models.member.impl;

import com.vhre.sports_club_api.models.member.model.Member;
import com.vhre.sports_club_api.models.member.model.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.model.dto.MemberResponseDTO;
import com.vhre.sports_club_api.models.member.repository.MemberRepository;
import com.vhre.sports_club_api.models.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
	private final MemberRepository repository;
	private final ModelMapper mapper;

	@Override
	public MemberResponseDTO create(MemberRequestDTO dto) {
		Member member = mapper.map(dto, Member.class);
		Member savedMember = repository.save(member);
		return mapper.map(savedMember, MemberResponseDTO.class);
	}

	@Override
	public MemberResponseDTO findById(UUID id) {
		Member member = repository.findById(id).orElseThrow();
		return mapper.map(member, MemberResponseDTO.class);
	}

	@Override
	public List<MemberResponseDTO> findAll() {
		return repository.findAll().stream().map(
			member -> mapper.map(member, MemberResponseDTO.class)
		).collect(Collectors.toList());
	}

	@Override
	public MemberResponseDTO update(UUID id, MemberRequestDTO dto) {
		Member member = repository.findById(id).orElseThrow();
		mapper.map(dto, member);
		Member updatedMember = repository.save(member);
		return mapper.map(updatedMember, MemberResponseDTO.class);
	}

	@Override
	public void delete(UUID id) {
		Member member = repository.findById(id).orElseThrow();
		repository.delete(member);
	}
}
