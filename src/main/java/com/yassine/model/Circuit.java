package com.yassine.model;

public class Circuit {

    // Attributs
    private int id;
    private String nom;
    private String destination;
    private int dureeJours;
    private double prixBase;

    // Constructeur
    public Circuit(int id, String nom, String destination,
                   int dureeJours, double prixBase) {

        this.id = id;
        this.nom = nom;
        this.destination = destination;
        this.dureeJours = dureeJours;
        this.prixBase = prixBase;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDestination() {
        return destination;
    }

    public int getDureeJours() {
        return dureeJours;
    }

    public double getPrixBase() {
        return prixBase;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDureeJours(int dureeJours) {
        this.dureeJours = dureeJours;
    }

    public void setPrixBase(double prixBase) {
        this.prixBase = prixBase;
    }

    // Afficher les informations
    public void afficherCircuit() {
        System.out.println("ID : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Destination : " + destination);
        System.out.println("Durée : " + dureeJours + " jours");
        System.out.println("Prix : " + prixBase + " DT");
    }
}
