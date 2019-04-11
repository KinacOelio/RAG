
package runningawaygame;

import runningawaygame.Things.*;
import java.util.List;
import java.util.Scanner;
import static runningawaygame.RunningAwayGame.*;  


public class Com {  
//-------------------------------------------------     
//the list of command methods for the switch statement      
public void go(Player Player1, Place[] places){
    
     String destination = keyboard.nextLine().trim();
     System.out.println("How would you like to travel?");
     int key = 1;
     System.out.println(key + ": walk");
     key++;
     for(Thing _thing : thingsList)
     {
         if(
            _thing.getPlace() == Player1.getPlace() &&
            _thing.isTransport &&
            _thing.usable
           ){
             System.out.println(key + ": Use " + _thing.getName());
             key++;
            }
     }
     int method = 0;
     try
     {
         method = Integer.parseInt(keyboard.next());
         if(method < 1 || method > key) throw new NumberFormatException();
     }catch(NumberFormatException e)
     {
         System.out.println("I'm not familiar with that form of transportation");
     }
     if(method != 0)
     {
         Player1.setPlace(destination, placesList);
     }
         
     
     
     
     
}

public void look(Player Player1){
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
    List<Thing> inv1 = Player1.getInv();
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
    List<Thing> inv1 = Player1.getInv();
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

public void talk(Scanner keyboard, NPC[] folks, Player Player1, Place[] places){
String NPCtoTalk = keyboard.next().toUpperCase();
NPC person = Utility.findNPCFromString(folks, NPCtoTalk);
Place e = places[0];
if(person.getPlace()==Player1.getPlace()||person.getPlace()==e){
person.talk(places);}
else{System.out.println("That person is not here!");}
}

public void ex(){
String uInput2 = keyboard.nextLine().trim();
Thing toEx = Utility.findThingFromString(thingsList, uInput2);
if(Player1.inv.contains(toEx) ||
   toEx.getPlace().getName().equals(Player1.getPlace().getName()))

{System.out.println(toEx.getDesc());}
else{System.out.println("You don't see that...");}
}


//END COMMANDS BLOCK
//-------------
}
