package com.Neo_Yaz_Bank.service;
import com.Neo_Yaz_Bank.exception.AccountNotFoundException;
import com.Neo_Yaz_Bank.exception.ClientNotFoundException;
import com.Neo_Yaz_Bank.exception.InsufficientSoldeException;
import com.Neo_Yaz_Bank.exception.InvalideAmountException;

import java.util.Scanner;

public class GestionMenuService {
    private final Scanner scanner;
    private final ClientService clientService;
    private final BankAccountService bankAccountService;

    /**
     * Service qui gere l'affichage du menu principal et l'appel les bonne methode en fonction des choix de l'utilisateur
     * @param scanner
     * @param clientService
     * @param bankAccountService
     */
    public GestionMenuService(Scanner scanner,ClientService clientService, BankAccountService bankAccountService) {
        this.scanner = scanner;
        this.clientService =  clientService;
        this.bankAccountService = bankAccountService;

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
     * Appel la bonne methode lié au choix de l'utilisateur
     * @param choice Le numéro de l'option choisie
     */

    private void choiceTreatment(int choice){

            switch(choice) {
                case 1 :
                    System.out.println("\n>>> Ajouter un nouveau client");
                    clientService.addClient();

                    break;
                case 2 :
                    System.out.println("\n>>> Afficher la liste des clients");
                    clientService.displayClientsList();
                    break;
                case 3 :
                    try {
                        System.out.println("\n>>> Rechercher un client");
                        clientService.searchClient();
                    }catch (ClientNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("\n>>> Supprimer un client");
                        clientService.removeClient();
                    }catch (ClientNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("\n modifier les infos d'un client");
                        clientService.updateClient();
                    }catch (ClientNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("\n>>> Créer un compte bancaire");
                        bankAccountService.createAccount();
                    }catch (ClientNotFoundException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 7:
                    try {
                        System.out.println("\n>>> Afficher les comptes d'un client");
                        bankAccountService.displayAccountClient();
                    }catch (ClientNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("\n>>> Consulter le solde d'un compte");
                        bankAccountService.displaySolde();
                    }catch (ClientNotFoundException|AccountNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println("\n>>> Effectuer un dépôt");
                        bankAccountService.depositIntoAccount();
                    }catch (ClientNotFoundException | AccountNotFoundException | InvalideAmountException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println("\n>>> Effectuer un retrait");
                        bankAccountService.withdrawIntoAccount();
                    }catch (ClientNotFoundException | AccountNotFoundException | InvalideAmountException |
                            InsufficientSoldeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    try {
                        System.out.println("\n>>> Effectuer un virement entre comptes");
                        bankAccountService.BankTransfer();
                    }catch (ClientNotFoundException | AccountNotFoundException | InvalideAmountException |
                            InsufficientSoldeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("\n Au revoir ! À bientôt.");
                    break;
                default:
                    System.out.println("\n️  Option invalide. Veuillez choisir entre 0 et 10.\n");
                    break;
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
        System.out.println("║  5. modifier les infos d'un client   ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  --- Gestion des Comptes ---         ║");
        System.out.println("║  6. Créer un compte bancaire         ║");
        System.out.println("║  7. Afficher les comptes d'un client ║");
        System.out.println("║  8. Consulter le solde               ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  --- Opérations Bancaires ---        ║");
        System.out.println("║  9. Effectuer un dépôt               ║");
        System.out.println("║  10. Effectuer un retrait            ║");
        System.out.println("║  11. Effectuer un virement           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  0. Quitter                          ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
