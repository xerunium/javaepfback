package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contenir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Choix choix;
    private boolean isAnswer;

    public Contenir(Choix choix, Question question, boolean isAnswer) {
        this.choix = choix;
        this.question = question;
        this.isAnswer = isAnswer;
    }
}
