package com.example.reservi.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "chambre")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String type; // Simple, Double, Suite…

    @Column(nullable = false)
    private Double prixParNuit;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private Integer nombrePersonnes;

    @Column(length = 20)
    private String statut = "DISPONIBLE"; // DISPONIBLE / OCCUPÉE

    @Column(length = 255)
    private String imageUrl;

    // Relation avec l'hôtel
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    // Relation avec les réservations
    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Constructeurs
    public Chambre() {}

    public Chambre(String type, Double prixParNuit, Integer nombrePersonnes, Hotel hotel) {
        this.type = type;
        this.prixParNuit = prixParNuit;
        this.nombrePersonnes = nombrePersonnes;
        this.hotel = hotel;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(Double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNombrePersonnes() {
        return nombrePersonnes;
    }

    public void setNombrePersonnes(Integer nombrePersonnes) {
        this.nombrePersonnes = nombrePersonnes;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
