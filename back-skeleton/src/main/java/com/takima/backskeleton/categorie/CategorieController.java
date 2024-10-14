package com.takima.backskeleton.categorie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/categorie")
@RestController
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieDao categorieDao;

    @GetMapping("")
    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }
}
