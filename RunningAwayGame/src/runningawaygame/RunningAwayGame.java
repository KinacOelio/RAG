
package runningawaygame;
import java.io.*;
import java.util.*;




public class RunningAwayGame {
    public static Player Player1;
    public static Scanner keyboard = new Scanner(System.in);
    public static Thing[] things;
    public static String[] sThings;
    public static String[] sPlaces;
    public static Place[] places;
    public static boolean debug = false;
String x = "asd";

    
    public static void main(String[] args) throws IOException {
        
        //INITILIZING LOCATIONS
        //TODO: CONVERT PLACES ARRAY TO AUTOMATICALLY GENERATE (via constructor)
if(debug)System.out.println("runningawaygame.RunningAwayGame.main()/LOCATION INIT");
        File Places = new File("Places.txt");  //creating file
        Scanner pScan = new Scanner(Places);    //creating scanner
        int Nplaces  = Integer.parseInt(pScan.next()); //getting number of places
             places = new Place[Nplaces]; //setting arrays to number of places
             sPlaces = new String[Nplaces];
        for(int i = 0; i < Nplaces; i++){  //for loop of length number of places
          Utility.gotoPoint(pScan, "[loc]"); //scans until reaching loc tag
          String NPCtempString = pScan.nextLine();
          String NPCfullString = NPCtempString;
          while(!NPCtempString.equals("[/loc]")){
               NPCtempString = pScan.nextLine();
               NPCfullString = NPCfullString + NPCtempString + " \n";
          }
        places[i] = new Place(NPCfullString);
        }
        for(int i = 0; i < Nplaces; i++){sPlaces[i] = places[i].getName(); 
       // Utility.setsPlaces(sPlaces, places);
        } //creates string array of places from regular array
        
        //INITIALIZING NPC's
if(debug)System.out.println("runningawaygame.RunningAwayGame.main()/NPC INIT");
        //something something politics
        NPC[] folks = new NPC[100];
        String[] sFolks = new String[100];
        File people = new File("People.txt");
        Scanner peepScan = new Scanner(people);
        int folksN = 0;
        
        //this block is messy...
        String cnt = "cnt";
        while(!cnt.equals("END")){
        cnt = Utility.gotoPoint(peepScan, "NPC");
        if(!cnt.equals("END")){
        String NPCname = peepScan.nextLine();
            sFolks[folksN] = NPCname;
        String NPCplaceStr = peepScan.nextLine(); 
if(debug)System.out.println("places.length:"+places.length + "  sPlaces.length:" +  sPlaces.length + "  folksN:" + folksN);
        Place NPCplace = Utility.findPlaceFromString(places, sPlaces, NPCplaceStr);
        folks[folksN] = new NPC(NPCname, NPCplace);
        folksN++;
        }}
        peepScan.close();
        //-----------
       
        
      

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

        things = new Thing[nThings];
        sThings = new String[nThings];
        
        for(int i = 0; i < nThings; i++){

            Utility.gotoPoint(thingScanner, "[thing]");
            String tempThing = thingScanner.nextLine();
            String thingString = tempThing;
            while(!tempThing.equals("[/thing]")){
                tempThing = thingScanner.nextLine();
                thingString += " \n " + tempThing;    
            }
            things[i] = new Thing(thingString);          
        }
        
          //-----------
          
          
        //INITIALIZING PLAYER. This is probably a stupid way to do this but here we are 
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
            case "$p": comTrueListPlaces(sPlaces); break;
            case "$r": System.out.println(Player1.getPlace().region); break;
                        
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

public static void comList(){
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

public static void comTrueListPlaces(String sPlaces[]){
    int l = sPlaces.length;
    for(int i = 0; i<l; i++){System.out.print(sPlaces[i] + "; ");}
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
//------------------


} //END
