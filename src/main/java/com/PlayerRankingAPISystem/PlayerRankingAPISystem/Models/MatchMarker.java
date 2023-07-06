package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models;

//import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "matchMarker")
public class MatchMarker extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    private boolean isAdmin;

}
