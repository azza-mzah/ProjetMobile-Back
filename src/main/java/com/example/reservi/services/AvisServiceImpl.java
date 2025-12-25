package com.example.reservi.services;

import com.example.reservi.models.Avis;
import com.example.reservi.repositories.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvisServiceImpl implements AvisService {

    @Autowired
    private AvisRepository avisRepository;

    @Override
    public List<Avis> findAll() {
        return avisRepository.findAll();
    }

    @Override
    public Avis findById(Long id) {
        return avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec id " + id));
    }

    @Override
    public Avis save(Avis avis) {
        return avisRepository.save(avis);
    }

    @Override
    public void delete(Long id) {
        avisRepository.deleteById(id);
    }
}
