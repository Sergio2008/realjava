/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.employe;

import com.cse.humain.Personne;
import com.cse.interfacelist.Relation;
import com.cse.interfacelist.Salarie;
import com.cse.menu.Menu;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergio.COURTOIS
 */
public class Employe extends Personne implements Salarie  {
    // attribut
    private int salaire;
    private int duree_contract;
    protected int lvl;
    //constructeur

    public Employe( String nom, String prenom, String dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.salaire = 2500;
        this.duree_contract = 366;
        this.lvl=0;
    }

   
    
    
    //methode
    
    public static Personne createEmploye(Scanner enter , int choice , ArrayList listUser ){
        
        Personne myUser;
        ArrayList infoList;
        
        switch (choice) {
                case 1:
                    System.out.println(choice+"\n --------------------------- Dev\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new Dev(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                    
                case 2:
                    System.out.println(choice+"\n --------------------------- Marketteur\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new Marketteur(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                case 3:
                    System.out.println(choice+"\n --------------------------- Directeur\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new Directeur(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                
                default:
                    System.out.println(choice+"\n --------------------------- Dev\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new Dev(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                    
        }
        listUser.add(myUser);
        return myUser;
    
    }

    @Override
    public void recevoirPaiement() {
        System.out.println("vou etes payer "+this.salaire);
    }

    
    
}
