package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.ChoixDao;
import com.takima.backskeleton.models.Choix;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id_choix}")
    public Optional<Choix> findById(@PathVariable Long id_choix) {
        return choixDao.findById(id_choix);
    }
}
