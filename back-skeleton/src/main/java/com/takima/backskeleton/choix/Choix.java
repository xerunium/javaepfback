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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String description;
    @ManyToOne
    private Categorie categorie;
}
