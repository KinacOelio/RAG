
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

    
    
    ///File format:
        //<thing>
        //name
        //location
        //s<desc
        //c<cost
        //
    
    public Thing(String thingString, int index){
        this.index = index;
//if(RunningAwayGame.debug){System.out.println("thingString: " + thingString);} 
        if(thingString.contains("n>")){
         int a = thingString.indexOf("n>");
         int b = thingString.substring(a).indexOf('\n');
//if(RunningAwayGame.debug){System.out.println("thisb: " + b);}  
         String thisName = thingString.substring(a+2, b).trim();
//if(RunningAwayGame.debug){System.out.println("thisName: " + thisName);}        
         this.name = thisName;
    }

 
}//end constructor
//-------------
    
    public String getName(){return name;}
    public Place getLoc(){return location;}
    
}
