package com.vhre.sports_club_api.models.area.impl;

import com.vhre.sports_club_api.models.area.AreaRepository;
import com.vhre.sports_club_api.models.area.model.Area;
import com.vhre.sports_club_api.models.area.model.dto.AreaRequestDTO;
import com.vhre.sports_club_api.models.area.model.dto.AreaResponseDTO;
import com.vhre.sports_club_api.models.area.service.AreaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AreaServiceImpl implements AreaService {
	private final AreaRepository repository;
	private final ModelMapper mapper;

	@Override
	public AreaResponseDTO create(AreaRequestDTO dto){
		Area area = mapper.map(dto, Area.class);
		Area saveArea = repository.save(area);
		return mapper.map(saveArea, AreaResponseDTO.class);
	}

	@Override
	public AreaResponseDTO findById(UUID id) {
		Area area = repository.findById(id).orElseThrow();
		return mapper.map(area, AreaResponseDTO.class);
	}

	@Override
	public List<AreaResponseDTO> findAll(){
		return repository.findAll().stream().map(
			area -> mapper.map(area, AreaResponseDTO.class)
		).collect(Collectors.toList());
	}

	@Override
	public AreaResponseDTO update(UUID id, AreaRequestDTO dto){
		Area area = repository.findById(id).orElseThrow();
		mapper.map(dto, area);
		Area updatedArea = repository.save(area);
		return mapper.map(updatedArea, AreaResponseDTO.class);
	}

	@Override
	public void delete(UUID id){
		Area area = repository.findById(id).orElseThrow();
		repository.delete(area);
	}
}
