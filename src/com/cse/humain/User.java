/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.humain;

import com.cse.interfacelist.Relation;
import com.cse.menu.Menu;
import com.cse.message.Message;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergio.COURTOIS
 */
public class User extends Personne implements Relation {

    public User( String nom, String prenom, String dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.pseudo = pseudo;
        this.lvl = 1;
    }

    @Override
    public String toString() {
        return "User{" + "pseudo=" + pseudo + ", lvl=" + lvl + ", messagelist=" + messagelist + ", friendlist=" + friendlist + '}';
    }

    protected String pseudo;
    protected int lvl;
    protected ArrayList <Message> messagelist;
    protected ArrayList <User> friendlist;
    
    
    
    public static Personne createUser(Scanner enter,int choice , ArrayList listUser){
        
        ArrayList infoList;
        User myUser;
        
        switch (choice) {
                case 1:
                    System.out.println(" --------------------------- User\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new User(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                case 2:
                    System.out.println(" --------------------------- Admin\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new Admin(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                case 3:
                    System.out.println(" --------------------------- SuperAdmin\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new SuperAdmin(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                    break;
                
                default:
                    System.out.println(" --------------------------- User\n---------------------------");
                    infoList = Menu.getUserInfo(enter);
                    myUser = new User(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
                break;
                    
        }
        
        listUser.add(myUser);
        return myUser;
    }
    public static Personne createUser(Scanner enter , ArrayList listUser){
        
        ArrayList infoList;
        User myUser;       
        System.out.println(" --------------------------- User\n---------------------------");
        infoList = Menu.getUserInfo(enter);
        myUser = new User(infoList.get(0).toString(), infoList.get(1).toString() , infoList.get(2).toString());
        listUser.add(myUser);
        return myUser;
    }
    public void afficheUnAmi(Scanner sc) {   
        System.out.println("\n ---------------------------  \n Afficher un Ami \n ---------------------------");
        System.out.println("\n ---------------------------  \n Choissssez le numero du cet Ami \n ---------------------------");
        int who = sc.nextInt();
        sc.nextLine();
        System.out.println("\n ---------------------------  \n vos etes ami avec "+this.friendlist.get(who).getNom()+this.friendlist.get(who).getPrenom()+this.friendlist.get(who).getDateNaissance()+"\n bonne chance vous en aez besoin \n ---------------------------");        
    }
    public void afficheUser() {   
        System.out.println("\n ---------------------------  \n Afficher User \n ---------------------------");
        System.out.println("\n ---------------------------  \n vous êtes "+this.getNom()+" "+this.getPrenom());        
    }
         
    public void afficheListeAmi() {   
        int i = 0;
        for(User myFriend : this.friendlist){
        System.out.println(myFriend+" "+i);
        ++i;
        }
    }
    
    

    public void editUser( Scanner enter) { 
    
        ArrayList infoList = Menu.getUserInfo(enter);


        this.setPrenom(infoList.get(0).toString());
        this.setNom(infoList.get(1).toString());
        this.setDateNaissance(infoList.get(2).toString());
        System.out.println(this.getNom()+" "+this.getPrenom()+" "+this.getDateNaissance());   
      
    }
    public User createFriend(Scanner sc, ArrayList<Personne> userlist ) {       
        System.out.println(" \n ---------------------------  \n Veuillez saisir son prénom : \n ---------------------------");
        String firstName = sc.nextLine();
        System.out.println(" \n ---------------------------  \n Veuillez saisir son nom : \n ---------------------------");
        String lastName = sc.nextLine();
        System.out.println(" \n ---------------------------  \n Veuillez saisir sa date de naissance : \n ---------------------------");
        String birthDate = sc.nextLine();
        User myFriend = new User( firstName , lastName , birthDate);
        this.friendlist.add(myFriend);
        userlist.add(myFriend);        
        return myFriend;
}

    @Override
    public void ajouterPersonne() {
        System.out.println("je me fais des Amis");
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public ArrayList<Message> getMessagelist() {
        return messagelist;
    }

    public void setMessagelist(ArrayList<Message> messagelist) {
        this.messagelist = messagelist;
    }

    public ArrayList<User> getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(ArrayList<User> friendlist) {
        this.friendlist = friendlist;
    }
    
    

    
    
}
