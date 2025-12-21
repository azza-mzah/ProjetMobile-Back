package com.example.reservi.services;

import com.example.reservi.models.Hotel;
import java.util.List;

public interface HotelService {
    List<Hotel> findAll();
    Hotel findById(Long id);
    Hotel save(Hotel hotel);
    void delete(Long id);
}
