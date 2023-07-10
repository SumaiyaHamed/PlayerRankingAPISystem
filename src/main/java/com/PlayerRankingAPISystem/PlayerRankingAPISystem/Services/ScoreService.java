package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.ScoreRepository;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.ScoreRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    CopyOnWriteArrayList<Score> listOfScores = new CopyOnWriteArrayList<>();

    public ResponseEntity<Score> AddScore(ScoreRequestObject scoreRequestObject) {
        Score score = scoreRequestObject.convert(scoreRequestObject);
        listOfScores.add(score);
        scoreRepository.save(score);
        return ResponseEntity.ok(score);
    }
}
