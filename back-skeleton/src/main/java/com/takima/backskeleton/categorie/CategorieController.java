package com.takima.backskeleton.categorie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{id}")
    public Categorie findCategorieById(@PathVariable Long id) {
        return categorieService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(categorieService.findById(id));
    }

    // Méthode pour mettre à jour une catégorie par ID
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Categorie categoryDetails) {
        categorieService.updateCategorie(id, categoryDetails);
    }

    @PostMapping("")
    public void createCategory(@RequestBody Categorie categoryDetails) {
        categorieService.createCategorie(categoryDetails);
    }
}
