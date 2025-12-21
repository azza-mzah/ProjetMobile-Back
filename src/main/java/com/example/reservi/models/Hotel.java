package com.example.reservi.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String adresse;

    @Column(length = 50)
    private String ville;

    @Column
    private Integer etoiles; // 1 à 5

    @Column(name = "prix_moyen")
    private Double prixMoyen;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "date_creation")
    private java.time.LocalDateTime dateCreation = java.time.LocalDateTime.now();

    // Relation avec les chambres
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Chambre> chambres;

    // Relation avec les avis
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Avis> avis;

    // Constructeurs
    public Hotel() {}

    public Hotel(String nom, String ville, Integer etoiles, Double prixMoyen) {
        this.nom = nom;
        this.ville = ville;
        this.etoiles = etoiles;
        this.prixMoyen = prixMoyen;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(Integer etoiles) {
        this.etoiles = etoiles;
    }

    public Double getPrixMoyen() {
        return prixMoyen;
    }

    public void setPrixMoyen(Double prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public java.time.LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(java.time.LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }
}
