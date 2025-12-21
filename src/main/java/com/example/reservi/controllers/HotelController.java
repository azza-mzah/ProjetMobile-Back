package com.example.reservi.controllers;

import com.example.reservi.models.Hotel;
import com.example.reservi.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @PutMapping("/{id}")
    public Hotel update(@PathVariable Long id, @RequestBody Hotel hotel) {
        hotel.setId(id);
        return hotelService.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }
}
