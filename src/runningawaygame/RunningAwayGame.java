
package runningawaygame;
import runningawaygame.Things.Thing;
import java.io.*;
import java.util.*;



//last updated 3/3 2019
public class RunningAwayGame {
    
    public static Player Player1;
    public static Scanner keyboard = new Scanner(System.in);
    public static Thing[] thingsList;
    public static Place[] placesList;
    public static NPC[] NPClist;
public static boolean debug = true;


    
    public static void main(String[] args) throws IOException {

      
        
        Initialization.PlaceInit();
        Initialization.NPCInit();
        Initialization.ThingsInit();
        Initialization.playerInit();
        
      //all this shit is the while loop that actually runs the game
        boolean end = false; int n1 = 1; int n2 = 1;
       
        while(!end){String uInput = keyboard.next();
        //the command object
        Com com = new Com();   
if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /PRIMARY LOOP");
        switch(uInput){
            case "end": case "quit": end = true; break;      
            case "goto": case "go": com.go(Player1, placesList); break;
            case "look": com.look(Player1); break;
            case "list": com.list(); break;
            case "talk": com.talk(keyboard, NPClist, Player1, placesList); break;
            case "get": com.get(); break;
            case "inv": com.list("inv"); break;
            case "ex": com.ex(); break;
            //debug coms
            case "$p": com.trueListPlaces(); break;
            case "$r": System.out.println(Player1.getPlace().region); break;
            case "$t": for(Thing thing : thingsList){System.out.print(thing.getName() + ":" + thing.getLoc().getName() +"; "); break;}
                        
            default: System.out.println("Try something that isn't stupid how about");}
        }//END PRIMARY WHILE LOOP
        }
        

    
}//END
