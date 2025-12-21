package com.example.reservi.services;

import com.example.reservi.models.Utilisateur;
import com.example.reservi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec id " + id));
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {

        if (utilisateur.getMdp() != null && !utilisateur.getMdp().isEmpty()) {
            utilisateur.setMdp(passwordEncoder.encode(utilisateur.getMdp()));
        }


        if (utilisateur.getRole() == null) {
            utilisateur.setRole(Utilisateur.Role.CLIENT);
        }
        if (utilisateur.getStatus() == null) {
            utilisateur.setStatus(Utilisateur.Status.ACTIF);
        }

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
