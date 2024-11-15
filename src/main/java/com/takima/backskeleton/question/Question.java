package com.takima.backskeleton.question;

import com.takima.backskeleton.contenir.Contenir;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "qu")
    private Long id;
    private int nb_choix;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Contenir> contenirs;

    public Question(int nb_choix, List<Contenir> contenirs) {
        this.nb_choix = nb_choix;
        this.contenirs = contenirs;
    }
}
