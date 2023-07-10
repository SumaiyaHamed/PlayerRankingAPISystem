package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query("select s from scores s where s.id = :scoreId")
    Score getScoreById(@Param("scoreId") Long id);
}
