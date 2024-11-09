package com.takima.backskeleton.categorie;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
