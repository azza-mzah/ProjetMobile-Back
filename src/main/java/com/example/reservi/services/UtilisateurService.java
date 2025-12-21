package com.example.reservi.services;

import com.example.reservi.models.Utilisateur;
import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> findAll();
    Utilisateur findById(Long id);
    Utilisateur save(Utilisateur utilisateur);
    void delete(Long id);
}
