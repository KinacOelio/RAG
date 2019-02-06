
package runningawaygame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static runningawaygame.RunningAwayGame.debug;


public class Initialization {
    
public static void PlaceInit() throws IOException{
    
        //INITILIZING LOCATIONS
        //TODO: CONVERT PLACES ARRAY TO AUTOMATICALLY GENERATE (via constructor)
if(debug)System.out.println("runningawaygame.RunningAwayGame.main()/LOCATION INIT");
 File nPlacesf = new File("Places.txt");  //create file and scanner
        Scanner nPlacesScanner = new Scanner(nPlacesf);
        int nPlaces = 0;                                            
        //run through once to get nThings
        while(nPlacesScanner.hasNext()){String line = nPlacesScanner.nextLine(); 
                                      if(line.equals("[loc]")){nPlaces++;}}
        nPlacesScanner.close();
        
        File Places = new File("Places.txt");  //creating file
        Scanner pScan = new Scanner(Places);    //creating scanner
        RunningAwayGame.places = new Place[nPlaces]; //setting arrays to number of places
        RunningAwayGame.sPlaces = new String[nPlaces];
        
        for(int i = 0; i < nPlaces; i++){  //for loop of length number of places
          Utility.gotoPoint(pScan, "[loc]"); //scans until reaching loc tag
          String NPCtempString = pScan.nextLine();
          String NPCfullString = NPCtempString;
          while(!NPCtempString.equals("[/loc]")){
               NPCtempString = pScan.nextLine();
               NPCfullString = NPCfullString + NPCtempString + " \n";
          }
        RunningAwayGame.places[i] = new Place(NPCfullString);
        }
        for(int i = 0; i < nPlaces; i++){RunningAwayGame.sPlaces[i] = RunningAwayGame.places[i].getName(); 
        } //creates string array of places from regular array
      
}

public static void NPCInit() throws IOException{  
     //INITIALIZING NPC's
if(debug)System.out.println("runningawaygame.RunningAwayGame.main()/NPC INIT");
        //something something politics
        RunningAwayGame.folks = new NPC[100];
        RunningAwayGame.sFolks = new String[100];
        File people = new File("People.txt");
        Scanner peepScan = new Scanner(people);
        int folksN = 0;
         
        //this block is messy...
        String cnt = "cnt";
        while(!cnt.equals("END")){
        cnt = Utility.gotoPoint(peepScan, "NPC");
        if(!cnt.equals("END")){
        String NPCname = peepScan.nextLine();
            RunningAwayGame.sFolks[folksN] = NPCname;
        String NPCplaceStr = peepScan.nextLine(); 
if(debug)System.out.println("places.length:"+ RunningAwayGame.places.length + "  sPlaces.length:" +  RunningAwayGame.sPlaces.length + "  folksN:" + folksN);
        Place NPCplace = Utility.findPlaceFromString( RunningAwayGame.places, RunningAwayGame.sPlaces, NPCplaceStr);
        RunningAwayGame.folks[folksN] = new NPC(NPCname, NPCplace);
        folksN++;
        }}
        peepScan.close();
        //-----------
       
    
}
    
public static void ThingsInit() throws IOException {
     //INITIALIZING THINGS
if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /THINGS INIT");
        File nThingsF = new File("Things.txt");  //create file and scanner
        Scanner nThingScanner = new Scanner(nThingsF);
        int nThings = 0;                                            
        //run through once to get nThings
        while(nThingScanner.hasNext()){String line = nThingScanner.nextLine(); 
                                      if(line.equals("[thing]")){nThings++;}}
        
        File Things = new File("Things.txt");  //new scanner time
        Scanner thingScanner = new Scanner(Things);                             
       
if(debug) System.out.println("Things: " + nThings);

        RunningAwayGame.things = new Thing[nThings];
        RunningAwayGame.sThings = new String[nThings];
        
        for(int i = 0; i < nThings; i++){

            Utility.gotoPoint(thingScanner, "[thing]");
            String tempThing = thingScanner.nextLine();
            String thingString = tempThing;
            while(!tempThing.equals("[/thing]")){
                tempThing = thingScanner.nextLine();
                thingString += " \n " + tempThing;    
            }
        if(thingString.contains("$tr")){
        RunningAwayGame.things[i] = new Transportation(thingString, i);}
        else{RunningAwayGame.things[i] = new Thing(thingString, i);}        
        }
        
}//-----------
          
    
    
    
}
