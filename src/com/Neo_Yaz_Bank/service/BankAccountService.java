package com.Neo_Yaz_Bank.service;

import com.Neo_Yaz_Bank.exception.AccountNotFoundException;
import com.Neo_Yaz_Bank.exception.ClientNotFoundException;
import com.Neo_Yaz_Bank.exception.InsufficientSoldeException;
import com.Neo_Yaz_Bank.exception.InvalideAmountException;
import com.Neo_Yaz_Bank.model.BankAccount;
import com.Neo_Yaz_Bank.model.Client;
import java.util.List;
import java.util.Scanner;

/**
 * Le Service qui va gerer toute les methode pour les comptes bancaire
 * - crée des comptes
 * - effectuer des dépot
 * - effectuer des retraits
 * - effectuer des transferts entre comptes
 */
public class BankAccountService  {
    private List<Client> clients;
    private final Scanner scanner;
    private ClientService clientService;

    public BankAccountService(Scanner scanner, List<Client> clients,ClientService clientService) {
        this.scanner = scanner;
        this.clients = clients;
        this.clientService = clientService;
    }

    /**
     * Crée un compte bancaire qui est associé a un client
     * @throws ClientNotFoundException si le Client est introuvable
     */
    public void createAccount()throws ClientNotFoundException {
        System.out.println("\ncrée un compte bancaire ");
        System.out.println("\nveuillez indiquer a qui va appartenir le compte via l'ID du clients ");
        int IDatclient =scanner.nextInt();
        Client client = clientService.findByClientID(IDatclient);
        if (client == null) {
            throw new ClientNotFoundException("Le client est introuvable");
        }
        BankAccount account = new BankAccount(client);
        client.getListAccount().add(account);
        System.out.println("\nLe compte a bien etait crée !");

    }

    /**
     * affiche les comptes d'un client passé en paramétre le client est ajouter en paramétre par la methode displayAccountClient()
     *
     * @param client
     */
    public void displayAccountsForClient(Client client) {
        for (BankAccount account : client.getListAccount()) {
            System.out.println(account);
        }
    }

    /**
     * affiche les compte d'un client trouver via sont ID , ajoute le client a displayAccountsForClient()
     * @throws ClientNotFoundException si le client est introuvable
     */
    public void displayAccountClient()throws ClientNotFoundException {
        System.out.println("\nafficher tout les compte d'un client ");
        System.out.println("\nveuillez indiquer l'ID du client");
        int IDatclient = scanner.nextInt();
        Client client = clientService.findByClientID(IDatclient);
        if (client == null){
            throw new ClientNotFoundException("Le client est introuvable");
        }
       displayAccountsForClient(client);
    }

    /**
     * trouve un compte bancaire via sont numero de compte
     * @param client
     * @param accountNumber
     * @return
     */
    public BankAccount findAccountByNumber(Client client, int accountNumber) {
        return client.getListAccount().stream().filter(account -> account.getAccountNumbers() == accountNumber).findFirst().orElse(null);
    }

    /**
     * affiiche le solde d'un compte en chercher d'abord le client via sont ID puis afficher les compte du client
     * et lui demande de choisir un compte via sont numero de compte
     * @throws AccountNotFoundException si le compte est introuvable
     * @throws ClientNotFoundException si le client est introuvable
     */
    public void displaySolde()throws AccountNotFoundException,ClientNotFoundException{
        System.out.println("\nconsulter le solde ");
        System.out.println("\nindiquer l'ID du client ");
        int IDclient = scanner.nextInt();
        Client client = clientService.findByClientID(IDclient);
        if (client == null) {
            throw new ClientNotFoundException("Le client est introuvable");

        }
        displayAccountsForClient(client);
        System.out.println("\nindiquer le numero du compte ");
        int accountNumber = scanner.nextInt();
        BankAccount account = findAccountByNumber(client, accountNumber);

        if (account == null){
            throw  new AccountNotFoundException("Le Compte n'existe pas ");
        }
            System.out.println(account);
    }

    /**
     * effectue un depot sur un compte
     * @throws ClientNotFoundException si le client est introuvable
     * @throws AccountNotFoundException si le compte est introuvable
     * @throws InvalideAmountException si le montant saisi est incorrect
     */
    public void depositIntoAccount()throws ClientNotFoundException,AccountNotFoundException,InvalideAmountException{
        System.out.println("\nFaire un depot ");
        System.out.println("\nindiquer l'ID du client ");
        int IDclient = scanner.nextInt();
        Client client = clientService.findByClientID(IDclient);
        if (client == null){
            throw new ClientNotFoundException("Le client est introuvable");
        }
        displayAccountsForClient(client);
        System.out.println("\nveulliez choisir un compte ");
        int IdAccount = scanner.nextInt();
        BankAccount account = findAccountByNumber(client,IdAccount);
        if (account == null){
            throw  new AccountNotFoundException("Le Compte n'existe pas ");
        }
        System.out.println("\nindiquer le montant du depot au format 0.0");
        double montant = scanner.nextDouble();
        if (montant <= 0){
            throw new InvalideAmountException("le montant doit etre superieur a 0");
        }else {
            account.setSolde(account.getSolde()+montant);
            System.out.println("\nle montant a bien etait ajouter a votre solde ");
            System.out.println(account);
        }
    }

    /**
     * effectue un retrait sur un compte
     * @throws AccountNotFoundException
     * @throws ClientNotFoundException
     * @throws InvalideAmountException
     * @throws InsufficientSoldeException
     */
    public void withdrawIntoAccount()throws AccountNotFoundException,ClientNotFoundException,InvalideAmountException,InsufficientSoldeException{
        System.out.println("\nFaire un retrait ");
        System.out.println("\nindiquer l'ID du client ");
        int IDclient = scanner.nextInt();
        Client client = clientService.findByClientID(IDclient);
        if (client == null){
            throw new ClientNotFoundException("Le client est introuvable");
        }
        displayAccountsForClient(client);
        System.out.println("\nveulliez choisir un compte ");
        int IdAccount = scanner.nextInt();
        BankAccount account = findAccountByNumber(client,IdAccount);
        if (account == null){
            throw  new AccountNotFoundException("Le Compte n'existe pas ");
        }
        System.out.println("\nindiquer le montant du depot au format 0.0");
        double montant = scanner.nextDouble();
        if (montant <= 0 ){
            throw new InvalideAmountException("le montant doit etre superieur a 0 et votre solde doit etre suffisant ");
        } else if (montant > account.getSolde()) {
            throw new InsufficientSoldeException("Le solde de votre compte est insuffisant");
        } else {
            account.setSolde(account.getSolde() - montant);
            System.out.println("\nle montant a bien etait retirer de votre solde ");
            System.out.println(account);
        }
    }

    /**
     * Fait un transefert d'un montant d'un compte sur un autre
     *
     * @throws AccountNotFoundException
     * @throws ClientNotFoundException
     * @throws InvalideAmountException
     * @throws InsufficientSoldeException
     */
    public void BankTransfer() throws AccountNotFoundException,ClientNotFoundException,InvalideAmountException, InsufficientSoldeException {
        System.out.println("\nFaire un virement ");
        System.out.println("\nindiquer l'ID du client qui va etre debiter ");
        int IDclient1 = scanner.nextInt();
        Client client1 = clientService.findByClientID(IDclient1);
        if (client1 == null){
            throw new ClientNotFoundException("Le client est introuvable");
        }
        displayAccountsForClient(client1);
        System.out.println("\nenter le numero du compte a debiter ");
        int IDaccount1 = scanner.nextInt();
        BankAccount account1 = findAccountByNumber(client1,IDaccount1);
        if (account1 == null){
            throw  new AccountNotFoundException("Le Compte n'existe pas ");
        }
        System.out.println("\n"+ account1);
        System.out.println("\nEnter le montant a debiter ");
        double montant1 = scanner.nextDouble();
        if (montant1 <= 0 ){
            throw new InvalideAmountException("le montant doit etre superieur a 0  ");
        } else if ( montant1 > account1.getSolde()) {
            throw  new InsufficientSoldeException("Le solde de votre compte est insuffisant ");

        }
        System.out.println("\nveulliez entrer l' ID du client a crediter");
        int IDclient2 = scanner.nextInt();
        Client client2 = clientService.findByClientID(IDclient2);
        if (client2 == null){
            throw new ClientNotFoundException("Le client est introuvable");
        }
        displayAccountsForClient(client2);
        System.out.println("\nveulliez entrer le numero du compte a créditer");
        int IDaccount2 = scanner.nextInt();
        BankAccount account2 = findAccountByNumber(client2,IDaccount2);
        if (account2 == null){
            throw  new AccountNotFoundException("Le Compte n'existe pas ");
        }
        account1.setSolde(account1.getSolde() - montant1);
        System.out.println("\n"+account1);

        account2.setSolde(account2.getSolde() + montant1);
        System.out.println("\n"+account2);


    }

}
