
package runningawaygame;

import runningawaygame.Things.Thing;
import java.util.Scanner;
import static runningawaygame.RunningAwayGame.*;

public class Utility {
   
public static String fileReader(String toRead){
         toRead = toRead.replace("%n", "\n");
         if (toRead.charAt(0) == '<'){
             String specialCom = toRead.substring(1, 5);
             toRead = toRead.substring(6);   
             specialCom(specialCom);
         }       
         return toRead;       
    }




public static Place findPlaceFromString(String placeString)throws SearchFailedException{
    for(int i = 0; i < placesList.length; i++){
        if(placesList[i].getName().equals(placeString)){
            return placesList[i];
            }
         }
    System.out.println("\nError, place not found, returning places[0]");
    if(debug) System.out.println("placeString: " + placeString + "\n");
    throw new SearchFailedException();
}
  
public static NPC findNPCFromString(String NPCname)throws SearchFailedException{
    for(int i = 0; i < NPClist.length; i++){
        if(NPClist[i].getName().equals(NPCname)){
            return NPClist[i];
            }
         }
    if(debug) System.out.println("\nError, NPC not found, returning places[0]");
    if(debug) System.out.println("placeString: " + NPCname + "\n");
    throw new SearchFailedException();
}

public static Thing findThingFromString(String thingName)throws SearchFailedException{
    for(int i = 0; i < thingsList.length; i++){
        if(thingsList[i].getName().equals(thingName)){
            return thingsList[i];
            }
         }
    System.out.println("\nError, thing not found, returning thingsList[0]");
    if(debug) System.out.println("placeString: " + thingName + "\n");
    throw new SearchFailedException();
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
