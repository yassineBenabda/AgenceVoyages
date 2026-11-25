package com.yassine.service;

import com.yassine.model.Circuit;
import com.yassine.model.Client;
import com.yassine.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class AgenceService {

    // Listes de stockage
    private List<Circuit> circuits;
    private List<Client> clients;
    private List<Reservation> reservations;

    // Constructeur
    public AgenceService() {
        circuits = new ArrayList<>();
        clients = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Ajouter un circuit
    public void ajouterCircuit(Circuit circuit) {
        circuits.add(circuit);
        System.out.println("Circuit ajouté avec succès !");
    }

    // Afficher les circuits
    public void afficherCircuits() {

        System.out.println("\n===== LISTE DES CIRCUITS =====");

        if (circuits.isEmpty()) {
            System.out.println("Aucun circuit disponible.");
            return;
        }

        for (Circuit circuit : circuits) {
            circuit.afficherCircuit();
            System.out.println("--------------------");
        }
    }

    // Ajouter un client
    public void ajouterClient(Client client) {
        clients.add(client);
        System.out.println("Client ajouté avec succès !");
    }

    // Afficher les clients
    public void afficherClients() {

        System.out.println("\n===== LISTE DES CLIENTS =====");

        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return;
        }

        for (Client client : clients) {
            client.afficherClient();
            System.out.println("--------------------");
        }
    }

    // Ajouter une réservation
    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Réservation effectuée avec succès !");
    }

    // Afficher les réservations
    public void afficherReservations() {

        System.out.println("\n===== LISTE DES RESERVATIONS =====");

        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation.");
            return;
        }

        for (Reservation reservation : reservations) {
            reservation.afficherReservation();
        }
    }

    // Getters pour consulter les listes
    public List<Circuit> getCircuits() {
        return circuits;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}

