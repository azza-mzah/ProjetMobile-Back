package com.example.reservi.services;

import com.example.reservi.models.Hotel;
import com.example.reservi.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel non trouvé avec id " + id));
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
