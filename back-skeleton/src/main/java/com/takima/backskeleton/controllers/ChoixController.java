package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.CategorieDao;
import com.takima.backskeleton.DAO.ChoixDao;
import com.takima.backskeleton.models.Categorie;
import com.takima.backskeleton.models.Choix;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/choix")
@RestController
@RequiredArgsConstructor
public class ChoixController {

    private final ChoixDao choixDao;

    @GetMapping("")
    public List<Choix> findAll() {
        return choixDao.findAll();
    }
}
