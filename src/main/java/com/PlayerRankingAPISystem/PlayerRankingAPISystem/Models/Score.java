package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Data
@Table(name = "scores")
public class Score extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    private Integer scoreValue;

    private double averageScore;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = true)
    private Player player;
}
