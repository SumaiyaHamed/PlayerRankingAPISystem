package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ranks")
public class RankManagement {
    @Id
    private Long id;
    private int rank;
}
