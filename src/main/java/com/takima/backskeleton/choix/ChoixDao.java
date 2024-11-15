package com.takima.backskeleton.choix;

import com.takima.backskeleton.categorie.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChoixDao extends JpaRepository<Choix, Long> {

    @Query("SELECT c FROM Choix c WHERE c.categorie = :categorie AND c.id != :choixId ORDER BY FUNCTION('RANDOM') LIMIT :nbrChoix")
    List<Choix> findIncorrectChoixByCategorie(@Param("categorie") Categorie categorie,
                                              @Param("choixId") Long choixId,
                                              @Param("nbrChoix") int nbrChoix);

    Optional<Choix> findByDescription(String description);

    Optional<Choix> findByImage(String image);
}
