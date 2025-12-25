package com.example.reservi.controllers;

import com.example.reservi.models.Chambre;
import com.example.reservi.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping
    public List<Chambre> getAll() {
        return chambreService.findAll();
    }

    @GetMapping("/{id}")
    public Chambre getById(@PathVariable Long id) {
        return chambreService.findById(id);
    }

    @PostMapping
    public Chambre create(@RequestBody Chambre chambre) {
        return chambreService.save(chambre);
    }

    @PutMapping("/{id}")
    public Chambre update(@PathVariable Long id, @RequestBody Chambre chambre) {
        chambre.setId(id);
        return chambreService.save(chambre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chambreService.delete(id);
    }
}
