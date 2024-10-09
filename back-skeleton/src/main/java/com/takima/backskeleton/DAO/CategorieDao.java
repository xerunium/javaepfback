package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategorieDao extends JpaRepository<Categorie, Long> {
}
