package com.Neo_Yaz_Bank.model;

/**
 * Représente un compte bancaire associé à un client.
 * Contient le numéro de compte généré automatiquement, le titulaire et le solde.
 */
public class BankAccount {
    /** Numéro de compte unique, généré automatiquement */
    private int accountNumbers;
    /** Client titulaire du compte */
    private Client holder;
    /** Solde initial par défaut pour tout nouveau compte */
    private static final double initialSold = 0.0;
    /** Compteur pour générer les numéros de compte uniques */
    private static int counter = 1;
    /** Solde actuel du compte */
    private double solde ;
    public BankAccount( Client holder) {
        this.accountNumbers = counter++;
        this.holder = holder;
        this.solde = initialSold;

    }

    public int getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(int accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        BankAccount.counter = counter;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }



    @Override
    public String toString(){
        return "Numéro de compte : " + accountNumbers + "\n Solde : " + solde + "euro";
    }
}
