/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.message;

import com.cse.humain.User;
import java.util.Scanner;

/**
 *
 * @author Sergio.COURTOIS
 */
public class Message{
    
    // Attributs
    private String receiver;
    private String content;

    // Constructeur
    public Message(String op1,String op2 ) { 
        
        this.receiver = op1 ;
        this.content = op2;
    }
    // Methode
public static void writeMessage(User myUser , Scanner sc){
    
    System.out.println("\n ---------------------------  \n Ecriver votre message \n ---------------------------");
    String newmessage = sc.nextLine();
    System.out.println("\n ---------------------------  \n A qui souhaitez vou l'envoyer \n ---------------------------");
    String newreceive = sc.nextLine();
    Message myMessage = new Message( newreceive , newmessage);
    myUser.getMessagelist().add(myMessage);
    System.out.println(myUser.getMessagelist());
    
    }
public static void afficheMessage(User myUser ,Scanner sc){
    
    System.out.println("\n ---------------------------  \n Aficher un message choissssez le numero du message \n ---------------------------");
   int choixMessage = sc.nextInt();
    sc.nextLine();
    System.out.println("\n ---------------------------  \n message numero "+choixMessage +" \n"+myUser.getMessagelist().get(choixMessage).getContent()+"\n ---------------------------");
                    
}   
// getter/setter
    
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }    
}
