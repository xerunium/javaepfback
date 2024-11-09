package com.takima.backskeleton.categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long> {

    public Categorie findCategorieByNomCategorie(String name);

}
