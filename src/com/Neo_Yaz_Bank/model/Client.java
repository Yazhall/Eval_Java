package com.Neo_Yaz_Bank.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
   private String firstname ;
   private String lastname;
   private String addresse;
   private LocalDate birthday;
   private int ID;
   private ArrayList<BankAccount> ListAccount;

    public Client(String firstname, String lastname, String addresse, LocalDate birthday, int ID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresse = addresse;
        this.birthday = birthday;
        this.ID = ID;
        this.ListAccount = new ArrayList<>();
    }

    public ArrayList<BankAccount> getListAccount() {
        return ListAccount;
    }

    public void setListAccount(ArrayList<BankAccount> listAccount) {
        ListAccount = listAccount;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }


    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
