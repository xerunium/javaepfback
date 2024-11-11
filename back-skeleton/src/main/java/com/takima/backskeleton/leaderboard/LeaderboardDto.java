package com.takima.backskeleton.leaderboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaderboardDto {
    private String username;
    private int score;
    private int temps;
}
