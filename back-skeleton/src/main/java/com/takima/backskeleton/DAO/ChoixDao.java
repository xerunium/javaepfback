package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Choix;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChoixDao extends CrudRepository<Choix, Long> {
    Optional<Choix> findByImage(byte[] image);
}
