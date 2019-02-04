
package runningawaygame;

import java.util.ArrayList;
import java.util.List;
import static runningawaygame.RunningAwayGame.*;

/**
 *
 * @author natoast
 */
public class Player {
    private Place currentPlace;
    private int placeIndex;
    public List<Thing> inv = new ArrayList<Thing>();
    private List<String> sInv = new ArrayList<String>();
    private double cash = 12.10;

    
    public Player(Place start, NPC[] folks, Place[] places){
        
        currentPlace = start;
        

        folks[0].talk(places);
        System.out.println("As you take a deep breath, you think of the various things you can do. You can GOTO a LOCATION,\n"
                + "you can LIST the various PLACES that you have access to, \n"
                + "you can also LIST your (INV)ENTORY, \n"
                + "you can LOOK around the area you are in, \n"
                + "and you can TALK to a PERSON who is in the same area as you.\n"
                + "you can GET THINGS in the same area as you,\n"
                + "and you can (EX)AMINE a thing that you have.\n"
                + "It does not have to be in caps though. You are not sure why your were thinking those words like that.\n ");
        
        
        
    }
    
    public void setPlace(String choice, String[] sPlaces, Place[] places){      
       // System.out.println("running 1 with " + choice);
        for (int i = 0; i < sPlaces.length; i++){
            //System.out.println("running 2, comparing to " + sPlaces[i]);
            if(choice.equals(sPlaces[i])){
             //   System.out.println(places[i].getKnown() + "running 3");
                placeIndex = i;
                Place newPlace = places[i];
                if(OKcheck(newPlace))
                {currentPlace = newPlace;               
                System.out.println("You are now at " + choice); return;}
                else  {System.out.println("invalid or unknown location");  return;}
            }     
        }
        System.out.println("invalid or unknown location");  return;
    }
    
    public Place getPlace(){return currentPlace;}
    public List<Thing> getInv(){return inv;}
    
    public boolean OKcheck(Place newPlace){
        return newPlace.getKnown();
       }
    
    public void add(String StoAdd){
        Thing toAdd = Utility.findThingFromString(things, StoAdd);
        if(toAdd.getName().equals("nothing")){return;}
        if(toAdd.getLoc()!=currentPlace){System.out.println("As far as I, This Method, am aware, that does not exist or is 1not here");}
        inv.add(toAdd);
        sInv.add(toAdd.getName());
        toAdd.location = places[0];
        
        
        
    }
    public void listInv(){
        for(int i = 0; i < sInv.size(); i++){
           // System.out.print(sInv<i>);
            
        }
        
        
    }
    

    
    
    
    
    
    
}//END

