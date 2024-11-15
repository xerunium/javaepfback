package com.takima.backskeleton.categorie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private final CategorieDao categorieDao;

    public CategorieService(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }

    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    public Categorie getCategorieByNomCategorie(String nomCategorie) {
        return categorieDao.findCategorieByNomCategorie(nomCategorie);
    }

    public Categorie findById(Long categorieId) {
        return categorieDao.findCategorieById(categorieId);
    }

    public Categorie createCategorie(Categorie categorie) {
        categorieDao.save(categorie);
        return categorie;
    }

    public void updateCategorie(Long id, Categorie categoryDetails) {
        Optional<Categorie> categoryOptional = Optional.ofNullable(findById(id));

        if (categoryOptional.isPresent()) {
            Categorie category = categoryOptional.get();
            category.setNomCategorie(categoryDetails.getNomCategorie()); // Mise à jour des champs nécessaires

            // Sauvegarde de la catégorie mise à jour
            Categorie updatedCategory = createCategorie(category);
        }
    }
    public void deleteCategorie(Categorie categorie) {
        categorieDao.delete(categorie);
    }
}
