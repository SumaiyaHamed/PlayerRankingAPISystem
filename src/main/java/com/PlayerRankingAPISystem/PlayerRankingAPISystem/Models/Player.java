package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Data
@Table(name = "players")
public class Player extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String playerName;


    private String rank;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Score> scores;


}
