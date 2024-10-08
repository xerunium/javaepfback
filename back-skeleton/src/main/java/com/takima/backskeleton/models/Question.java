package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nb_choix;
    @OneToMany
    private List<Contenir> contenirs;

    public Question(int nb_choix, List<Contenir> contenirs) {
        this.nb_choix = nb_choix;
        this.contenirs = contenirs;
    }
}
