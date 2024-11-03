package org.example;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private double solde;
    private String currency;

    public BankAccount(double solde, String currency) {
        this.solde = solde;
        this.currency = currency;
    }
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
