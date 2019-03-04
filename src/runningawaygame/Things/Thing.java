
package runningawaygame.Things;


import runningawaygame.Place;
import runningawaygame.Utility;
import static runningawaygame.RunningAwayGame.*;

public class Thing {
    private int index;
    private String name = "default name";
    private Place location = placesList[0];
    private String desc = "default description";;

    public String getName(){return name;}
    public Place getLoc(){return location;}
    public String getDesc(){return desc;}
    public int getIndex(){return index;}
    
    public void setLoc(Place place){this.location = place;}
    
    ///File format:
        //<thing>
        //name
        //location
        //s<desc
        //c<cost
        //
    
    public Thing(String thingString, int index){
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
