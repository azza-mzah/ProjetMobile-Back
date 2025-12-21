package com.example.reservi.controllers;

import com.example.reservi.models.Utilisateur;
import com.example.reservi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }

    @PostMapping("/register")
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurService.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }
}
