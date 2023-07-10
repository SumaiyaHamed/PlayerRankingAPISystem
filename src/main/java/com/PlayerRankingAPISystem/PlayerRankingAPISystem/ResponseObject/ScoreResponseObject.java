package com.PlayerRankingAPISystem.PlayerRankingAPISystem.ResponseObject;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Player;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Models.Score;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Builder
public class ScoreResponseObject {

    private Long id;

    private int scoreValue;

    public static ScoreResponseObject convertRequestToResponse(Score scoreRequestFromUser) {
        return ScoreResponseObject.builder()
                .id(scoreRequestFromUser.getId())
                .scoreValue(scoreRequestFromUser.getScoreValue())
                .build();
    }

    public static List<ScoreResponseObject> convertRequestListToResponseList(List<Score> scoreRequestFromUser) {
        List<ScoreResponseObject> scoreResponseList = new ArrayList<>();
        if (!scoreRequestFromUser.isEmpty()) {
            for (Score scoreRequest : scoreRequestFromUser) {
                scoreResponseList.add(convertRequestToResponse(scoreRequest));
            }
        }
        return scoreResponseList;
    }
}
