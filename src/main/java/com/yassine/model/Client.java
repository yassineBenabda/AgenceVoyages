package com.yassine.model;

public class Client {

    // Attributs
    private int id;
    private String nom;
    private String email;
    private String telephone;

    // Constructeur
    public Client(int id, String nom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Afficher les informations
    public void afficherClient() {
        System.out.println("ID Client : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Email : " + email);
        System.out.println("Téléphone : " + telephone);
    }
}

