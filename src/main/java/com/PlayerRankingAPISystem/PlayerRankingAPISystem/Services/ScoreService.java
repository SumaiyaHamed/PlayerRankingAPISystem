package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.ScoreRepository;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.PlayerRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.ScoreRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public Score getSpecificScoreById(Long id) {
        Score foundScore= null;
        Optional<Score> optionalScore =scoreRepository.findById(id);
        if (optionalScore.isPresent()){
            foundScore=optionalScore.get();
        }
        return foundScore;
    }


    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public String deleteSpecificScoreById(Long id) {
        Score score = scoreRepository.getScoreById(id);
        score.setIsActive(false);
        scoreRepository.save(score);
        return "Score Id " + id + "Deleted Successfully ";
    }

    public void updateScoreDetails(ScoreRequestObject scoreRequestObject) {
        Score score = scoreRepository.getScoreById(scoreRequestObject.getId());
        score.setScoreValue(scoreRequestObject.getScoreValue());
        score.setUpdatedDate(new Date());
        scoreRepository.save(score);
    }
}
