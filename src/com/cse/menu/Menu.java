/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.menu;

import com.cse.employe.Dev;
import com.cse.employe.Directeur;
import com.cse.employe.Employe;
import com.cse.employe.Marketteur;
import com.cse.humain.Admin;
import com.cse.humain.Personne;
import com.cse.humain.SuperAdmin;
import com.cse.humain.User;
import com.cse.interfacelist.Salarie;
import com.cse.message.Message;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Sergio.COURTOIS
 */
public class Menu {
    public static void fakeUser(ArrayList listUser){
        Personne nwUser; 
    nwUser = new Dev("Courtois", "Sergio" , "20/08/1991");
    listUser.add(nwUser);
    nwUser = new Marketteur("Mauppin", "Loic" , "En janvier 1991");
    listUser.add(nwUser);
    nwUser = new Directeur("isdgvg", "hersdsfh" , "dsvgds");
    listUser.add(nwUser);
    nwUser = new User("dshg", "sdghsqd" , "dsqgldsq");
    listUser.add(nwUser);
    nwUser = new Admin("sdgvds", "dshgvmsqd<" , "sgdsoihgsq");
    listUser.add(nwUser);
    nwUser = new SuperAdmin("sdhvms", "sdqgnhs" , "dsq<gvs");
    listUser.add(nwUser);
    System.out.println(listUser);
    }
    
    public static String choixInscription(Scanner enter){
        String continu = "oui";
        String choixInscription = ""  ;
        while (continu.equals("oui")){
            
            System.out.println(" \n ---------------------------  \n Voulez vous ? \n /1/  vous inscrire \n /2/ vous connecter \n ---------------------------");
            String choice = enter.nextLine();


            switch (choice) {
                case "1":
                    choixInscription = "oui";
                    continu ="non";
                    break;

                case "2":
                    choixInscription = "non";
                    continu ="non";
                    break;

                default:
                    System.out.println("wrong choice");
                    break;

            }
            
        }
        
        return choixInscription ;
    
    }
    public static Personne creationProfil(Scanner enter,ArrayList listUser){
        String continu = "oui";
        int choixStaff = 0;
        int lvlStaff = 0;
        int niveauMod = 0;
        Personne myUser = new User("","","");
        
        while (continu.equals("oui")){
            
            System.out.println(" --------------------------- \n faite vous parti du staff \n /1/ pour oui \n /2/ pour non \n---------------------------");
            choixStaff = enter.nextInt();
            enter.nextLine();
            switch (choixStaff) {
                case 1:
                    System.out.println(" --------------------------- \n Quel est votre post \n /1/ pour dev \n /2/ pour Marketer \n /3/ pour Directeur \n---------------------------");
                    lvlStaff = enter.nextInt();
                    enter.nextLine();
                    myUser = Employe.createEmploye(enter,lvlStaff,listUser);
                    continu="non";
                    break;
                case 2:
                    System.out.println(" --------------------------- \n Ete vous moderateur \n /1/ pour non \n /2/ pour oui \n /3/ presque un super moderateur \n---------------------------");
                    niveauMod = enter.nextInt();
                    enter.nextLine();
                    myUser = User.createUser(enter, niveauMod, listUser);
                    continu="non";
                    break;
                    
                default:
                    System.out.println(" --------------------------- \n Quel est votre post \n /1/ pour dev \n /2/ pour Marketer \n /3/ pour Directeur \n---------------------------");
                    lvlStaff = enter.nextInt();
                    enter.nextLine();
                    myUser = Employe.createEmploye(enter,lvlStaff,listUser);
                    continu="non";
                    break;
                   
            }
            
        }
        return myUser;
    }
    /**
     *
     * @param enter
     */
    public static ArrayList getUserInfo(Scanner enter){ 
        ArrayList infolist = new ArrayList();
        System.out.println(" Veuillez saisir votre prénom :");
        String firstName = enter.nextLine();
        infolist.add(firstName);
        System.out.println("Veuillez saisir votre nom :");
        String lastName = enter.nextLine();
        infolist.add(lastName);
        System.out.println("Veuillez saisir votre date de naissance :");
        String birthDate = enter.nextLine();
        infolist.add(birthDate);
            
        return infolist; 
    }
    public static Personne verifProfil(Scanner enter, ArrayList <Personne> listUser){
        
        ArrayList infoList = Menu.getUserInfo(enter);
        Personne personSel = new User ("","","");
        
        for (Personne item : listUser){
            if (item.getNom().equals(infoList.get(1).toString())){
                personSel = item ;

            }

        }
        
        return personSel;
                

    }
    public static void displayMenu(Scanner enter, ArrayList <Personne> listUser,Personne myUser){
        
        Boolean menu_continu = true; 
        
        while (menu_continu  == true){
            System.out.println(
                    " --------------------------- \n"
                    + "MENU taper \n"
                    + "---------------------------  \n"
                    + "/1/ pour afficher votre profil \n"
                    + "/2/ pour le modifier \n"
                    + "/3/ pour écrire un message \n"
                    + "/4/ pour lister vos message \n"
                    + "/5/ ajouter un ami \n"
                    + "/6/ afficher un ami \n"
                    + "/7/ afficher un ami \n"
                    + "/8/ Quitter \n"
                    + "/9/ Créer un nouvelle utilisateur \n "
                    + "/10/ Effacer un message qui ne vous appartient pas (admin) \n"
                    + "/11/ Effacer un User(Super Admin) \n"
                    + "/12/ etre payer \n"
                    + "/13/ avoir des relation \n"
                    + "---------------------------");
            int choix = enter.nextInt();
            enter.nextLine();
            switch (choix){
                case 1:
                    ((Personne)myUser).affichePersonne();
                    break;

                case 2:
                    ((User)myUser).editUser( enter );
                    break;

                case 3:
                    //if()
                    Message.writeMessage(((User)myUser) ,enter);
                    break;

                case 4:
                    Message.afficheMessage(((User)myUser) ,enter);
                    break;


                case 5:
                    ((User)myUser).createFriend( enter , listUser) ;
                    break;

                case 6:
                    ((User)myUser).afficheListeAmi();
                    break;
                case 7:
                    ((User)myUser).afficheUnAmi(enter);
                    break;

                case 8:
                    System.out.println("\n ---------------------------  \n exit \n --------------------------- ");
                    menu_continu=false;
                    break;
                case 9:

                    System.out.println("\n ---------------------------  \n Créer un nouvel utilisateur \n --------------------------- ");
                    myUser = User.createUser(enter, listUser);
                    break;
                case 10:

                    if( ((User)myUser).getLvl() > 1 ){
                    System.out.println("\n ---------------------------  \n Effacer un message (Admin Uniquement) \n --------------------------- ");
                    ((Admin)myUser).effacerAutreMessage(enter,listUser); 
                    }else{
                    Menu.erreur(enter);
                    }
                    break;
                case 11:
                    
                    if (((User)myUser).getLvl() > 2){
                    System.out.println("\n ---------------------------  \n Effacer un User (SuperAdmin Uniquement)\n --------------------------- ");

                     ((SuperAdmin)myUser).effacerAutreUser(enter,listUser); 
                    }
                    else{
                        Menu.erreur(enter);
                    }
                    
                    break;
                case 12:
//                    if (myUser instanceof Admin) {
//                        ((Admin)myUser).recevoirPaiement();
//                    }
//                    if (myUser instanceof Employe) {
//                        ((Employe)myUser).recevoirPaiement();
//                    }
                    
                    ((Salarie)myUser).recevoirPaiement();
                    break;
                case 13:
                    if (myUser instanceof User) {
                        ((User)myUser).ajouterPersonne();
                    }
                    if (myUser instanceof Directeur) {
                        ((Directeur)myUser).ajouterPersonne();
                    }
                     

                    break;

                default:
                    Menu.erreur(enter);

                break;
            }
        }   
    }
    public static void erreur(Scanner sc) {  
        System.out.println("\n ---------------------------  \n"+ sc +" ne faisait pas parti des possbilité \n ---------------------------  \n");
    }

    
    
}
