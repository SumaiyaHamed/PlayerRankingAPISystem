package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.PlayerRepository;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PlayerService {


@Autowired
    PlayerRepository playerRepository;

    CopyOnWriteArrayList<Player> listOfStudents= new CopyOnWriteArrayList<>();

    public ResponseEntity<Player> createPlayer(@RequestBody PlayerRequestObject playerRequestObject) {
        Player player = playerRequestObject.convert(playerRequestObject);
        listOfStudents.add(player);
        playerRepository.save(player);
        return ResponseEntity.ok(player);
    }


    public Player getSpecificPlayerById(Long id) {

        Player foundPlayer= null;
        Optional<Player>optionalPlayer =playerRepository.findById(id);
        if (optionalPlayer.isPresent()){
            foundPlayer=optionalPlayer.get();
        }
        return foundPlayer;
    }


//    public List<Player> getAllPlayers() {
//        return playerRepository.getAllPlayers();
//    }


    public String deletePlayerById(Long id) {
        Player player = playerRepository.getPlayerById(id);
        player.setIsActive(false);
        playerRepository.save(player);
        return "Player Id " + id + "Deleted Successfully ";
    }


}
