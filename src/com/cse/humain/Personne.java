/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.humain;

/**
 *
 * @author Sergio.COURTOIS
 */

    
public abstract class Personne {
    protected String nom;
    protected String prenom ;
    protected String dateNaissance;

    protected Personne(String nom, String prenom, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    
    
    
    public void affichePersonne() {   
    System.out.println(" \n ---------------------------  \n afficher votre profil \n ---------------------------" );
    System.out.println(this.getPrenom()+" "+this.getNom()+" "+this.getDateNaissance());         
    }   
    
    public String toString() {   
        return(this.getPrenom()+" "+this.getNom()+" "+this.getDateNaissance());         
    }   
    
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }
    public void setNom(String nomUser) {
        this.nom = nomUser;
    }
    public void setPrenom(String prenomUser) {
        this.prenom = prenomUser;
    }
    public void setDateNaissance(String dateNaissanceUser) {
        this.dateNaissance = dateNaissanceUser;
    }
    
}
    

