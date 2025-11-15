package com.vhre.sports_club_api.models.member.repository;

import com.vhre.sports_club_api.models.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> { }
