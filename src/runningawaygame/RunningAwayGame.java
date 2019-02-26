
package runningawaygame;
import java.io.*;
import java.util.*;



//last updated 2/26 2019
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
        Initialization.playerInit();
        
      //all this shit is the while loop that actually runs the game
        boolean end = false; int n1 = 1; int n2 = 1;
       
        while(!end){String uInput = keyboard.next();
        Com com = new Com();   
if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /PRIMARY LOOP");
        switch(uInput){
            case "end": case "quit": end = true; break;      
            case "goto": case "go": com.go(Player1, sPlaces, places); break;
            case "look": com.look(Player1); break;
            case "list": com.list(); break;
            case "talk": com.talk(keyboard, folks, sFolks, Player1, places); break;
            case "get": com.get(); break;
            case "inv": com.list("inv"); break;
            case "ex": com.ex(); break;
            //debug coms
            case "$p": com.trueListPlaces(); break;
            case "$r": System.out.println(Player1.getPlace().region); break;
            case "$t": for(Thing thing : things){System.out.print(thing.name + ":" + thing.location.getName() +"; ");}
                        
            default: System.out.println("Try something that isn't stupid how about");}
        }//END PRIMARY WHILE LOOP
        }
        

    
}//END
