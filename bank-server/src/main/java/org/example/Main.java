package org.example;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "bank-server");
            BankAccountRemote bankAccountRemote=new BankAccountRemoteImpl();
            LocateRegistry.createRegistry(1099);
            Naming.bind("BA",bankAccountRemote);
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}