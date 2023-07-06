package com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class PlayerRequestObject {

    private Long id;

    private String playerName;


    public static Player convert(PlayerRequestObject request) {

        Player player = new Player();

        player.setPlayerName(request.getPlayerName());
        player.setIsActive(true);
        player.setCreatedDate(new Date());
        return player;
    }

    public static List<Player> convert(List<PlayerRequestObject> requestList) {
        List<Player> players = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (PlayerRequestObject playerRequest : requestList) {
                players.add(convert (playerRequest));
            }
        }
        return players;


    }
}
