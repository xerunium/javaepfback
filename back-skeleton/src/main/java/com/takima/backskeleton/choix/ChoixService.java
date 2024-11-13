package com.takima.backskeleton.choix;

import com.takima.backskeleton.categorie.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChoixService {

    private final ChoixDao choixDao;

    public List<Choix> findAll() {
        return choixDao.findAll();
    }

    public Optional<Choix> findById(Long choix_id) {
        return choixDao.findById(choix_id);
    }

    public void deleteById(Long choix_id) {
        choixDao.deleteById(choix_id);
    }

    @Transactional
    public Choix updateChoix(Long id, Choix choixDetails) {
        Choix choix = choixDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Choix not found with id " + id));

        choix.setDescription(choixDetails.getDescription());
        choix.setImage(choixDetails.getImage());
        choix.setCategorie(choixDetails.getCategorie());
        return choix;
    }

    public void createChoix(Choix choixDetails) {
        choixDao.save(choixDetails);
    }
}
