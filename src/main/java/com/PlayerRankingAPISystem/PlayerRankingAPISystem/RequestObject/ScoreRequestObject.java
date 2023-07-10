package com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class ScoreRequestObject {

    private Long id;

    private int scoreValue;


    public static Score convert(ScoreRequestObject request) {

        Score score = new Score();

        score.setScoreValue(request.getScoreValue());
        score.setIsActive(true);
        score.setCreatedDate(new Date());
        return score;
    }

    public static List<Score> convertAll(List<ScoreRequestObject> requestList) {
        List<Score> scores = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (ScoreRequestObject scoreRequest : requestList) {
                scores.add(convert (scoreRequest));
            }
        }
        return scores;


    }
}
