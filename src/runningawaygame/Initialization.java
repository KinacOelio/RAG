
package runningawaygame;

import runningawaygame.Things.Transportation;
import runningawaygame.Things.Thing;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static runningawaygame.RunningAwayGame.*;


public class Initialization {
    
    //this class creates the arrays that contain the objects that are used
    //the arrays can be found in the feilds of RunningAwayGame.class
    //Currently, the places and things arrays are initialized by first scanning
    //and counting the numver of entries. The array is then set to that length
    //and it scans a second time
    //A string is then created for each entry using scanner.next and concatonation
    //people is still some what different and needs to be updated
    //TODO: update people init
    //TODO: decide wether or not to use global variables and clean up code accordingly
    
public static void PlaceInit() throws IOException{
    
        //INITILIZING LOCATIONS
if(debug)System.out.println("runningawaygame.RunningAwayGame.main()/LOCATION INIT");
 File nPlacesf = new File("Places.txt");  //create file and scanner
        Scanner nPlacesScanner = new Scanner(nPlacesf);
        int nPlaces = 0;                                            
        //run through once to get nThings
        while(nPlacesScanner.hasNext()){String line = nPlacesScanner.nextLine(); 
                                      if(line.equals("[loc]")){nPlaces++;}}
        nPlacesScanner.close();
        
        File PlacesF = new File("Places.txt");  //creating file
        Scanner pScan = new Scanner(PlacesF);    //creating scanner
        RunningAwayGame.placesList = new Place[nPlaces]; //setting arrays to number of places
        
        for(int i = 0; i < nPlaces; i++){  //for loop of length number of places
          Utility.gotoPoint(pScan, "[loc]"); //scans until reaching loc tag
          String NPCtempString = pScan.nextLine();
          String NPCfullString = NPCtempString;
          while(!NPCtempString.equals("[/loc]")){
               NPCtempString = pScan.nextLine();
               NPCfullString = NPCfullString + NPCtempString + " \n";
          }
        RunningAwayGame.placesList[i] = new Place(NPCfullString);   
        }
      
}

public static void NPCInit() throws IOException{  
     //INITIALIZING NPC's
if(debug)System.out.println("runningawaygame.RunningAwayGame.main()/NPC INIT");
        //something something politics
        RunningAwayGame.NPClist = new NPC[100];
        File peopleF = new File("People.txt");
        Scanner peopleScan = new Scanner(peopleF);
        int folksN = 0;
         
        //this block is messy...
        String cnt = "cnt";
        while(!cnt.equals("END")){
        cnt = Utility.gotoPoint(peopleScan, "NPC");
        if(!cnt.equals("END")){
        String NPCname = peopleScan.nextLine();
        String NPCplaceStr = peopleScan.nextLine(); 
if(debug)System.out.println("places.length:"+ RunningAwayGame.placesList.length + "  sPlaces.length:" +  RunningAwayGame.placesList.length + "  folksN:" + folksN);
        Place NPCplace = Utility.findPlaceFromString(NPCplaceStr);
        RunningAwayGame.NPClist[folksN] = new NPC(NPCname, NPCplace);
        folksN++;
        }}
        peopleScan.close();
        //-----------
       
    
}
    
public static void ThingsInit() throws IOException {
     //INITIALIZING THINGS
if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /THINGS INIT");
        //create file and scanner
        File nThingsF = new File("Things.txt"); 
        Scanner nThingScanner = new Scanner(nThingsF);
        int nThings = 0;                                            
        //run through once to get nThings
        while(nThingScanner.hasNext()){String line = nThingScanner.nextLine(); 
                                      if(line.equals("[thing]")){nThings++;}}
        //new scanner time  
        File ThingsF = new File("Things.txt");
        Scanner thingScanner = new Scanner(ThingsF);                             
       
if(debug) System.out.println("Things: " + nThings);
        //setting the length of the array
        RunningAwayGame.thingsList = new Thing[nThings];
        
        //for loop: first bit creates the thingString, second bit instantiates
        for(int i = 0; i < nThings; i++)
        {
            Utility.gotoPoint(thingScanner, "[thing]");
            String tempThing = thingScanner.nextLine();
            String thingString = tempThing;
            while(!tempThing.equals("[/thing]"))
            {
                tempThing = thingScanner.nextLine();
                thingString += " \n " + tempThing;    
            }
            if(thingString.contains("$tr")){
            RunningAwayGame.thingsList[i] = new Transportation(thingString, i);}
            else{
                RunningAwayGame.thingsList[i] = new Thing(thingString, i);
if(debug) System.out.println( RunningAwayGame.thingsList[i].getName());
            }        
        }
        
}

public static void playerInit(){
  if(debug)System.out.println("runningawaygame.RunningAwayGame.main() /PLAYER INIT");
        Player1 = new Player(placesList[1], NPClist, placesList);
        Player1.inv.add(thingsList[1]);  
}

//-----------
          
    
    
    
}
