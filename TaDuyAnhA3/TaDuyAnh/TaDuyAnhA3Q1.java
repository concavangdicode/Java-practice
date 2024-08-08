/*
*
* [TaDuyAnhA3Q1.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: [Main class that create and manipulate a shopping list]
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class TaDuyAnhA3Q1{
    public static final String FILE = "D:/a3q1in.txt"; //Please change the file path when run the code
    public static ItemList shoppingList = new ItemList();
    public static ItemList purchaseList = new ItemList();
    public static void main(String[]args){
        shopping(FILE);
    }
    
    //this method receives String of file then read text file and create and print the shopping list and purchase list
    public static void shopping(String file){
        String line = "";
        String[]tokens;
    
        try{
            Scanner scanner = new Scanner(new File(file)); 
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                tokens = line.split(",");   

                String command = tokens[0]; //the first token in a line is the command
                int quantity = 0;
                String item = "";
                //if the command is 'need', it assigned the second token is quantity and the third token is the name. 
                //Then the item would be added to shopping list if it is not in the list or increase the quantity of it is already in the list. 
                if(command.equals("need")){
                    quantity = Integer.parseInt(tokens[1]); 
                    item = tokens[2];
                    shoppingList.increase(item,quantity);
                }
                //if the command is 'buy', it assigned the second token is quantity and the third token is the name. 
                //Then the item would be remove or decrease the quantity in shopping list. Meanwhile, in the purchase list, the item would be added if it is not in the list or increase the quantity of it is already in the list.
                else if(command.equals("buy")){
                    quantity = Integer.parseInt(tokens[1]); 
                    item = tokens[2];
                    shoppingList.decrease(item, quantity);
                    purchaseList.increase(item, quantity);
                }
                //if the command is 'list', both lists would be printed
                else if(command.equals("list")){
                    System.out.println("Shopping list"); 
                    shoppingList.print();
                    System.out.println("Purchase list");
                    purchaseList.print();
                }
              }    
            } catch(FileNotFoundException ffe){
                ffe.getMessage();
         }
       
    }
}