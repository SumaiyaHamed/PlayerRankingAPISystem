package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject.PlayerResponseObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("all")
    public List<PlayerResponseObject> getAllPlayers() {
        List<Player> listOfPlayers = playerService.getAllPlayers();
        List<PlayerResponseObject> playerResponseList = PlayerResponseObject.convertRequestListToResponseList(listOfPlayers);
        return playerResponseList;
    }

    @DeleteMapping(path = "{id}")
    public String deleteSpecificPlayerById(@PathVariable(name = "id") Long id) {
        try {
            playerService.deleteSpecificPlayerById(id);
        } catch (Exception e) {
            return "Deleting Failed Please Check The Id";
        }
        return " Customer Id " + id + " Deleted Successfully ";
    }
@PutMapping
    public void updatePlayerDetails(@RequestBody PlayerRequestObject playerRequestObject) {
        playerService.updatePlayerDetails(playerRequestObject);
    }


}
