package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.CategorieDao;
import com.takima.backskeleton.models.Categorie;
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
