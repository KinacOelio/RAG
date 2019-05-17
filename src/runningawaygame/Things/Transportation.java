
package runningawaygame.Things;

import runningawaygame.Things.Thing;


public class Transportation extends Thing {
    
    public Transportation(String thingString, int index) throws Exception{
    super(thingString, index);
    this.isTransport = true;
    this.usable = false;  
    }   
     
}
