package com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject;

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
public class PlayerResponseObject {



    private Long id;

    private String playerName;



    public static PlayerResponseObject convertRequestToResponse(Player playerRequestFromUser) {
        return PlayerResponseObject.builder()
                .id(playerRequestFromUser.getId())
                .playerName(playerRequestFromUser.getPlayerName())
                .build();
    }

    public static List<PlayerResponseObject> convertRequestListToResponseList(List<Player> playerRequestFromUser) {
        List<PlayerResponseObject> playerResponseList = new ArrayList<>();
        if (!playerRequestFromUser.isEmpty()) {
            for (Player playerRequest : playerRequestFromUser) {
                playerResponseList.add(convertRequestToResponse(playerRequest));
            }
        }
        return playerResponseList;
    }
}
