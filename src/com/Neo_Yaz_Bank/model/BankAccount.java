package com.Neo_Yaz_Bank.model;

public class BankAccount {
    private int accountNumbers;
    private String holder;
    private double initialSold;

    public BankAccount(int accountNumbers, String holder, int initialSold) {
        this.accountNumbers = accountNumbers;
        this.holder = holder;
        this.initialSold = initialSold;
    }

    public int getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(int accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getInitialSold() {
        return initialSold;
    }

    public void setInitialSold(double initialSold) {
        this.initialSold = initialSold;
    }
}
