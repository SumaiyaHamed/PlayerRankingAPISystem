package com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Data
public class MatchMarkerRequestObject {

    private List<Player> blueTeam;
    private List<Player> redTeam;

    public MatchMarkerRequestObject(List<Player> blueTeam, List<Player> redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;
    }
}
