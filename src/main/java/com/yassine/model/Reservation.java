package com.yassine.model;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private List<Option> options;
    private String saison;

    // Attributs
    private int id;
    private Client client;
    private Circuit circuit;
    private String dateReservation;
    private int nombrePersonnes;
    private double prixTotal;

    // Constructeur

    public Reservation(int id, Client client, Circuit circuit,
                       String dateReservation, int nombrePersonnes,
                       String saison) {

        this.id = id;
        this.client = client;
        this.circuit = circuit;
        this.dateReservation = dateReservation;
        this.nombrePersonnes = nombrePersonnes;
        this.saison = saison;

        this.options = new ArrayList<>();

        this.prixTotal = 0;
    }

    public void ajouterOption(Option option) {
        options.add(option);
    }


    public double calculerPrix() {

        double prix = circuit.getPrixBase() * nombrePersonnes;

        // Supplément haute saison
        if (saison.equalsIgnoreCase("haute")) {
            double supplement = prix * 0.20;
            prix = prix + supplement;
        }

        // Ajouter les options
        for (Option option : options) {
            prix += option.getPrix() * nombrePersonnes;
        }

        this.prixTotal = prix;

        return prixTotal;
    }

    // Afficher la réservation
    public void afficherReservation() {

        System.out.println("\n===== DETAILS RESERVATION =====");

        System.out.println("Numero : " + id);
        System.out.println("Client : " + client.getNom());
        System.out.println("Circuit : " + circuit.getNom());
        System.out.println("Date : " + dateReservation);
        System.out.println("Nombre de personnes : " + nombrePersonnes);
        System.out.println("Saison : " + saison);

        System.out.println("\nOptions choisies :");

        if (options.isEmpty()) {
            System.out.println("Aucune option");
        } else {
            for (Option option : options) {
                option.afficherOption();
            }
        }

        System.out.println("\nPrix total : " + calculerPrix() + " DT");
    }


    // Getters
    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

}
