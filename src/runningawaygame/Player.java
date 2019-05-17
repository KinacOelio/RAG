
package runningawaygame;

import runningawaygame.Things.Thing;
import java.util.ArrayList;
import java.util.List;
import static runningawaygame.RunningAwayGame.*;

public class Player {
    private Place currentPlace;
    private int placeIndex;
    public ArrayList<Thing> inv = new ArrayList<>();
    private ArrayList<String> sInv = new ArrayList<>();
    private double cash = 12.10;

    
    public Player(Place start, NPC[] folks, Place[] places){
        
        currentPlace = start;
        

        folks[0].talk();
        System.out.println("As you take a deep breath, you think of the various things you can do. You can GOTO a LOCATION,\n"
                + "you can LIST the various PLACES that you have access to, \n"
                + "you can also LIST your (INV)ENTORY, \n"
                + "you can LOOK around the area you are in, \n"
                + "and you can TALK to a PERSON who is in the same area as you.\n"
                + "you can GET THINGS in the same area as you,\n"
                + "and you can (EX)AMINE a thing that you have.\n"
                + "It does not have to be in caps though. You are not sure why your were thinking those words like that.\n ");

    }
    
    public void setPlace(Place place){this.currentPlace = place;}
    
    public Place getPlace(){return currentPlace;}
    public ArrayList<Thing> getInv(){return inv;}
    
    public boolean OKcheck(Place newPlace){
        return newPlace.getKnown();
       }
    
    public void add(String StoAdd){
        Thing toAdd;
        try{
            toAdd = Utility.findThingFromString(StoAdd);
        }catch(Exception SearchFailedException){
            return;
        }
        
        if(toAdd.getName().equals("nothing") 
        || toAdd.gettable == false){
            return;
        }
           
        if(toAdd.getPlace()!=currentPlace){System.out.println("As far as I, This Method, am aware, that does not exist or is not here");} 
        inv.add(toAdd);
        System.out.println("you pick up the " + toAdd.getName());
        sInv.add(toAdd.getName());
        toAdd.setLoc(placesList[0]);
        
        
        
    }
    public void listInv(){
        for(int i = 0; i < sInv.size(); i++){
           // System.out.print(sInv<i>);    
        }   
    }
    

    
    
    
    
    
    
}//END

