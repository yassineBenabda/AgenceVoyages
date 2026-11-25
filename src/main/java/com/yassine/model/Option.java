package com.yassine.model;

public class Option {

    private int id;
    private String nom;
    private double prix;

    // Constructeur
    public Option(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    // Afficher une option
    public void afficherOption() {
        System.out.println(
                id + ". " + nom + " : " + prix + " DT"
        );
    }
}
