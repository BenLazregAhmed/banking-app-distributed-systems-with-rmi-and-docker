package org.example;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankAccountRemoteImpl extends UnicastRemoteObject implements BankAccountRemote {
    private BankAccount bankAccount;
    public BankAccountRemoteImpl() throws RemoteException {
        bankAccount=new BankAccount(0,"DT");
    }

    @Override
    public double getSold() throws RemoteException {
        return bankAccount.getSolde();
    }

    @Override
    public void crediter(double montant) throws RemoteException {
        bankAccount.setSolde(bankAccount.getSolde()+montant);
    }

    @Override
    public void debiter(double montant) throws RemoteException {
        if (bankAccount.getSolde()>montant)
            bankAccount.setSolde(bankAccount.getSolde()-montant);
        else
            throw new RuntimeException("Solde Insuffisant !!!");
    }

    @Override
    public void transfer(double montant, BankAccount destination) throws RemoteException {
        if (bankAccount.getSolde()>montant) {
            bankAccount.setSolde(bankAccount.getSolde() - montant);
            destination.setSolde(destination.getSolde()+montant);
        }
        else
            throw new RuntimeException("Solde Insuffisant !!!");
    }

}
