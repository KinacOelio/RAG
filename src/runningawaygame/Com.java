
package runningawaygame;

import java.util.List;
import java.util.Scanner;
import static runningawaygame.RunningAwayGame.*;


public class Com {  
//-------------------------------------------------     
//the list of command methods for the switch statement      
public void go(Player Player1, String[] sPlaces, Place[] places){
    
     String uInput2 = keyboard.nextLine().trim();  
     Player1.setPlace(uInput2, sPlaces, places);}


public void look(Player Player1){
    
    System.out.print(Player1.getPlace().getDesc());
    System.out.println();}


public void list()
{
    String uInput2 = keyboard.next().trim();
   switch(uInput2){
   case "places":
    int l = sPlaces.length;
    System.out.print("You have discovered: ");
    for(int i = 0; i<l; i++){if(places[i].getKnown()){System.out.print(sPlaces[i] + "; ");}}
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
    int l = sPlaces.length;
    System.out.print("You have discovered: ");
    for(int i = 0; i<l; i++){if(places[i].getKnown()){System.out.print(sPlaces[i] + "; ");}}
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
    int l = sPlaces.length;
    for(int i = 0; i<l; i++){System.out.print(places[i].getName() +": " + places[i].region + "; ");}
    System.out.println();}

public void inv(){
 //   Player1.listInv;
    
}


public void get(){
    String uInput2 = keyboard.nextLine().trim();
    Player1.add(uInput2);}


public void talk(Scanner keyboard, NPC[] folks, String[] sFolks, Player Player1, Place[] places){
String NPCtoTalk = keyboard.next().toUpperCase();
NPC person = Utility.findNPCFromString(folks, sFolks, NPCtoTalk);
Place e = places[0];
if(person.getPlace()==Player1.getPlace()||person.getPlace()==e){
person.talk(places);}
else{System.out.println("That person is not here!");}
 

}


public void ex(){
String uInput2 = keyboard.nextLine().trim();
Thing toEx = Utility.findThingFromString(things, uInput2);
if(Player1.inv.contains(toEx)){System.out.println(toEx.desc);}
else{System.out.println("You don't have that...");}
}


//END COMMANDS BLOCK
//-------------
}
