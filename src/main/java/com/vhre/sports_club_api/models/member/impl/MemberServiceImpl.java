package com.vhre.sports_club_api.models.member.impl;

import com.vhre.sports_club_api.models.member.dto.MemberUpdateDTO;
import com.vhre.sports_club_api.models.member.mapper.MemberMapper;
import com.vhre.sports_club_api.models.member.model.Member;
import com.vhre.sports_club_api.models.member.dto.MemberRequestDTO;
import com.vhre.sports_club_api.models.member.dto.MemberResponseDTO;
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
	private final MemberMapper mapper;

	@Override
	public MemberResponseDTO create(MemberRequestDTO dto) {
		Member member = mapper.toEntity(dto);
		Member savedMember = repository.save(member);
		return mapper.toResponse(savedMember);
	}

	@Override
	public MemberResponseDTO findById(UUID id) {
		Member member = repository.findById(id).orElseThrow();
		return mapper.toResponse(member);
	}

	@Override
	public List<MemberResponseDTO> findAll() {
		return repository.findAll().stream().map(mapper::toResponse).toList();
	}

	@Override
	public MemberResponseDTO update(UUID id, MemberRequestDTO dto) {
		Member member = repository.findById(id).orElseThrow();
		mapper.updateFromRequest(dto, member);
		repository.save(member);
		return mapper.toResponse(member);
	}

	@Override
	public MemberResponseDTO patch(UUID id, MemberUpdateDTO dto){
		Member member = repository.findById(id).orElseThrow();
		mapper.updateFromPatch(dto, member);
		repository.save(member);
		return mapper.toResponse(member);
	}

	@Override
	public void delete(UUID id) {
		Member member = repository.findById(id).orElseThrow();
		repository.delete(member);
	}
}
