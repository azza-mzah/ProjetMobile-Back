package com.example.reservi.services;

import com.example.reservi.models.Avis;
import java.util.List;

public interface AvisService {
    List<Avis> findAll();
    Avis findById(Long id);
    Avis save(Avis avis);
    void delete(Long id);
}
