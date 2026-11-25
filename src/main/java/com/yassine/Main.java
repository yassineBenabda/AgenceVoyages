package com.yassine;

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
                    System.out.println("Fonctionnalite : ajouter un circuit");
                    break;

                case 2:
                    agence.afficherCircuits();
                    break;

                case 3:
                    System.out.println("Fonctionnalite : ajouter un client");
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

