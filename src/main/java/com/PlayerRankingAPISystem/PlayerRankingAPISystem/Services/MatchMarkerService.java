package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchMarkerService {

    @Autowired
    ScoreService scoreService;

    @Autowired
    PlayerRepository playerRepository;

    public boolean isMatchValid(List<Player> blueTeam, List<Player> redTeam) {
        double blueAverage = scoreService.calculateAverageScoreForAllPlayersOnTeam(blueTeam);
        double redAverage = scoreService.calculateAverageScoreForAllPlayersOnTeam(redTeam);

        return Math.abs(blueAverage - redAverage) < 5;
    }



}
