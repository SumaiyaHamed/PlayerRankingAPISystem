package com.PlayerRankingAPISystem.PlayerRankingAPISystem.Controllers;

import com.PlayerRankingAPISystem.PlayerRankingAPISystem.RequestObject.MatchMarkerRequestObject;
import com.PlayerRankingAPISystem.PlayerRankingAPISystem.Services.MatchMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/match")
public class MatchMarkerController {
@Autowired
    private MatchMarkerService matchMarkerService;


//    public MatchController(MatchService matchService) {
//        this.matchService = matchService;
//    }

    @PostMapping("/check")
    public ResponseEntity<String> checkMatchValidity(@RequestBody MatchMarkerRequestObject request) {
        boolean isMatchValid = matchMarkerService.isMatchValid(request.getBlueTeam(), request.getRedTeam());

        if (isMatchValid) {
            return ResponseEntity.ok("Match is valid.");
        } else {
            return ResponseEntity.badRequest().body("Match is not valid.");
        }
    }
}
