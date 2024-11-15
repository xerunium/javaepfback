package com.takima.backskeleton.leaderboard;

import io.swagger.models.auth.In;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Un objet Leaderboard correspond à une entrée du leaderboard et pas
 * le leaderboard entier
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private Integer score;
    private Integer temps;

    public Leaderboard(String username, Integer score, Integer temps) {
        this.username = username;
        this.score = score;
        this.temps = temps;
    }
}
