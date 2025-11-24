package com.vhre.sports_club_api.models.access_log.model;

import com.vhre.sports_club_api.models.access_log.enums.VisitorType;
import com.vhre.sports_club_api.models.area.model.Area;
import com.vhre.sports_club_api.models.member.model.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "access_log")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessLog {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	@ToString.Exclude
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id", nullable = false)
	@ToString.Exclude
	private Area area;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime access_datetime;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private VisitorType visitor_type;
}
