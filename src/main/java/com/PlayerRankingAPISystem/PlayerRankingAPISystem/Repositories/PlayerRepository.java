package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Repositories;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from players p where p.id = :playerId")
    Player getPlayerById(@Param("playerId") Long id);

//    @Query("SELECT AVG(s.score_value) FROM scores s WHERE s.player_id = :id")
//    double getAvarageScore(@Param("id") Long id);


}
