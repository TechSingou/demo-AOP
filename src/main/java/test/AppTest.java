package test;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

public class AppTest {
    public static void main(String[] args) {
        new AppTest().start();
    }

    public void start() {
        System.out.println("Démarrage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Donner le code du compte : ");
        long code = scanner.nextLong();
        System.out.print("Donner le solde initiale du compte : ");
        double solde = scanner.nextDouble();

        IMetierBanque metierBanqueImpl = new MetierBanqueImpl();
        metierBanqueImpl.addCompte(new Compte(code, solde));
        while (true) {
            try {
                System.out.print("Type Opération : ");
                String type = scanner.next();
                System.out.print("Montant : ");
                double montant = scanner.nextDouble();
                if (type.equals("v")) {
                    metierBanqueImpl.verser(code, montant);
                } else if (type.equals("r")) {
                    metierBanqueImpl.retirer(code, montant);
                }
                Compte compte = metierBanqueImpl.consulter(code);
                System.out.println("Etat du compte Solde : " + compte);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
