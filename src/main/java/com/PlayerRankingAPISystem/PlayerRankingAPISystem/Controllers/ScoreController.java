package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.ScoreRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject.ScoreResponseObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
