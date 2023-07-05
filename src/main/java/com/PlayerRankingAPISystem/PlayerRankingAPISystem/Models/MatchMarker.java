package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "matchMarker")
public class MatchMarker {

    @Id
    private Long id;

    private boolean isAdmin;
    
}
