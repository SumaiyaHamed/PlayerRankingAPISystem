package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services;

import org.springframework.stereotype.Service;

@Service
public class RankService {

    public String determineRank(double averageScore) {
        if (averageScore >= 0 && averageScore < 10) {
            return "Iron";
        } else if (averageScore >= 10 && averageScore < 20) {
            return "Bronze";
        } else if (averageScore >= 20 && averageScore < 30) {
            return "Silver";
        } else if (averageScore >= 30 && averageScore < 40) {
            return "Gold";
        } else if (averageScore >= 40 && averageScore < 50) {
            return "Platinum";
        } else if (averageScore == 50) {
            return "Immortal";
        } else {
            return "Invalid score range";
        }
    }
}
