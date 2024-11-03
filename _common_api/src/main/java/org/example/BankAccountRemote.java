package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccountRemote extends Remote {
    double getSold() throws RemoteException;
    void crediter(double montant) throws RemoteException;
    void debiter(double montant)throws RemoteException;
    void transfer(double montant , BankAccount destination)throws RemoteException;
}
