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
public class SuperAdmin extends Admin implements Salarie{

    public SuperAdmin(String nom, String prenom, String dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.lvl = 3;
    }
    public void effacerAutreUser(Scanner sc , ArrayList<Personne> userlist ) {       
        System.out.println(" \n ---------------------------  \n selectionner un utilisateur \n ---------------------------");
        int userChoice = sc.nextInt();
        sc.nextLine();
        userlist.remove(userChoice);
        
    }

 
    
}
