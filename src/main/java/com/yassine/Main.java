package com.yassine;

import com.yassine.model.Circuit;
import com.yassine.model.Client;
import com.yassine.model.Option;
import com.yassine.model.Reservation;
import com.yassine.service.AgenceService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AgenceService agence = new AgenceService();

        int choix;

        do {
            System.out.println("\n===== AGENCE DE VOYAGES =====");
            System.out.println("1. Ajouter un circuit");
            System.out.println("2. Afficher les circuits");
            System.out.println("3. Ajouter un client");
            System.out.println("4. Afficher les clients");
            System.out.println("5. Effectuer une reservation");
            System.out.println("6. Afficher les reservations");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");

            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {

                case 1:
                    System.out.println("\n--- AJOUTER UN CIRCUIT ---");

                    System.out.print("ID du circuit : ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nom du circuit : ");
                    String nom = scanner.nextLine();

                    System.out.print("Destination : ");
                    String destination = scanner.nextLine();

                    int duree;

                    do {
                        System.out.print("Duree en jours : ");
                        duree = Integer.parseInt(scanner.nextLine());

                        if (duree <= 0) {
                            System.out.println("La duree doit etre superieure a 0 !");
                        }

                    } while (duree <= 0);

                    System.out.print("Prix de base (DT) : ");
                    double prix;

                    do {
                        System.out.print("Prix de base (DT) : ");
                        prix = Double.parseDouble(scanner.nextLine());

                        if (prix <= 0) {
                            System.out.println("Le prix doit etre superieur a 0 !");
                        }

                    } while (prix <= 0);

                    Circuit circuit = new Circuit(
                            id, nom, destination, duree, prix
                    );

                    agence.ajouterCircuit(circuit);

                    System.out.println("Circuit ajoute avec succes !");
                    break;

                case 2:
                    agence.afficherCircuits();
                    break;

                case 3:
                    System.out.println("\n--- AJOUTER UN CLIENT ---");

                    System.out.print("ID du client : ");
                    int idClient = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nom du client : ");
                    String nomClient = scanner.nextLine();

                    System.out.print("Email : ");
                    String email = scanner.nextLine();

                    System.out.print("Telephone : ");
                    String telephone = scanner.nextLine();

                    Client client = new Client(
                            idClient, nomClient, email, telephone
                    );

                    agence.ajouterClient(client);

                    System.out.println("Client ajoute avec succes !");
                    break;

                case 4:
                    agence.afficherClients();
                    break;


                case 5:
                    System.out.println("\n--- EFFECTUER UNE RESERVATION ---");

                    if (agence.getClients().isEmpty() ||
                            agence.getCircuits().isEmpty()) {

                        System.out.println(
                                "Il faut ajouter au moins un client et un circuit."
                        );
                        break;
                    }

                    agence.afficherClients();

                    System.out.print("ID du client : ");
                    int idC = Integer.parseInt(scanner.nextLine());

                    Client clientChoisi = null;

                    for (Client c : agence.getClients()) {
                        if (c.getId() == idC) {
                            clientChoisi = c;
                            break;
                        }
                    }

                    if (clientChoisi == null) {
                        System.out.println("Client introuvable !");
                        break;
                    }

                    agence.afficherCircuits();

                    System.out.print("ID du circuit : ");
                    int idCircuit = Integer.parseInt(scanner.nextLine());

                    Circuit circuitChoisi = null;

                    for (Circuit c : agence.getCircuits()) {
                        if (c.getId() == idCircuit) {
                            circuitChoisi = c;
                            break;
                        }
                    }

                    if (circuitChoisi == null) {
                        System.out.println("Circuit introuvable !");
                        break;
                    }

                    System.out.print("Date de reservation : ");
                    String date = scanner.nextLine();

                    System.out.print("Nombre de personnes : ");
                    int nombrePersonnes;

                    do {
                        System.out.print("Nombre de personnes : ");
                        nombrePersonnes = Integer.parseInt(scanner.nextLine());

                        if (nombrePersonnes <= 0) {
                            System.out.println("Erreur : le nombre doit etre superieur a 0 !");
                        }

                    } while (nombrePersonnes <= 0);

                    String saison;

                    do {
                        System.out.print("Saison (haute ou basse) : ");
                        saison = scanner.nextLine().toLowerCase();

                        if (!saison.equals("haute") && !saison.equals("basse")) {
                            System.out.println("Erreur : choisissez haute ou basse !");
                        }

                    } while (!saison.equals("haute") && !saison.equals("basse"));

                    int idReservation = agence.getReservations().size() + 1;

                    Reservation reservation = new Reservation(
                            idReservation,
                            clientChoisi,
                            circuitChoisi,
                            date,
                            nombrePersonnes,
                            saison
                    );

                    ajouterOptions(reservation, scanner);

                    agence.ajouterReservation(reservation);

                    System.out.println("Reservation effectuee avec succes !");
                    reservation.afficherReservation();

                    break;


                case 6:
                    agence.afficherReservations();
                    break;

                case 7:
                    System.out.println("Merci d'avoir utilise notre application !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 7);

        scanner.close();
    }


    private static void ajouterOptions(
            Reservation reservation,
            Scanner scanner) {

        Option guide = new Option(1, "Guide touristique", 100);
        Option repas = new Option(2, "Repas", 50);
        Option excursion = new Option(3, "Excursion", 80);

        int choixOption;

        do {
            System.out.println("\n--- OPTIONS DISPONIBLES ---");
            System.out.println("1. Guide touristique (100 DT)");
            System.out.println("2. Repas (50 DT)");
            System.out.println("3. Excursion (80 DT)");
            System.out.println("0. Terminer les options");

            System.out.print("Votre choix : ");
            choixOption = Integer.parseInt(scanner.nextLine());

            switch (choixOption) {
                case 1:
                    reservation.ajouterOption(guide);
                    System.out.println("Guide ajoute !");
                    break;

                case 2:
                    reservation.ajouterOption(repas);
                    System.out.println("Repas ajoute !");
                    break;

                case 3:
                    reservation.ajouterOption(excursion);
                    System.out.println("Excursion ajoute !");
                    break;

                case 0:
                    System.out.println("Selection des options terminee.");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choixOption != 0);
    }

}

