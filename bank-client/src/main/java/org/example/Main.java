package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount bankAccount=new BankAccount(1000,"DT");
            BankAccountRemote stub=(BankAccountRemote) Naming.lookup("rmi://bank-server:1099/BA");
            int choixUtilisateur=0;
            Scanner clavier = new Scanner(System.in);
            System.out.println("Merci d'entrer votre choix ! ");

            do
            {
                System.out.println("tapez 1 si vous voulez consulter votre solde");
                System.out.println("tapez 2 si vous voulez deposer une somme d'argent");
                System.out.println("tapez 3 si vous voulez retirer une somme d'argent");
                System.out.println("tapez 4 Si vous voulez quitter");

                choixUtilisateur=clavier.nextInt();

                int somArg;
                switch(choixUtilisateur)
                {
                    case 1 :
                    {
                        System.out.println("Votre solde est : "+stub.getSold()+" dinar(s)");
                        break;
                    }
                    case 2 :
                    {
                        System.out.println("Merci de saisir la somme a deposer ...");
                        somArg=clavier.nextInt();
                        stub.crediter(somArg);
                        System.out.println("Votre nouveau solde est :"+stub.getSold()+" dinar(s)");
                        break;
                    }
                    case 3 :
                    {
                        System.out.println("Merci de saisir la somme a retirer ...");
                        somArg=clavier.nextInt();
                        stub.debiter(somArg);
                        System.out.println("votre nouveau solde est :"+stub.getSold()+" dinar(s)");
                        break;
                    }
                    case 4 :
                    {
                        System.out.println("Merci et a la prochaine ...");
                        break;
                    }
                }
            }while(choixUtilisateur != 4);
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}