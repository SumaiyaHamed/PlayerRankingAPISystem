package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {



}