package com.Neo_Yaz_Bank.service;

import com.Neo_Yaz_Bank.exception.ClientNotFoundException;
import com.Neo_Yaz_Bank.model.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Le Service qui va gerer toute les methode pour les clients
 * - crée un client
 * - afficher tous les clients
 * - chercher un client via :
 *                             -ID
 *                             -Firstname
 *                             -Lastname
 * modifier les infos d'un client
 * supprimer un client
 */
public class ClientService  {
    private List<Client> clients;
    private final Scanner scanner;


    public ClientService(Scanner scanner, List<Client> clients) {
        this.scanner = scanner;
        this.clients = clients;
    }

    /**
     * crée un client grace au infos donner par l'utilisateur
     */
    public void addClient (){
        System.out.println("\nCompleter les information demander pour ajouter un nouveau client");

        System.out.println("\nLe Prenom: ");
        String Firstname = scanner.nextLine();

        System.out.println("\nle noms ");
        String Lastname = scanner.nextLine();

        System.out.println("\nl'addresse :");
        String addresse = scanner.nextLine();

        System.out.println("\nJour de naissance : ");
        int day = scanner.nextInt();

        System.out.println("\nMois de naissance : ");
        int month = scanner.nextInt();

        System.out.println("\nAnnée de naissance : ");
        int year = scanner.nextInt();

        LocalDate birthday = LocalDate.of(year, month, day);

        Client newClient  = new Client(Firstname,Lastname,addresse,birthday);
        clients.add(newClient);

    }

    /**
     * Affiche toute la liste des clients
     */
    public void displayClientsList(){
        for (Client client : clients){
            System.out.println(client);
        }
    }

    /**
     * cherche un client via sont ID
     * @param id
     * @return
     */
    public Client findByClientID(int id){
        return clients.stream().filter(client -> client.getID() == id).findFirst().orElse(null);
    }

    /**
     * cherche un client via sont Firstname
     * @param firstname
     * @return
     */
    public List<Client> findByClientFirstname (String firstname){
        return clients.stream().filter(client -> Objects.equals(client.getFirstname(), firstname)).collect(Collectors.toList());

    }

    /**
     * cherche un client via sont Lastname
     * @param lastname
     * @return
     */
    public List<Client> findByClientLastname (String lastname){
        return clients.stream().filter(client -> Objects.equals(client.getLastname(), lastname)).collect(Collectors.toList());
    }

    /**
     * Systeme de choix pour l'utilisateur
     * afficher le menu tant que l'utilisateur n'a pas fait de choix
     * lui permet de choisir la facon de rechercher un client
     */
    public void searchClient(){
        int choice = -1;
        while (choice != 0) {
            displayMenuserchclient();
            System.out.println("\nVeuillez entrer votre choix");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("️\nEntrer invalide. Veuillez saisir un nombre.\n");
                scanner.nextLine();
            }
            choiceTreatmentsearchClient(choice);
        }
    }

    /**
     * Appel la bonne methode de recherche en fonction du choix de l'utilisateur
     * @param choice
     * @throws ClientNotFoundException
     */
    private void choiceTreatmentsearchClient(int choice)throws ClientNotFoundException{

        switch(choice) {
            case 1 :
                System.out.println("\n>>> Enter l'ID du Client ");
                int Idclient = scanner.nextInt();
                Client client = findByClientID(Idclient);
                if (client == null){
                    throw new ClientNotFoundException("Le client est introuvable");
                }else {
                    System.out.println(client);
                }
                break;
            case 2 :
                System.out.println("\n>>> Enter le Prenom du Client");
                String firstname = scanner.nextLine();
                 List<Client> Clientbyfirstname = findByClientFirstname(firstname);
                if (Clientbyfirstname.isEmpty()){
                    throw new ClientNotFoundException("Le client est introuvable");
                }else {
                    for (Client clients : Clientbyfirstname ){
                        System.out.println(clients);
                    }
                }
                break;
            case 3 :
                System.out.println("\n>>> Enter le Noms duc client ");
                String lastname = scanner.nextLine();
                List<Client> ClientByLastname = findByClientLastname(lastname);
                if (ClientByLastname.isEmpty()) {
                    throw new ClientNotFoundException("Le client est introuvable");
                }else{
                    for (Client clients : ClientByLastname){
                        System.out.println(clients);
                    }
                }
                break;
            default:
                System.out.println("\n️Option invalide. Veuillez choisir entre 0 et 10.\n");

        }
    }
    public  void displayMenuserchclient() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     BANQUE -Chercher UN CLIENT       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  --- Gestion des Clients ---         ║");
        System.out.println("║  1. Via sont ID                      ║");
        System.out.println("║  2. Via sont noms                    ║");
        System.out.println("║  3. Via sont Prénom                  ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  0. Quitter                          ║");
        System.out.println("╚══════════════════════════════════════╝");
    }


    /**
     * Systeme de choix pour l'utilisateur
     * afficher le menu tant que l'utilisateur n'a pas fait de choix
     * lui permet de choisir ce qu'il veut modifier
     * @throws ClientNotFoundException
     */
    public void updateClient()throws ClientNotFoundException{
        System.out.println("\nEnter l'id du client a modifier");
        int IdClient = scanner.nextInt();
        Client client = findByClientID(IdClient);
        if (client == null){
            throw new ClientNotFoundException("Le client est introuvable");
        }
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            System.out.println("\nVeuillez entrer votre choix");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("️\nEntrer invalide. Veuillez saisir un nombre.\n");
                scanner.nextLine();
            }
            choiceTreatment(choice, client);
        }
    }

    /**
     * Traite le choix saisi par l'utilisateur via un switch.
     * appel les bonne methode pour modifier les infos souhaité
     * @param choice Le numéro de l'option choisie
     */

    private void choiceTreatment(int choice, Client client){

        switch(choice) {
            case 1 :
                System.out.println("\n>>> modifier le noms du client");
                System.out.println("\nveuillez entrer le nouveau noms du client");
                String newLastname = scanner.nextLine();
                client.setLastname(newLastname);
                System.out.println("\nle noms a bien etait modifier ");
                break;
            case 2 :
                System.out.println("\n>>> modifier le prénoms du client");
                System.out.println("\nveuillez entrer le nouveau Prenoms du client");
                String newFirstname = scanner.nextLine();
                client.setFirstname(newFirstname);
                System.out.println("\n le prenom a bien etait modifier ");

                break;
            case 3 :
                System.out.println("\n>>> modifier l'address du client");
                System.out.println("\n veuillez entrer la nouvelle address du client");
                String newAddress = scanner.nextLine();
                client.setAddresse(newAddress);
                System.out.println("\n l'address a bien etait modifier ");

                break;
            case 4:
                System.out.println("\n>>> modifier la date anniversaire  du client");
                System.out.println("\nveuillez entrer la nouvelle année  de l'anniversaire  du client ");
                int newyear = scanner.nextInt();
                System.out.println("\nveuillez entrer le nouveau mois de l'anniversaire  du client ");
                int newmonth = scanner.nextInt();
                System.out.println("\nveuillez entrer le nouveau jour de l'anniversaire  du client ");
                int newdays = scanner.nextInt();
                LocalDate birthday = LocalDate.of(newyear,newmonth,newdays);
                client.setBirthday(birthday);
                System.out.println("\nla date d'anniversaire a bien était modifier ");
                break;
            default:
                System.out.println("\n️Option invalide. Veuillez choisir entre 0 et 10.\n");

        }
    }
    public  void displayMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("  ║     BANQUE -MODIFIER UN CLIENT       ║");
        System.out.println("  ╠══════════════════════════════════════╣");
        System.out.println("  ║  --- Gestion des Clients ---         ║");
        System.out.println("  ║  1. modifier le noms du client       ║");
        System.out.println("  ║  2. modifier le prénom du client     ║");
        System.out.println("  ║  3. modifier l'address du client     ║");
        System.out.println("  ║  4. modifier la date d'anniversaire  ║");
        System.out.println("  ╠══════════════════════════════════════╣");
        System.out.println("  ║  0. Quitter                          ║");
        System.out.println("  ╚══════════════════════════════════════╝");
    }

    /**
     * supprime un client via sont ID
     * @throws ClientNotFoundException
     */
    public void removeClient()throws ClientNotFoundException{
        System.out.println("\nveulliez entrer l'ID du client a supprimer ");
        int findID = scanner.nextInt();
        Client client =  findByClientID(findID) ;
        if (client == null) {
            throw new ClientNotFoundException("Le client est introuvable");
        }
        clients.remove(client);
        System.out.println("\nle client  a bien etait supprimé");
    }

    }

