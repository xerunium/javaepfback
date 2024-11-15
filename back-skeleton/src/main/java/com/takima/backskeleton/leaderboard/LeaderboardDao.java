package com.takima.backskeleton.leaderboard;

import jakarta.persistence.EntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderboardDao extends CrudRepository<Leaderboard, Long> {
    @Query("SELECT l FROM Leaderboard l ORDER BY l.score DESC, l.temps ASC")
    List<Leaderboard> findTop10Leaderboard(PageRequest pageRequest);
}
