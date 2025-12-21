package com.example.reservi.services;

import com.example.reservi.models.Reservation;
import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();
    Reservation findById(Long id);
    Reservation save(Reservation reservation);
    void delete(Long id);
}
