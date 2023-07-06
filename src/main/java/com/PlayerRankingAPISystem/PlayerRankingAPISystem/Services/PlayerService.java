package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.PlayerRepository;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PlayerService {


@Autowired
    PlayerRepository playerRepository;



    public ResponseEntity<Player> createPlayer(@RequestBody PlayerRequestObject playerRequestObject) {
        Player player = playerRequestObject.convert(playerRequestObject);
        playerRepository.save(player);
        return ResponseEntity.ok(player);
    }

//    public Player getPlayerById(Integer id) {
//        return playerRepository.getPlayerById(id);
//    }


    public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerRepository.findById(Math.toIntExact(id));
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }



}
