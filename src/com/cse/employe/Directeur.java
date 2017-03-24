/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.employe;

import com.cse.interfacelist.Relation;

/**
 *
 * @author Sergio.COURTOIS
 */
public class Directeur extends Employe implements Relation{

    public Directeur(String nom, String prenom, String dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.lvl=3;
    }

    @Override
    public void ajouterPersonne() {
        System.out.println("j'engage des gens");
    }
   

   
    
}
