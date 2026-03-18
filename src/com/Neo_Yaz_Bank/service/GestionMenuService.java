package com.Neo_Yaz_Bank.service;
import java.util.Scanner;

public class GestionMenuService {
    private final Scanner scanner;

    public GestionMenuService() {
        this.scanner = new Scanner(System.in);
    }
    public void StartMenu() {
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            System.out.println("Veuillez entrée votre choix");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("️  Entrée invalide. Veuillez saisir un nombre.\n");
                scanner.nextLine();
            }
            choiceTreatment(choice);
        }
        scanner.close();
    }

    /**
     * Traite le choix saisi par l'utilisateur via un switch.
     * @param choice Le numéro de l'option choisie
     */

    private void choiceTreatment(int choice){

            switch(choice) {
                case 1 :
                    System.out.println("\n>>> Ajouter un nouveau client");
                    // code block
                    break;
                case 2 :
                    System.out.println("\n>>> Afficher la liste des clients");
                    // code block
                    break;
                case 3 :
                    System.out.println("\n>>> Rechercher un client");
                    // code block
                    break;
                case 4:
                    System.out.println("\n>>> Supprimer un client");
                    // code block
                    break;
                case 5:
                    System.out.println("\n>>> Créer un compte bancaire");
                    // code block
                    break;
                case 6:
                    System.out.println("\n>>> Afficher les comptes d'un client");
                    // code block
                    break;
                case 7:
                    System.out.println("\n>>> Consulter le solde d'un compte");
                    // code block
                    break;
                case 8:
                    System.out.println("\n>>> Effectuer un dépôt");
                    // code block
                    break;
                case 9:
                    System.out.println("\n>>> Effectuer un retrait");
                    // code block
                    break;
                case 10:
                    System.out.println("\n>>> Effectuer un virement entre comptes");
                    // code block
                    break;
                case 0:
                    System.out.println("\n Au revoir ! À bientôt.");
                    break;
                default:
                    System.out.println("\n️  Option invalide. Veuillez choisir entre 0 et 10.\n");
                    // code block
            }

    }
    public  void displayMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       BANQUE - MENU PRINCIPAL        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  --- Gestion des Clients ---         ║");
        System.out.println("║  1. Ajouter un client                ║");
        System.out.println("║  2. Afficher tous les clients        ║");
        System.out.println("║  3. Rechercher un client             ║");
        System.out.println("║  4. Supprimer un client              ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  --- Gestion des Comptes ---         ║");
        System.out.println("║  5. Créer un compte bancaire         ║");
        System.out.println("║  6. Afficher les comptes d'un client ║");
        System.out.println("║  7. Consulter le solde               ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  --- Opérations Bancaires ---        ║");
        System.out.println("║  8. Effectuer un dépôt               ║");
        System.out.println("║  9. Effectuer un retrait             ║");
        System.out.println("║  10. Effectuer un virement           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  0. Quitter                          ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
