 
package runningawaygame.Things;


import java.util.ArrayList;
import runningawaygame.Place;
import runningawaygame.Utility;
import static runningawaygame.RunningAwayGame.*;

public class Thing {
    private int index;
    private String name = "default name";
    private Place location = placesList[0];
    private String desc = "default description";
    private ArrayList<Thing> required = new ArrayList<>();
    
    //flags
    public boolean isTransport = false;
    public boolean usable = true;
    public boolean gettable = true;
    
    
    public String getName(){
        //boolean isUsable = true;
        //for(Thing req : required){
           // if(!Player1.inv.contains(req))
              //  isUsable = false;        
       // }
        //isUsable = this.usable;
        return name;
    
    }
    public Place getPlace(){return location;}
    public String getDesc(){return desc;}
    public int getIndex(){return index;}
    public Place getLoc() {return this.location;}
    
    public void setLoc(Place place){this.location = place;}
    
    ///File format:
        //<thing>
        //name
        //location
        //s<desc
        //
    
    public Thing(String thingString, int index)throws Exception{
        this.index = index;
        if(thingString.contains("n>")){
         int a = thingString.indexOf("n>");
         int b = thingString.substring(a).indexOf('\n');
         String thisName = thingString.substring(a+2, b+a).trim();     
         this.name = thisName;
         
    }

        if(thingString.contains("p>")){
         int a = thingString.indexOf("p>");
         int b = thingString.substring(a).indexOf('\n');
         String thisPlaceS = thingString.substring(a+2, b+a).trim();     
         this.location = Utility.findPlaceFromString(thisPlaceS);
    }    

 
}//end constructor
//-------------
    

    
}
