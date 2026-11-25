package com.yassine;


import com.yassine.model.Circuit;
import com.yassine.model.Client;
import com.yassine.model.Option;
import com.yassine.model.Reservation;
import com.yassine.service.AgenceService;

public class Main {

    public static void main(String[] args) {

        // Créer le service
        AgenceService agence = new AgenceService();

        // Créer les circuits
        Circuit circuit1 = new Circuit(
                1, "Decouverte de Djerba",
                "Djerba", 5, 800
        );

        // Créer le client
        Client client1 = new Client(
                1, "Ahmed Ben Ali",
                "ahmed@gmail.com", "22123456"
        );

        // Ajouter les données à l'agence
        agence.ajouterCircuit(circuit1);
        agence.ajouterClient(client1);

        // Créer les options
        Option guide = new Option(1, "Guide touristique", 100);
        Option repas = new Option(2, "Repas", 50);
        Option excursion = new Option(3, "Excursion", 80);

        // Créer une réservation
        Reservation reservation1 = new Reservation(
                1, client1, circuit1,
                "25/11/2026", 2, "haute"
        );

        // Ajouter les options
        reservation1.ajouterOption(guide);
        reservation1.ajouterOption(repas);
        reservation1.ajouterOption(excursion);

        // Enregistrer la réservation
        agence.ajouterReservation(reservation1);

        // Afficher les informations
        agence.afficherCircuits();
        agence.afficherClients();
        agence.afficherReservations();
    }
}

