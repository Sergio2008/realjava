/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpjava;




import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


/**
 *
 * @author Sergio.COURTOIS
 */
public class MPJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        /*
        
        ArrayList <Personne>  listUser = new ArrayList<>();
        Personne utilActuel;
        Scanner enter = new Scanner(System.in);
        
        Menu.fakeUser(listUser);
        String choice = Menu.choixInscription(enter);
        if (choice.equals("oui") ) {
            utilActuel = Menu.creationProfil(enter, listUser);
        } 
        else {
            utilActuel = Menu.verifProfil( enter, listUser);
            System.out.println(utilActuel);
            
        }
        Menu.displayMenu( enter  , listUser, utilActuel);
        */
        
        
    //rootFrame fenetre = new rootFrame();
   // fenetre.setVisible(true);
  

try {
    Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Driver O.K.");


      String url = "jdbc:mysql://localhost/bddreseausocial";

      String user = "root";

      String passwd = "root";


      Connection conn = DriverManager.getConnection(url, user, passwd);

      Statement state = conn.createStatement();

      String query = "SELECT * FROM message";
      query += " INNER JOIN user AS user1 ON  receiver = user1.id";
      query += " INNER JOIN user AS user2 ON  sender = user2.id ";
      
     
      
      
  
 

         
      ResultSet result = state.executeQuery(query);
      
      ResultSetMetaData resultMeta = result.getMetaData();


      System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");

      for(int i = 1; i <= resultMeta.getColumnCount(); i++)

        System.out.println("\t *" + resultMeta.getColumnName(i));        


      System.out.println("Voici les noms et prénoms : ");

      System.out.println("\n---------------------------------");


      while(result.next()){

        System.out.print("\t" + result.getString("title") + "\t |");

        System.out.print("\t" + result.getString("content") + "\t |");
         System.out.print("\t" + result.getString("user2.first_name") + "\t |");
        
        

        System.out.println("\n---------------------------------");

      }
     
         
      


      result.close();

      state.close();

         

    } catch (Exception e) {

      e.printStackTrace();

    }               

         

         
   
        
    
    }
    
}
