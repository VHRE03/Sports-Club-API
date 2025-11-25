package com.vhre.sports_club_api.models.access_log.repository;

import com.vhre.sports_club_api.models.access_log.model.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccessLogRepository extends JpaRepository<AccessLog, UUID> { }
