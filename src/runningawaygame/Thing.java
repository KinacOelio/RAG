
package runningawaygame;


import static runningawaygame.RunningAwayGame.*;

public class Thing {
    private int index;
    private boolean stolen = false;
    protected String name = "default name";
    private String sPlace = "default place";
    public Place location = places[0];
    public String desc = "default description";
    private double cost = 0.0;
    public boolean tr = false;
    public String getText = "You got ";

    
    
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
         this.getText += this.name;
    }

        if(thingString.contains("p>")){
         int a = thingString.indexOf("p>");
         int b = thingString.substring(a).indexOf('\n');
         String thisPlaceS = thingString.substring(a+2, b+a).trim();     
         this.location = Utility.findPlaceFromString(thisPlaceS);
    }    

 
}//end constructor
//-------------
    
    public String getName(){return name;}
    public Place getLoc(){return location;}
    
}
