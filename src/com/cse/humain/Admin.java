/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.humain;
import com.cse.interfacelist.Salarie;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergio.COURTOIS
 */
public class Admin extends User implements Salarie {

    public Admin(String nom, String prenom, String dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.lvl = 2;
    }    

    @Override
    public void recevoirPaiement() {
        System.out.println("recevoir des cheque cadeaux");
    }
    public void effacerAutreMessage(Scanner sc , ArrayList<Personne> userlist ) {       
        System.out.println(" \n ---------------------------  \n selectionner un utilisateur \n ---------------------------");
        int userChoice = sc.nextInt();
        sc.nextLine();
        System.out.println(" \n ---------------------------  \n selectionner un message \n ---------------------------");
        int messageChoice = sc.nextInt();
        sc.nextLine();
        Personne selUser = userlist.get(userChoice);
        ((Admin)selUser).getMessagelist().remove(userChoice);
        
}
}
