package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Categorie;
import com.takima.backskeleton.models.Choix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChoixDao extends JpaRepository<Choix, Long> {

    @Query("SELECT c FROM Choix c WHERE c.categorie = :categorie AND c.id != :choixId ORDER BY function('RAND')")
    List<Choix> findIncorrectChoixByCategorie(@Param("categorie") Categorie categorie,
                                              @Param("choixId") Long choixId);

    Optional<Choix> findByDescription(String description);

    Optional<Choix> findByImage(byte[] image);
}
