package com.takima.backskeleton.leaderboard;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("leaderboard")
@RestController
@RequiredArgsConstructor
public class LeaderboardController {
    private LeaderboardService leaderboardService;

    @Autowired
    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @PostMapping("/save")
    public void saveLeaderboard(@RequestBody Leaderboard leaderboard) {
        leaderboardService.createLeaderboardLine(leaderboard);
    }

    @GetMapping("/get")
    public List<Leaderboard> get10Leaderboard() {
        return leaderboardService.getLeaderboard();
    }
}
