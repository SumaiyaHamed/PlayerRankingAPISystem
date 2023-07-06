package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.PlayerRepository;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class PlayerService {


@Autowired
    PlayerRepository playerRepository;



    public ResponseEntity<Player> createPlayer(@RequestBody PlayerRequestObject playerRequestObject) {
        Player player = playerRequestObject.convert(playerRequestObject);
        playerRepository.save(player);
        return ResponseEntity.ok(player);
    }

}
