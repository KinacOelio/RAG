
package runningawaygame;

import static runningawaygame.RunningAwayGame.*;
//
public class Transportation extends Thing {
    public Transportation(String ThingString, int index){
    super(ThingString, index);
    this.tr = true;
   
}  
    
public static void trAdd(Thing thing){
 if (thing.name.equals("bike")){
        for (Place place : places) {
            if (place.region < 30 && !place.getSec()){place.setKnown(true);}     
    }      
  System.out.println("You got a shiny new bike!");
 } 
}

}
