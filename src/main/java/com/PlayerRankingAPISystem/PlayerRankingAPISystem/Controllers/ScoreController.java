package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.ScoreRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/scores")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> AddScore(@RequestBody ScoreRequestObject scoreRequestObject) {
        return scoreService.AddScore(scoreRequestObject);
    }

    
}
