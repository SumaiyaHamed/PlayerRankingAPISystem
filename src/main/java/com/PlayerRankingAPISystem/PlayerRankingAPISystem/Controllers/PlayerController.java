package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.PlayerRepository;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject.PlayerResponseObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/players/{id}")
//    public PlayerResponseObject getPlayerById(@RequestParam Integer id) {
//        Player customer = playerService.getPlayerById(id);
//        PlayerResponseObject customerResponse = PlayerResponseObject.convertRequestToResponse(customer);
//        return customerResponse;
//    }

    public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable Long id) {

        return playerService.getPlayerById(id);
    }
}
