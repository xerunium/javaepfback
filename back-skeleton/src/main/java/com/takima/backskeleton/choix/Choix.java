package com.takima.backskeleton.choix;

import com.takima.backskeleton.categorie.Categorie;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "choix_generator")
    @SequenceGenerator(name = "choix_generator", sequenceName = "choix_seq", allocationSize = 1)
    private Long id;
    private String image;
    private String description;
    @ManyToOne
    private Categorie categorie;
}
