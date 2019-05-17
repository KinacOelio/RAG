
package runningawaygame;

import runningawaygame.Things.*;
import java.util.ArrayList;
import java.util.Scanner;
import static runningawaygame.RunningAwayGame.*;  


public class Com {  
//-------------------------------------------------     
//the list of command methods for the switch statement      
public void go(){
    
    //#gets the desired location, stores it as a Place
     String sDestination = keyboard.nextLine().trim();
     Place destination;
     try{
         destination = Utility.findPlaceFromString(sDestination);
     }
     //TODO: make this a real exception
     catch(Exception SearchFailedException){
         System.err.println("Sorry, place thing doesn't exist or isn't available!");
         return;
     }
      
    //#gets the method of transportation
     System.out.println("How would you like to travel?");
     String sMethod = keyboard.nextLine().trim();
     Thing method;
          try{
             method = Utility.findThingFromString(sMethod);
             if(method.getLoc() != Player1.getPlace()
             || false){
                 System.err.println("Sorry, that method isn't avaiable!");
                 return;
             }
     }
     //TODO: make this a real exception
     catch(Exception SearchFailedException){
         System.err.println("Sorry, that method doesn't exist or isn't availabe!");
         return;
     }
         
     Player1.setPlace(destination);
     method.setLoc(destination);
     
     
     
}

public void look(){
     System.out.print(Player1.getPlace().getDesc());
     System.out.println();}

public void list()
{
   String uInput2 = keyboard.next().trim();
   switch(uInput2)
  {
     case "places":
        int l = placesList.length;
   System.out.print("You have discovered: ");
   for(int i = 0; i<l; i++){if(placesList[i].getKnown()){System.out.print(placesList[i].getName() + "; ");}}
   System.out.println();
   break;
   case "inv": case "inventory":
    ArrayList<Thing> inv1 = Player1.getInv();
    int m = inv1.size();
    System.out.print("You have: ");
    for(int i = 0; i<m; i++){System.out.print(inv1.get(i).getName() + "; ");}
    System.out.println();   
  }
}
public void list(String input2){
   switch(input2){
   case "places":
    int l = placesList.length;
    System.out.print("You have discovered: ");
    for(int i = 0; i<l; i++){if(placesList[i].getKnown()){System.out.print(placesList[i].getName() + "; ");}}
    System.out.println();
   break;
   case "inv": case "inventory":
    ArrayList<Thing> inv1 = Player1.getInv();
    int m = inv1.size();
    System.out.print("You have: ");
    for(int i = 0; i<m; i++){System.out.print(inv1.get(i).getName() + "; ");}
    System.out.println();   
   }
}

public void trueListPlaces(){
    int l = placesList.length;
    for(int i = 0; i<l; i++){System.out.print(placesList[i].getName() +": " + placesList[i].region + "; ");}
    System.out.println();}

public void inv(){
 //   Player1.listInv; 
}

public void get(){
    String uInput2 = keyboard.nextLine().trim();
    Player1.add(uInput2);}

public void talk(){
    String NPCtoTalk = keyboard.next().toUpperCase();
    NPC person;
    try{
        person = Utility.findNPCFromString(NPCtoTalk);
    }catch(Exception SearchFailedException){
        return;
    }
    
    if(person.getPlace()==Player1.getPlace()
    || person.getPlace()==placesList[0]){
        person.talk();
    }
    else{System.out.println("That person is not here!");}
}

public void ex(){
    String uInput2 = keyboard.nextLine().trim();
    Thing toEx;
    try{
         toEx = Utility.findThingFromString(uInput2);
    }catch(Exception SearchFailedException){
        return;
    }
    if(Player1.inv.contains(toEx) ||
       toEx.getPlace().getName().equals(Player1.getPlace().getName())){
         System.out.println(toEx.getDesc());}
    else{
        System.out.println("You don't see that...");
    }
}


//END COMMANDS BLOCK
//-------------
}
