package com.vhre.sports_club_api.models.area;

import com.vhre.sports_club_api.models.area.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AreaRepository extends JpaRepository<Area, UUID> { }
