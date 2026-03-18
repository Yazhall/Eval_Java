package com.Neo_Yaz_Bank.service;

import com.Neo_Yaz_Bank.model.Client;

import java.util.List;
import java.util.Scanner;


public class ClientService extends Client {
    private List<Client> clients;
    private Scanner scanner;

    public ClientService(String firstname, String lastname, String addresse, int birthday, List<Client> clients, Scanner scanner) {
        super(firstname, lastname, addresse, birthday);
        this.clients = clients;
        this.scanner = scanner;
    }

    public void addClient (){
        System.out.println("\nCompleter les information demander pour ajouter un nouveau client");

        System.out.println("\n Le Prénom: ");
        String Firstname = scanner.nextLine();

        System.out.println("\n le noms ");
        String Lastname = scanner.nextLine();

        System.out.println("\n l'addresse :");
        String addresse = scanner.nextLine();

        System.out.println("\n date de naissance ");
        int birthday = scanner.nextInt();
    }

}
