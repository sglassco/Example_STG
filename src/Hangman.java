/*CS131 Project 1 by Sam Glassco
 * Hangman.java
 */

import java.util.*;
import java.io.*;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException,IOException{
      
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
          int wins = 0;
          int losses = 0;
          int TWins = 0;
          int TLosses = 0;
          int c = 0;
          int w = 0;
          boolean play = true;
          boolean pa = false;
          boolean weArePlaying = false;
          int a = 0;
          String wList[] = new String[200];
        
        //files to read/write words/scores
        Scanner readFile = new Scanner(new FileReader("C:\\CS131\\Dictionary.txt"));    
        Scanner inFile = new Scanner(new FileReader("C:\\CS131\\HMScore.txt"));
        
        //fill words into array
        while (readFile.hasNextLine()) {         
          wList[w] = readFile.nextLine();
          w++;
        }
        readFile.close();
        
    //Load total win/loss
      while (inFile.hasNextInt()){   
        if (c == 0){
          TWins = TWins + (inFile.nextInt() - TWins);
          c = 1;
        }else if (c == 1){
          TLosses = TLosses + (inFile.nextInt() - TLosses);
          c = 0;
        }
      }
      
      
      //playing    
      while (play){
        System.out.println("Play? (Yes/No)");
        String p = scan.nextLine();
      if(p.equalsIgnoreCase("no")|| p.equalsIgnoreCase("n")){
        System.out.println("Goodbye!");
        try {
          Thread.sleep(2000); // 2 seconds 
        } catch (InterruptedException ex) {
        }
        System.exit(1);        
      }else if(p.equalsIgnoreCase("yes")|| p.equalsIgnoreCase("y")){
        play = false;
        weArePlaying = true;
      }else{
        System.out.println("Sorry, try again (yes/no)...");
      }
      }
      
      //playGame
      while(weArePlaying){
    	  int guesses = 5;
         System.out.println("You have " + guesses + " incorrect guesses, please guess a letter.");
         int rNum = random.nextInt(200);
         char rWord[] = wList[rNum].toCharArray(); // java -> j,a,v,a
         char playerGuess[] = new char[rWord.length]; // "_ _ _ _ _ _ _ _"
         
         for(int i=0; i<playerGuess.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
           playerGuess[i] =  '_';
         }
         
         boolean wordIsGuessed = false;     
            
         while(!wordIsGuessed && guesses != 0){
        	 print(playerGuess);
        	 a= 0;
             System.out.printf("You have " + guesses + " guesses left.");
             System.out.println("Enter a single character: ");
             char input = scan.nextLine().charAt(0);
                
             if(input == '-'){
               wordIsGuessed = true;
               weArePlaying = false;
             }else{
               for(int i=0; i<rWord.length; i++){
                 if(rWord[i] == input){
                   playerGuess[i] = input;
                   a++;
                 } 
               }
             if(a == 0){
               guesses = guesses - 1;
             } 
                
                    
             if(isTheWordGuessed(playerGuess)){
               wordIsGuessed = true;
               System.out.println("Congratulations");
               wins++;
               pa = true;
             }
            }
            } // End of wordIsGuessed 
            if(!wordIsGuessed){
                System.out.println("You ran out of guesses.");
                pa = true;
                losses++;
            }         
                                 
            //play again
            while (pa){
              System.out.println("Would you like to play again? (yes/no)");
              String p = scan.nextLine();
              if(p.equalsIgnoreCase("no")|| p.equalsIgnoreCase("n")){
                System.out.println("Win/Loss This Round: " + wins + " / " + losses);
                TWins = TWins + wins;
                TLosses = TLosses + losses;
                writeWL(TWins,TLosses);
                System.out.println("Total Win/Loss: " + TWins + " / " + TLosses);
                
                System.out.println("Goodbye!");                                
                try {
                  Thread.sleep(8000); 
                } catch (InterruptedException ex) {
                }
                System.exit(1);
              }else if(p.equalsIgnoreCase("yes")|| p.equalsIgnoreCase("y")){
                pa = false;
                weArePlaying = true;
              }else{
               System.out.println("Sorry, try again...");
              }
            } 
        }//End of We Are Playing
      inFile.close();
      scan.close();
    }
    
    public static void writeWL(int x, int y) throws IOException {
        String tRecord = x + " " + y;  
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/CS131/HMScore.txt"));
        writer.write(tRecord);
        writer.close();
    }
    
    public static void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        } 
        System.out.println();
    }
    
    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}