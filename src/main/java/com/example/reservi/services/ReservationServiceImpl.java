package com.example.reservi.services;

import com.example.reservi.models.Chambre;
import com.example.reservi.models.Reservation;
import com.example.reservi.repositories.ChambreRepository;
import com.example.reservi.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation non trouvée avec id " + id));
    }

    @Override
    public Reservation save(Reservation reservation) {
        // Vérifier que la chambre existe
        Chambre chambre = chambreRepository.findById(reservation.getChambre().getId())
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée"));

        // Calcul du montant total
        long jours = reservation.getDateFin().toEpochDay() - reservation.getDateDebut().toEpochDay();
        if (jours <= 0) {
            throw new RuntimeException("Dates invalides");
        }
        reservation.setMontantTotal(jours * chambre.getPrixParNuit());


        // Optionnel : vérifier disponibilité
        boolean disponible = reservationRepository.findAll().stream()
                .filter(r -> r.getChambre().getId().equals(chambre.getId()))
                .noneMatch(r -> !(reservation.getDateFin().isBefore(r.getDateDebut()) || reservation.getDateDebut().isAfter(r.getDateFin())));
        if (!disponible) {
            throw new RuntimeException("Chambre non disponible pour ces dates");
        }

        reservation.setStatut("EN_ATTENTE");
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
