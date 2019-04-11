
package runningawaygame;

import runningawaygame.Things.Thing;
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
    public List<Thing> inv = new ArrayList<>();
    private List<String> sInv = new ArrayList<>();
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
    
    public void setPlace(String choice, Place[] placeList){      
        Place toPlace = Utility.findPlaceFromString(choice);
        this.currentPlace = toPlace;
    }
    
    public Place getPlace(){return currentPlace;}
    public List<Thing> getInv(){return inv;}
    
    public boolean OKcheck(Place newPlace){
        return newPlace.getKnown();
       }
    
    public void add(String StoAdd){
        runningawaygame.Things.Gettable toAdd = (runningawaygame.Things.Gettable)Utility.findThingFromString(thingsList, StoAdd);
        if(toAdd.getName().equals("nothing")){return;}
        if(toAdd.getPlace()!=currentPlace){System.out.println("As far as I, This Method, am aware, that does not exist or is not here");} 
        inv.add(toAdd);
        System.out.println(toAdd.getText());
        sInv.add(toAdd.getName());
        toAdd.setLoc(placesList[0]);
        
        
        
    }
    public void listInv(){
        for(int i = 0; i < sInv.size(); i++){
           // System.out.print(sInv<i>);    
        }   
    }
    

    
    
    
    
    
    
}//END

