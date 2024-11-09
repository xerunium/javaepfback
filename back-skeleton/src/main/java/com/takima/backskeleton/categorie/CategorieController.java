package com.takima.backskeleton.categorie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/categories")
@RestController
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping("")
    public List<Categorie> findAll() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/search")
    public Categorie findCategorieByNomCategorie(@RequestParam String nomCategorie) {
        return categorieService.getCategorieByNomCategorie(nomCategorie);
    }
}
