package com.vhre.sports_club_api.models.area.impl;

import com.vhre.sports_club_api.models.area.dto.AreaUpdateDTO;
import com.vhre.sports_club_api.models.area.mapper.AreaMapper;
import com.vhre.sports_club_api.models.area.repository.AreaRepository;
import com.vhre.sports_club_api.models.area.model.Area;
import com.vhre.sports_club_api.models.area.dto.AreaRequestDTO;
import com.vhre.sports_club_api.models.area.dto.AreaResponseDTO;
import com.vhre.sports_club_api.models.area.service.AreaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AreaServiceImpl implements AreaService {
	private final AreaRepository repository;
	private final AreaMapper mapper;

	@Override
	public AreaResponseDTO create(AreaRequestDTO dto){
		Area area = mapper.toEntity(dto);
		Area savedArea = repository.save(area);
		return mapper.toResponse(savedArea);
	}

	@Override
	public AreaResponseDTO findById(UUID id) {
		Area area = repository.findById(id).orElseThrow();
		return mapper.toResponse(area);
	}

	@Override
	public List<AreaResponseDTO> findAll(){
		return repository.findAll().stream().map(mapper::toResponse).toList();
	}

	@Override
	public AreaResponseDTO update(UUID id, AreaRequestDTO dto){
		Area area = repository.findById(id).orElseThrow();
		mapper.updateFromRequest(dto, area);
		repository.save(area);
		return mapper.toResponse(area);
	}

	@Override
	public AreaResponseDTO patch(UUID id, AreaUpdateDTO dto){
		Area area = repository.findById(id).orElseThrow();
		mapper.updateFromPatch(dto, area);
		repository.save(area);
		return mapper.toResponse(area);
	}

	@Override
	public void delete(UUID id){
		Area area = repository.findById(id).orElseThrow();
		repository.delete(area);
	}
}
