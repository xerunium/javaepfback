package com.takima.backskeleton.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    private LeaderboardDao leaderboardDao;

    @Autowired
    public LeaderboardService(LeaderboardDao leaderboardDao) {
        this.leaderboardDao = leaderboardDao;
    }

    public void createLeaderboardLine(Leaderboard leaderboard) {
        leaderboardDao.save(leaderboard);
    }

    public List<Leaderboard> getLeaderboard() {
        PageRequest pageRequest = PageRequest.of(0, 10,
                Sort.by(Sort.Order.desc("score"), Sort.Order.asc("temps")));
        return leaderboardDao.findTop10Leaderboard(pageRequest);
    }

}
