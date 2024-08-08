/*
*
* [VideoGameStore.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeaul]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 1]
*
* PURPOSE: [Main class for Video game line up]
*/
import java.util.*;
import java.io.*;

public class VideoGameStore{
    public static final String FILE = "example.txt"; 
   
    public static void main(String[]args){
        int numCopy = 0;
        BufferedReader br; 
        String line = "";
        Queue queue = new GameQueue();
        System.out.println("Welcome to " + FILE + " video game store simulation!");
        try{
            br = new BufferedReader(new FileReader(FILE));
            //The first line of txt.file is the number of copies of the game
            line = br.readLine();
            numCopy = Integer.parseInt(line); 
            System.out.println(numCopy + " Copies of the video game are available");
            
            while((line = br.readLine()) != null){
                //If the line is "PURCHASE", then first check if the queue is empty or not. If the queue is not empty then decrease the number of copies of the game
                //Then execute the "purchase method"
                if(line.equals("PURCHASE")){    
                    if(!queue.isEmpty()){                
                        numCopy--;
                    }
                    purchase(queue,numCopy);
                    //System.out.println(queue.peek());
                    //queue.displayQueue();
                }     
                //If the line is not "PURCHASE", then add buyer to the line 
                else{
                    queue.enqueue(line);
                    System.out.println(line + " joined the queue");
                }
            }
            //If the line is null, then print the message that display number of remaining copies or number of buyers did not purchase the game
           if(line == null){
             remanining(queue, numCopy);
           }
        } catch(FileNotFoundException ffe){
            System.out.println(ffe.getMessage());
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    //Purchase method takes queue and number of copies as parameters. 
    //When the line is "PURCHASE", this method will be applied
    //This method check the condition of queue and number of copies:
    //If the queue is not empty and the number of copy is larger or equals to zero, then it remove the first person in the queue and print out the first person name and number of copies left
    //If the number of copies is less than or equal to zero, then the message notifying sold out will be printed
    public static void purchase(Queue queue, int numCopy){
        if(!queue.isEmpty() && numCopy >= 0){ 
             System.out.println(queue.dequeue() + " purchased a game. " + numCopy + " copy(s) left.");
        }    
        if(numCopy <= 0){
            System.out.println("Video games sold out. ");
        }
    }
    //The remaining method takes queue and number of copies as parameters.
    //When the line is null, this method will be executed 
    //This method check the condition of queue and number of copies:
    //If the number of copies is larger than 0 and queue is not empty, then print message that notifying store closed and remaining people comeback later
    //If the number of copies is larger than 0 but queue is empty, then print the number of left copies 
    //If the number of copies is 0, then print the message that notifying the game sold out and number of remaining people going home without games
    public static void remanining(Queue queue, int numCopy){
        if(numCopy > 0 && !queue.isEmpty()){
            System.out.println("Store closed before everyone got there game. " + queue.size() + " people need to come back tomorrow.");
        }
        if(queue.isEmpty() && numCopy > 0){
            System.out.println("There are " + numCopy + " copies left.");
        }
        if(numCopy <= 0 && !queue.isEmpty()){
            System.out.println("Video games sold out. " + queue.size() + " persons(s) going home without games.");
        }
    }
}