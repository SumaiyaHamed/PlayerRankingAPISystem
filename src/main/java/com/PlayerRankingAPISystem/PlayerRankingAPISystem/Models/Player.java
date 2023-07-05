package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "players")
public class Player {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Score> scores;


}
