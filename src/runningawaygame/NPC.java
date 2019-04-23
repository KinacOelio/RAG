
package runningawaygame;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import static runningawaygame.RunningAwayGame.*;

public class NPC {
    private Place currentPlace;
    private String name;
    private String[] dialogue;
    private int[][] dialogueChoices;
    Scanner keyboard = new Scanner(System.in);
    String[] commands;
    
       public Place getPlace(){return currentPlace;}
       public String getName() {return name;}
    
    public NPC(String name, Place currentPlace)throws IOException{
        //TODO::: In constructor, load in array of options
        
        this.name = name;
        this.currentPlace = currentPlace;     
        File people = new File("People.txt");
        Scanner peepScan2 = new Scanner(people);
        
        
        String theLine = peepScan2.nextLine();
        while(!theLine.equals(name)){
            theLine = peepScan2.nextLine();
            //System.out.println(theLine + " name loop");
            }
        while(!theLine.equals("dialogue")){
            theLine = peepScan2.nextLine();
            //System.out.println(theLine + " dialogue loop");
        }
        
        String nLinesS = peepScan2.nextLine();
        int nLines = Integer.parseInt(nLinesS);
        dialogue = new String[nLines];
        for(int i = 0; i < nLines; i++){
            
        String diString = peepScan2.nextLine().substring(1);      
        dialogue[i] = Utility.fileReader(diString);}
        
        dialogueChoices = new int[nLines][4];
        
        while(!theLine.equals("choices")){
            theLine = peepScan2.nextLine();}
        
        for(int i = 0; i < nLines; i++){
            String[] choiceArrayS = peepScan2.nextLine().split(",");
            int[] choiceArray = new int[4];
            choiceArray[0] = Integer.parseInt(choiceArrayS[0]);
            choiceArray[1] = Integer.parseInt(choiceArrayS[1]);
            choiceArray[2] = Integer.parseInt(choiceArrayS[2]);
            choiceArray[3] = Integer.parseInt(choiceArrayS[3]);
            dialogueChoices[i] = choiceArray;
        }
        
    }
    
    public void talk(){
        System.out.println(dialogue[0]);
        boolean exit = false;
        int currentDi = 0;
        int diChoice = 1;
        while(exit == false){   
            //System.out.println(dialogueChoices[currentDi][0] + "x" +  dialogueChoices[currentDi][1] + dialogueChoices[currentDi][2] + dialogueChoices[currentDi][3] );
            String diChoiceS = keyboard.next(); 
            if(diChoiceS.equals("end")||diChoiceS.equals("quit")){System.out.println("[dialogo termenada]\n"); return;}
          try{
            diChoice = Integer.parseInt(diChoiceS);
          
          if(diChoice < 5 && diChoice > -1){
             //System.out.println("Current dialogue level: " + currentDi + " value at array base: "+ dialogueChoices[currentDi][diChoice] + " value at array inner -: "+ dialogueChoices[currentDi][diChoice-1] + " value at array both -: " + (dialogueChoices[currentDi][diChoice-1]-1));
            currentDi = dialogueChoices[currentDi][diChoice-1]-1;
            //System.out.println("Current dialogue level: " + currentDi + " value at array: "+ dialogueChoices[currentDi][diChoice]);
            if(currentDi == -1){System.out.println("[dialogo completedad]\n");return;}       
            if(dialogue[currentDi].charAt(0)=='%'){
                
            String theLine = dialogue[currentDi];
            commands = theLine.substring(1).split("%");
            System.out.println("Got here!!! Test: " + commands[0] );
            command(commands[0], runningawaygame.RunningAwayGame.placesList);
            System.out.println("Got here!!! Test: " + commands[0] );
            }
            if(dialogue[currentDi].charAt(0)=='%'){System.out.println(commands[1]);}
            else{System.out.println(dialogue[currentDi]); }}
            
          else{System.out.println("That is not an option!");}
         }
            catch(Exception NumberFormatException){System.out.println("I'm not sure about that!\n"); System.out.println(dialogue[currentDi]);}
        }
        }
           
 
    
    public void command(String command, Place[] places) throws Exception{
        System.out.print("  Got to the command method! "  + command.substring(0, 4));
        if("know".equals(command.substring(0, 4))){
            String toLearn = command.substring(4).trim();
            System.out.println("  got to to toLearn part! " + toLearn);
            Place toChange = Utility.findPlaceFromString(toLearn);
            System.out.println("  got past the toChange bit " + toChange.getName());
            toChange.setKnown(Boolean.TRUE);
        }
        
    }
        
    
    
    
}//END

