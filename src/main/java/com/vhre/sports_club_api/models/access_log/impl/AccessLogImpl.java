package com.vhre.sports_club_api.models.access_log.impl;

import com.vhre.sports_club_api.models.access_log.dto.AccessLogRequestDTO;
import com.vhre.sports_club_api.models.access_log.dto.AccessLogResponseDTO;
import com.vhre.sports_club_api.models.access_log.mapper.AccessLogMapper;
import com.vhre.sports_club_api.models.access_log.model.AccessLog;
import com.vhre.sports_club_api.models.access_log.repository.AccessLogRepository;
import com.vhre.sports_club_api.models.access_log.service.AccessLogService;
import com.vhre.sports_club_api.models.area.model.Area;
import com.vhre.sports_club_api.models.area.repository.AreaRepository;
import com.vhre.sports_club_api.models.member.model.Member;
import com.vhre.sports_club_api.models.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AccessLogImpl implements AccessLogService {
	private final AccessLogRepository repository;
	private final AccessLogMapper mapper;
	private final AreaRepository areaRepository;
	private final MemberRepository memberRepository;

	@Override
	public AccessLogResponseDTO create(AccessLogRequestDTO dto){
		Member member = memberRepository.findById(dto.getMember_id())
			.orElseThrow(() -> new RuntimeException("Miembro no encontrado"));

		Area area = areaRepository.findById(dto.getArea_id())
			.orElseThrow(() -> new RuntimeException("Área no encontrada"));

		AccessLog accessLog = mapper.toEntity(dto);
		accessLog.setMember(member);
		accessLog.setArea(area);
		AccessLog savedAccessLog = repository.save(accessLog);
		return mapper.toResponse(savedAccessLog);
	}

	@Override
	public AccessLogResponseDTO findById(UUID id){
		AccessLog accessLog = repository.findById(id).orElseThrow();
		return mapper.toResponse(accessLog);
	}

	@Override
	public List<AccessLogResponseDTO> findAll(){
		return repository.findAll().stream().map(mapper::toResponse).toList();
	}
}
