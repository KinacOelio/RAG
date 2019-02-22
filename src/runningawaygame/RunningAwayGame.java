
package runningawaygame;
import java.io.*;
import java.util.*;



//last updated 2/21 2019 8:11
public class RunningAwayGame {
    
    public static Player Player1;
    public static Scanner keyboard = new Scanner(System.in);
    public static Thing[] things;
    public static String[] sThings;
    public static String[] sPlaces;
    public static Place[] places;
    public static NPC[] folks;
    public static String[] sFolks;
public static boolean debug = false;


    
    public static void main(String[] args) throws IOException {
        Initialization.PlaceInit();
        Initialization.NPCInit();
        Initialization.ThingsInit();
     
        //INITIALIZING PLAYER.
if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /PLAYER INIT");
        Player1 = new Player(places[1], folks, places);
        Player1.inv.add(things[1]);
        
        
        //all this shit is the while loop that actually runs the game
        boolean end = false; int n1 = 1; int n2 = 1;
       
        while(!end){String uInput = keyboard.next();{
if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /PRIMARY LOOP");
        switch(uInput){
            case "end": case "quit": end = true; break;      
            case "goto": case "go": comGoto(Player1, sPlaces, places); break;
            case "look": comLook(Player1); break;
            case "list": comList(); break;
            case "talk": comTalk(keyboard, folks, sFolks, Player1, places); break;
            case "get": comGet(); break;
            case "inv": comList("inv"); break;
            case "ex": comEx(); break;
            //debug coms
            case "$p": comTrueListPlaces(); break;
            case "$r": System.out.println(Player1.getPlace().region); break;
            case "$t": for(Thing thing : things){System.out.print(thing.name + ":" + thing.location.getName() +"; ");}
                        
            default: System.out.println("Try something that isn't stupid how about");}
        }
        }
        

    
} 
//-------------------------------------------------     
//the list of command methods for the switch statement      
public static void comGoto(Player Player1, String[] sPlaces, Place[] places){
    
     String uInput2 = keyboard.nextLine().trim();  
     Player1.setPlace(uInput2, sPlaces, places);}

public static void comLook(Player Player1){
    
    System.out.print(Player1.getPlace().getDesc());
    System.out.println();}

public static void comList()
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
public static void comList(String input2){
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

public static void comTrueListPlaces(){
    int l = sPlaces.length;
    for(int i = 0; i<l; i++){System.out.print(places[i].getName() +": " + places[i].region + "; ");}
    System.out.println();}

public static void comInv(){
 //   Player1.listInv;
    
}

public static void comGet(){
    String uInput2 = keyboard.nextLine().trim();
    Player1.add(uInput2);}

public static void comTalk(Scanner keyboard, NPC[] folks, String[] sFolks, Player Player1, Place[] places){
String NPCtoTalk = keyboard.next().toUpperCase();
NPC person = Utility.findNPCFromString(folks, sFolks, NPCtoTalk);
Place e = places[0];
if(person.getPlace()==Player1.getPlace()||person.getPlace()==e){
person.talk(places);}
else{System.out.println("That person is not here!");}
 

}

public static void comEx(){
String uInput2 = keyboard.nextLine().trim();
Thing toEx = Utility.findThingFromString(things, uInput2);
if(Player1.inv.contains(toEx)){System.out.println(toEx.desc);}
else{System.out.println("You don't have that...");}
}


//END COMMANDS BLOCK
//-------------


} //END
