package com.yassine;

import com.yassine.model.Circuit;
import com.yassine.model.Client;
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

                    System.out.print("Duree en jours : ");
                    int duree = Integer.parseInt(scanner.nextLine());

                    System.out.print("Prix de base (DT) : ");
                    double prix = Double.parseDouble(scanner.nextLine());

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
                    System.out.println("Fonctionnalite : effectuer une reservation");
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
}

