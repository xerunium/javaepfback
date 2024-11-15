package com.takima.backskeleton.choix;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/choix")
@RestController
@RequiredArgsConstructor
public class ChoixController {

    private final ChoixService choixService;

    @GetMapping("")
    public List<Choix> findAll() {
        return choixService.findAll();
    }

    @GetMapping("/{id_choix}")
    public Optional<Choix> findById(@PathVariable Long id_choix) {
        return choixService.findById(id_choix);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        choixService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Choix> updateChoix(@PathVariable Long id, @RequestBody Choix choixDetails) {
        Choix updatedChoix = choixService.updateChoix(id, choixDetails);
        return ResponseEntity.ok(updatedChoix);
    }

    @PostMapping("")
    public void createChoix(@RequestBody Choix choixDetails) {
        choixService.createChoix(choixDetails);
    }
}
