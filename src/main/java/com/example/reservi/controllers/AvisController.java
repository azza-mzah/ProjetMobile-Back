package com.example.reservi.controllers;

import com.example.reservi.models.Avis;
import com.example.reservi.services.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;

    @GetMapping
    public List<Avis> getAll() {
        return avisService.findAll();
    }

    @GetMapping("/{id}")
    public Avis getById(@PathVariable Long id) {
        return avisService.findById(id);
    }

    @PostMapping
    public Avis create(@RequestBody Avis avis) {
        return avisService.save(avis);
    }

    @PutMapping("/{id}")
    public Avis update(@PathVariable Long id, @RequestBody Avis avis) {
        avis.setId(id);
        return avisService.save(avis);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avisService.delete(id);
    }
}
