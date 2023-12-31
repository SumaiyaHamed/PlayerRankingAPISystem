package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.ScoreRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject.ScoreResponseObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/scores")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> AddScore(@RequestBody ScoreRequestObject scoreRequestObject) {
        return scoreService.AddScore(scoreRequestObject);
    }
@GetMapping("/{id}")
    public Score getSpecificScoreById(Long id) {
        return scoreService.getSpecificScoreById(id);
    }

    @GetMapping("all")
    public List<ScoreResponseObject> getAllScores() {
        List<Score> listOfScores = scoreService.getAllScores();
        List<ScoreResponseObject> scoreResponseList = ScoreResponseObject.convertRequestListToResponseList(listOfScores);
        return scoreResponseList;
    }

    @DeleteMapping(path = "{id}")
    public String deleteSpecificScoreById(@PathVariable(name = "id") Long id) {
        try {
            scoreService.deleteSpecificScoreById(id);
        } catch (Exception e) {
            return "Deleting Failed Please Check The Id";
        }
        return " Score Id " + id + " Deleted Successfully ";
    }

    @PutMapping
    public void updateScoreDetails(@RequestBody ScoreRequestObject scoreRequestObject) {
        scoreService.updateScoreDetails(scoreRequestObject);
    }
@GetMapping(path = "getPlayerAverageScore/{playerId}")
    public Integer calculateAverageScore(@PathVariable(name = "playerId")Integer playerId) {
        return scoreService.calculateAverageScore(playerId.longValue()).intValue();
    }
    @GetMapping(path = "getPlayers")
    public Map<Long, Double> calculateAverageScoreForAllPlayers(@RequestBody List<Long> playerIds){
//        Map<Long, Double> avgScoreMap = new HashMap<>();
        return scoreService.calculateAverageScoreForAllPlayers(playerIds);
    }
}
