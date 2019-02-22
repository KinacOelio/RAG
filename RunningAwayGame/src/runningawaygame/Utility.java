/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
package runningawaygame;

import java.util.Scanner;
import static runningawaygame.RunningAwayGame.*;



public class Utility {
    public static  String[] sPlaces1;
    public static Place[] places;

    
    
public static String fileReader(String toRead){
         toRead = toRead.replace("%n", "\n");
         if (toRead.charAt(0) == '<'){
             String specialCom = toRead.substring(1, 5);
             toRead = toRead.substring(6);   
             specialCom(specialCom);
         }       
         return toRead;       
    }


public static Place findPlaceFromString(Place[] places, String[] sPlaces, String placeString){
    for(int i = 0; i < places.length; i++){
        if(sPlaces[i].equals(placeString)){
            return places[i];
            }
         }
    System.out.println("\nError, place not found, returning places[0]");
if(debug) System.out.println("placeString: " + placeString + "\n");
    return places[0];
}
  

public static NPC findNPCFromString(NPC[] folks, String[] sFolks, String placeString){
    int index = 0;
    try{
    while(!sFolks[index].equalsIgnoreCase(placeString)){
        index++;}
    return folks[index];}
    catch(Exception e){System.out.println("hmm, that isn't a person, you seem to be talking to yourself."); return folks[1]; }
    }


public static Thing findThingFromString(Thing[] things, String thingString){
    
    for(int i = 0; i < things.length; i++){
        if(things[i].name.equals(thingString)){
            return things[i];}
         }
    
    System.out.println("As far as I, This Method, am aware, that does not exist or is not here");
    return things[0];
}
    
public static String gotoPoint(Scanner scan, String gotoString){
            
            String tempString = "";
            //System.out.println("entering gotoPoint while loop");
            while(!tempString.equals(gotoString)){
            tempString = scan.nextLine();  
            //System.out.println(tempString);
            if(tempString.equals("END")){return "END";}
        }
            return "continue";   
}


public static void specialCom(String comString){
    switch(comString){
        case"get ": 
    }
}

//public static boolean arrayCheckString(Str
//        ing[] stringArray, String string){
//    for(int i = 0)
//    
//}

}//END
