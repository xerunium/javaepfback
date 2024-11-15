package com.takima.backskeleton.categorie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_generator")
    @SequenceGenerator(name = "categorie_generator", sequenceName = "categorie_seq", allocationSize = 1)
    private Long id;
    private String nomCategorie;
}
