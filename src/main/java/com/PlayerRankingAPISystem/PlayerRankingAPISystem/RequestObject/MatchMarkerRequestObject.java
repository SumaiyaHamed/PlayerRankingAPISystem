package com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.MatchMaker;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@Data
public class MatchMarkerRequestObject {
    private boolean isAdmin;
    private List<Player> blueTeam;
    private List<Player> redTeam;

    public MatchMarkerRequestObject(List<Player> blueTeam, List<Player> redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;
    }

    public static MatchMaker convert(MatchMarkerRequestObject request) {

        MatchMaker matchMaker = new MatchMaker();

        matchMaker.setAdmin(request.isAdmin);
        matchMaker.setIsActive(true);
        matchMaker.setCreatedDate(new Date());
        return matchMaker;
    }

    public static List<MatchMaker> convertAll(List<MatchMarkerRequestObject> requestList) {
        List<MatchMaker> matchMakers = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (MatchMarkerRequestObject matchMakerRequest : requestList) {
                matchMakers.add(convert (matchMakerRequest));
            }
        }
        return matchMakers;


    }
}
