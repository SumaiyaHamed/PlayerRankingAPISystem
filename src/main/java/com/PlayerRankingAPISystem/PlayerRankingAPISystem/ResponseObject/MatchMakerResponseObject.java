package com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.MatchMaker;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Builder
public class MatchMakerResponseObject {
    private boolean isAdmin;
    public static MatchMakerResponseObject convertRequestToResponse(MatchMaker MatchMakerRequestFromUser) {
        return MatchMakerResponseObject.builder()
                .isAdmin(MatchMakerRequestFromUser.isAdmin())
                .build();
    }

    public static List<MatchMakerResponseObject> convertRequestListToResponseList(List<MatchMaker> matchMakerRequestFromUser) {
        List<MatchMakerResponseObject> matchMakerResponseList = new ArrayList<>();
        if (!matchMakerResponseList.isEmpty()) {
            for (MatchMaker matchMakerRequest : matchMakerRequestFromUser) {
                matchMakerResponseList.add(convertRequestToResponse(matchMakerRequest));
            }
        }
        return matchMakerResponseList;
    }
}
