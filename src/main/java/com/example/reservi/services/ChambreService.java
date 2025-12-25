package com.example.reservi.services;

import com.example.reservi.models.Chambre;
import java.util.List;

public interface ChambreService {
    List<Chambre> findAll();
    Chambre findById(Long id);
    Chambre save(Chambre chambre);
    void delete(Long id);
}
