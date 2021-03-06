
package runningawaygame;
import java.util.ArrayList;  
import java.io.*;                   
import java.util.Scanner;
import runningawaygame.RunningAwayGame.*;


public class Place {
    public static ArrayList<NPC> people = new ArrayList<>();
    private String name = "default_name"; 
    private String desc = "default_desc";
    private String arrivalText = "you arrive at ";
    private boolean known = false; 
    private boolean secret = false;
    int region = -1;
     
    public void setName(String name){this.name = name;}

    
    //regions:
    //-1 = default
    //0 = everywhere
    //1* = home
    //2* = in town
    //3* = out of town
    

public Place(String fullString)throws IOException { 
    if(fullString.contains("[name]")){
if(RunningAwayGame.debug){System.out.println("[name] = true");}
        int a = fullString.indexOf("[name]");
        int b = fullString.indexOf("[/name]");
         String thisName = fullString.substring(a, b);
         thisName = thisName.replace("[name]", "").trim();
         this.name = thisName;  
         this.arrivalText += name;
}
    if(fullString.contains("k>")){
         int a = fullString.indexOf("k>");
         String thisK = fullString.substring(a+3, a+4);
         if(thisK.trim().equals("")){System.out.println("Error: Likely spacing error in Known tag\n");}
if(RunningAwayGame.debug){System.out.println("thisK: " + thisK);}        
         switch(thisK){
             case "y": known = true; break;
             case "n": known = false; break;
             case "s": known = false; secret = true; break;
    }
}
    else{System.out.println("no k... " );}
    
    if(fullString.contains("[desc]")){
         int a = fullString.indexOf("[desc]");
         int b = fullString.indexOf("[/desc]");
         String thisDesc = fullString.substring(a, b);
         thisDesc = thisDesc.replace("[desc]", "").trim();
         this.desc = thisDesc;  
}
    if(fullString.contains("r>")){
         int a = fullString.indexOf("r>");
         String thisr = fullString.substring(a+3, a+5);
         if(thisr.trim().equals("")){System.out.println("Error: Likely spacing error in Region tag\n");} 
         this.region = Integer.parseInt(thisr);
    }
}    



public String getName() {return name;} 
public String getDesc() {return desc;}
public boolean getKnown() {return known;}
public boolean getSec() {return secret;}
public int getRegion() {return region;}
public String getArrivalText() {return arrivalText;}

public void setKnown(Boolean known){this.known = known;}




}//END