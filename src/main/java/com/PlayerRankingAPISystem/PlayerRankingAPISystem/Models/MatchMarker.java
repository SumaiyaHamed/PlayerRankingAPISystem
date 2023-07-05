package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "matchMarker")
public class MatchMarker extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    private boolean isAdmin;

}
