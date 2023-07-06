package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject.PlayerResponseObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerRequestObject playerRequestObject) {

        return playerService.createPlayer(playerRequestObject);
    }
     @GetMapping("/{id}")
     public Player getSpecificPlayerById(@PathVariable("id") Long id) {
        return playerService.getSpecificPlayerById(id);
    }

//    @GetMapping("all")
//    public List<PlayerResponseObject> getAllPlayers() {
//        List<Player> listOfPlayers = playerService.getAllPlayers();
//        List<PlayerResponseObject> playerResponseList = PlayerResponseObject.convertRequestListToResponseList(listOfPlayers);
//        return playerResponseList;
//    }

  


}
